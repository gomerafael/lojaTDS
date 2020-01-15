/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lojatds.model.Produto;
import lojatds.model.Venda;
import lojatds.model.dao.DatabaseException;
import lojatds.model.dao.VendaDAO;

/**
 * Classe JDBCProdutoDAO
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public class JDBCVendaDAO extends JDBCCompraEVenda<Venda> implements VendaDAO {
    
    /**
     * Método transformar o rs no objeto venda
     * @param rs objeto do bancoa ser convertido
     * @return Objeto venda
     * @throws SQLException Erro na coexão com o banco
     * @throws DatabaseException Erro na coexão com o banco
     */
    private Venda getInstance(ResultSet rs) throws SQLException, DatabaseException  {
        Venda venda = new Venda();
        JDBCClienteDAO c = new JDBCClienteDAO();
        JDBCProdutoDAO p = new JDBCProdutoDAO();
        
        venda.setCod(rs.getInt("codigo_venda"));
        venda.setCliente(c.buscar(rs.getInt("codigo_cliente")));
        venda.setTotal(rs.getFloat("total_venda"));
        venda.setLista(p.getListaDeVenda(rs.getInt("codigo_venda")));
        
        return venda;
    }
    
    /**
     * Método para adiciona ao carrinho
     * @param lista Lista de compra
     * @param cod codigo do produto a ser adicionado
     * @return 1 para produto cadastrado, 0 para falha
     * @throws DatabaseException Erro na coexão com o banco
     */
    @Override
    public boolean addCarrinho(List<Produto> lista, int cod) throws DatabaseException {
        String sql = "insert into produtos_venda(cod_venda, quantidade_venda, "
                + " valor_total_produtos,cod_produto)"
                + "values (?,?,?,?)";
       for(Produto p : lista){
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.setInt(2, p.getQuantidade());
            ps.setFloat(3, p.getPrecoDeVenda() * p.getQuantidade());
            ps.setInt(4, p.getCodigo());

            int r = ps.executeUpdate();
            ps.close();
            

        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
       }
       return true;
    }

    /**
     * Método inserir venda no banco
     * @param t venda a ser inserida
     * @return 1 para inserção com exito, 0 para falha
     * @throws DatabaseException Erro na coexão com o banco
     */
    @Override
    public boolean inserir(Venda t) throws DatabaseException {
        String sql = "insert into venda(codigo_cliente,total_venda,codigo_venda) "
                + "values (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            

          
            ps.setInt(1, t.getCliente().getCodigo());
            ps.setFloat(2, t.getTotal());
            t.setCod(getNextCodigo());
            ps.setInt(3, t.getCod());
            //ps.setDate(1, (20,20,20));
            
            
            int r = ps.executeUpdate();
            addCarrinho(t.getLista(),t.getCod());
            efetuarVenda(t);
            
            
            ps.close();     
            return r == 1;
            
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Método remover venda no banco
     * @param t venda a ser removida
     * @return 1 para remoção com exito, 0 para falha
     * @throws DatabaseException Erro na coexão com o banco
     */
    @Override
    public boolean remover(Venda t) throws DatabaseException {
        String sql = "DELETE FROM venda" +
                     " WHERE codigo_venda=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getCod());
            int r = ps.executeUpdate();
            ps.close();
            return r == 1;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Método para listar todos as venda
     * @return Lista com todas as venda
     * @throws DatabaseException Erro na coexão com o banco
     */
    @Override
    public List<Venda> listarTodos() throws DatabaseException {
        String sql = "select * from venda order by codigo_venda";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Venda> venda = new ArrayList<>();
            while (rs.next()) {
                venda.add(getInstance(rs));
            }
            rs.close();
            ps.close();
            return venda;            
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
    
    /**
     * Método para buscar compra especifica
     * @param codigo Código da compra a ser pesquisada
     * @return venda desejada
     * @throws DatabaseException Erro na coexão com o banco
     */
    @Override
    public Venda buscar(int codigo) throws DatabaseException {
        String sql = "select * from venda WHERE codigo_venda=?";
        PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
            // prepared statement para busca
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, codigo);

            // executa um select
            rs = stmt.executeQuery();
	    Venda venda = null;
	    if (rs.next()) {
		venda = getInstance(rs);
            }			
            rs.close();
            stmt.close();
            return venda;
	} catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
	}
    }

    /**
     * Método não implementado 
     */
    @Override
    public List<Venda> selecionar(String nome) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método para efetuar a compra no banco
     * @param t Compra a ser efetuada
     * @return 1 para compra efetuada, 0 para falha
     * @throws DatabaseException Erro na coexão com o banco
     */
    @Override
    public boolean efetuarVenda(Venda t) throws DatabaseException {
        boolean retorno = true;
        String sql = "select * from produtos_venda where cod_venda = ?";
        
        try {
            JDBCProdutoDAO lista = new JDBCProdutoDAO();
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setInt(1, t.getCod());
            
            ResultSet rs = ps.executeQuery();
            
            
            List<Produto> produtos = lista.getListaDeVenda(t.getCod());
            List<Produto> estoque = lista.listarTodos();
            
            for (Iterator<Produto> iterator = estoque.iterator(); iterator.hasNext();) {
                Produto next = iterator.next();
                for (Iterator<Produto> iterator1 = produtos.iterator(); iterator1.hasNext();) {
                    Produto next1 = iterator1.next();
                    if(next.getCodigo() == next1.getCodigo()){
                        next.setQuantidade(next.getQuantidade() - next1.getQuantidade());
                    }
                }
                
            }
            
            for (Iterator<Produto> iterator = estoque.iterator(); iterator.hasNext();) {
                Produto next = iterator.next();
                if (lista.atualizar(next)){
                    retorno = true;
                }
            }
            
            return retorno;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
    
    /**
     * Método para pegar o proximo codigo
     * @return Número do proximo codigo
     * @throws SQLException Erro na coexão com o banco
     */
    private int getNextCodigo() throws SQLException {
        String sql = "select nextval('venda_cod_seq')";
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        rs.next();
        return rs.getInt("nextval");
    }
    
}
