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
import lojatds.model.Compra;
import lojatds.model.Fornecedor;
import lojatds.model.Produto;
import lojatds.model.dao.CompraDAO;
import lojatds.model.dao.DatabaseException;

/**
 * Classe JDBCCompraDAO
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public class JDBCCompraDAO extends JDBCCompraEVenda<Compra> implements CompraDAO {
    

    /**
     * Método para conveter o rs em compra
     * @param rs ResultSet a ser covertido
     * @return Objeto Compra
     * @throws SQLException Erro na conexão com o banco
     * @throws DatabaseException Erro na conexão com o banco
     */
    private Compra getInstance(ResultSet rs) throws SQLException, DatabaseException {
        Compra compra = new Compra();
        JDBCFornecedorDAO f = new JDBCFornecedorDAO();
        JDBCProdutoDAO p = new JDBCProdutoDAO();

        compra.setCod(rs.getInt("codigo_compra"));
        compra.setFornecedor(f.buscar(rs.getInt("cod_fornecedor")));
        compra.setTotal(rs.getFloat("total_compra"));
        compra.setLista(p.getListaDeCompra(rs.getInt("codigo_compra")));

        return compra;
    }
    
    /**
     * Método para adicionar ao carrinho
     * @param lista Lista de produtos
     * @param cod Código produto
     * @return 1 pra produto adicionado, 0 para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public boolean addCarrinho(List<Produto> lista, int cod) throws DatabaseException {
        
        String sql = "insert into produtos_compra(cod_compra, quantidade_compra, "
                + "valor_total_produto,cod_produto) "
                + "values (?, ?, ?,?)";
       for(Produto p : lista){
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.setInt(2, p.getQuantidade());
            ps.setFloat(3, p.getPrecoDeCompra() * p.getQuantidade());
            ps.setInt(4, p.getCodigo());

            int r = ps.executeUpdate();
            ps.close();
            return r == 1;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
       }
       return true;
    }

    
    /**
     * Método para inserir no compra
     * @param t Compra a ser inserida
     * @return 1 pra compra inserida, 0 para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public boolean inserir(Compra t) throws DatabaseException {
        String sql = "insert into compra(cod_fornecedor,total_compra,codigo_compra) "
                + "values (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, t.getFornecedor().getCodigo());
            ps.setFloat(2, t.getTotal());
            t.setCod(getNextCodigo());
            ps.setInt(3, t.getCod());
            //ps.setDate(1, (20,20,20));
            
            
            int r = ps.executeUpdate();
            addCarrinho(t.getLista(),t.getCod());
            efetuarCompra(t);
            
            
            ps.close();     
            return r == 1;
            
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
    
    /**
     * Método para remover compra do banco
     * @param t Compra a ser removida
     * @return 1 pra compra removida, 0 para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public boolean remover(Compra t) throws DatabaseException {
        String sql = "DELETE FROM compra " +
                     " WHERE codigo_compra=?";
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
     * Método para listar todas as compra
     * @return listas de todas as compra
     * @throws DatabaseException Erro na conexão com o banco
     */
    
    @Override
    public List<Compra> listarTodos() throws DatabaseException {
        String sql = "select * from compra order by codigo_compra";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Compra> compra = new ArrayList<>();
            while (rs.next()) {
                compra.add(getInstance(rs));
            }
            rs.close();
            ps.close();
            return compra;            
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
    
    /**
     * Método para buscar compra
     * @param codigo Código da compra
     * @return Compra desejada
     * @throws DatabaseException Erro na conexão com o banco
     */
    
    @Override
    public Compra buscar(int codigo) throws DatabaseException {
        String sql = "select * from compra WHERE codigo_compra=?";
        PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
            // prepared statement para busca
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, codigo);

            // executa um select
            rs = stmt.executeQuery();
	    Compra compra = null;
	    if (rs.next()) {
		compra = getInstance(rs);
            }			
            rs.close();
            stmt.close();
            return compra;
	} catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
	}
    }

    /**
     * Método não implementado
     */
    @Override
    public List<Compra> selecionar(String nome) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método para efetuar compra
     * @param t Compra a ser efetuada
     * @return 1 pra compra efetuada, 0 para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public boolean efetuarCompra(Compra t) throws DatabaseException {
        boolean retorno = true;
        String sql = "select * from produtos_compra where cod_compra = ?";
        
        try {
            JDBCProdutoDAO lista = new JDBCProdutoDAO();
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setInt(1, t.getCod());
            
            ResultSet rs = ps.executeQuery();
            
            
            List<Produto> produtos = lista.getListaDeCompra(t.getCod());
            List<Produto> estoque = lista.listarTodos();
            
            for (Iterator<Produto> iterator = estoque.iterator(); iterator.hasNext();) {
                Produto next = iterator.next();
                for (Iterator<Produto> iterator1 = produtos.iterator(); iterator1.hasNext();) {
                    Produto next1 = iterator1.next();
                    if(next.getCodigo() == next1.getCodigo()){
                        next.setQuantidade(next.getQuantidade() + next1.getQuantidade());
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
     * Método para obeter o codigo proximo codigo
     * @return proximo codigo do do banco
     * @throws SQLException Erro na conexão com o banco
     */
    private int getNextCodigo() throws SQLException {
        String sql = "select nextval('compra_cod_seq')";
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        rs.next();
        return rs.getInt("nextval");
    }

}
