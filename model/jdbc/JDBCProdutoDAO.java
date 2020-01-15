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
import java.util.List;
import lojatds.model.Produto;
import lojatds.model.dao.DatabaseException;
import lojatds.model.dao.ProdutoDAO;

/**
 * Classe JDBCProdutoDAO
 *
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public class JDBCProdutoDAO extends JDBCAbstractDAO implements ProdutoDAO {

    /**
     * Método getInstance
     *
     * @param rs ResultSet
     * @return produto
     * @throws SQLException Erro na conexão com o banco
     * @throws DatabaseException Erro na conexão com o banco
     */
    private Produto getInstance(ResultSet rs) throws SQLException, DatabaseException {
        Produto produto = new Produto();
        produto.setNome(rs.getString("nome_produto"));
        produto.setCodigo(rs.getInt("cod_produto"));
        produto.setQuantidade(rs.getInt("quantidade_produto"));
        produto.setPrecoDeCompra(rs.getFloat("preco_compra"));
        produto.setPrecoDeVenda(rs.getFloat("preco_venda"));
        return produto;
    }

    /**
     * Método para converter rs em produto de uma compra
     *
     * @param rs Resultset a ser convertido
     * @return Produto
     * @throws SQLException Erro na conexão com o banco
     * @throws DatabaseException Erro na conexão com o banco
     */
    private Produto getInstance2(ResultSet rs) throws SQLException, DatabaseException {

        Produto p = buscar(rs.getInt("cod_produto"));
        p.setQuantidade(rs.getInt("quantidade_compra"));
        return p;
    }

    /**
     * Método para converter rs em produto de uma venda
     *
     * @param rs Resultset a ser convertido
     * @return Produto
     * @throws SQLException Erro na conexão com o banco
     * @throws DatabaseException Erro na conexão com o banco
     */
    private Produto getInstance3(ResultSet rs) throws SQLException, DatabaseException {

        Produto p = buscar(rs.getInt("cod_produto"));
        p.setQuantidade(rs.getInt("quantidade_venda"));
        return p;
    }

    /**
     * Método atualizar produto
     *
     * @param p Objeto produto
     * @return true para sucesso e false para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public boolean atualizar(Produto p) throws DatabaseException {
        String sql = "UPDATE produto "
                + " SET nome_produto=?, quantidade_produto=?, preco_compra=?, "
                + "preco_venda=?"
                + " WHERE cod_produto=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getQuantidade());
            ps.setFloat(3, p.getPrecoDeCompra());
            ps.setFloat(4, p.getPrecoDeVenda());
            ps.setInt(5, p.getCodigo());
            int r = ps.executeUpdate();
            ps.close();
            return r == 1;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Método buscar produto
     *
     * @param nome Nome do produto
     * @return produto
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public Produto buscar(String nome) throws DatabaseException {
        String sql = "SELECT * FROM produto WHERE nome_produto=? ";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // prepared statement para busca
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, nome);

            // executa um select
            rs = stmt.executeQuery();
            Produto produto = null;
            if (rs.next()) {
                produto = getInstance(rs);
            }
            rs.close();
            stmt.close();
            return produto;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Método inserir produtos
     *
     * @param p Objeto produto
     * @return true para sucesso e false para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public boolean inserir(Produto p) throws DatabaseException {

        String sql = "insert into produto(nome_produto, quantidade_produto, preco_compra, "
                + "preco_venda) "
                + "values (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getQuantidade());
            ps.setFloat(3, p.getPrecoDeCompra());
            ps.setFloat(4, p.getPrecoDeVenda());

            int r = ps.executeUpdate();
            ps.close();
            return r == 1;

        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Método para remover produto
     *
     * @param t Objeto produto
     * @return true para sucesso e false para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public boolean remover(Produto t) throws DatabaseException {
        String sql = "DELETE FROM produto "
                + " WHERE cod_produto=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getCodigo());
            int r = ps.executeUpdate();
            ps.close();
            return r == 1;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Método para listar todos produtos
     *
     * @return produto
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public List<Produto> listarTodos() throws DatabaseException {
        String sql = "Select * from produto order by cod_produto";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Produto> produto = new ArrayList<>();
            while (rs.next()) {
                produto.add(getInstance(rs));
            }
            rs.close();
            ps.close();
            return produto;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Método buscar produto
     *
     * @param codigo Código produto
     * @return produto
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public Produto buscar(int codigo) throws DatabaseException {
        String sql = "SELECT * FROM produto WHERE cod_produto=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // prepared statement para busca
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, codigo);

            // executa um select
            rs = stmt.executeQuery();
            Produto produto = null;
            if (rs.next()) {
                produto = getInstance(rs);
            }
            rs.close();
            stmt.close();
            return produto;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Método selecionar produto
     *
     * @param nome Nome produto
     * @return produto
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public List<Produto> selecionar(String nome) throws DatabaseException {
        String sql = "Select * from produto where nome_produto like ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, "%" + nome + "%");

            ResultSet rs = ps.executeQuery();
            ArrayList<Produto> produto = new ArrayList<>();
            while (rs.next()) {
                produto.add(getInstance(rs));
            }
            rs.close();
            ps.close();
            return produto;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Método getListaDeCompra
     *
     * @param cod Código produto
     * @return produto
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public List<Produto> getListaDeCompra(int cod) throws DatabaseException {
        String sql = "Select * from produtos_compra where cod_compra=? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            ArrayList<Produto> produto = new ArrayList<>();
            while (rs.next()) {
                produto.add(getInstance2(rs));
            }
            rs.close();
            ps.close();
            return produto;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Método para obter lista de compra
     *
     * @param cod Código da compra desejada
     * @return Lista de produtos da compra
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public List<Produto> getListaDeVenda(int cod) throws DatabaseException {
        String sql = "Select * from produtos_venda where cod_venda=? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            ArrayList<Produto> produto = new ArrayList<>();
            while (rs.next()) {
                produto.add(getInstance3(rs));
            }
            rs.close();
            ps.close();
            return produto;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
