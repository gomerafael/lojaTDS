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
import lojatds.model.Fornecedor;
import lojatds.model.dao.DatabaseException;
import lojatds.model.dao.FornecedorDAO;

/**
 * Classe JDBCFornecedorDAO
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public class JDBCFornecedorDAO  extends JDBCPessoaDAO<Fornecedor> implements FornecedorDAO {

    public JDBCFornecedorDAO() {
        super();
    }

    
    /**
     * Método getInstance
     * @param rs ResultSet
     * @return fornecedor
     * @throws SQLException Erro na conexão com o banco
     */
    private Fornecedor getInstance(ResultSet rs) throws SQLException {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(rs.getString("nome_pessoa"));
        fornecedor.setCodigo(rs.getInt("cod_pessoa"));
        fornecedor.setTelefone(rs.getString("telefone_pessoa"));
        fornecedor.setCEP(rs.getString("cep_pessoa"));
        fornecedor.setCidade(rs.getString("cidade_pessoa"));
        fornecedor.setLogradouro(rs.getString("logradouro_pessoa"));
        fornecedor.setUF(rs.getString("uf_pessoa"));
        fornecedor.setCNPJ(rs.getString("cnpj_fornecedor"));
        return fornecedor;        
    }
   
    /**
     * Método atualizar fornecedor
     * @param t Objeto fornecedor
     * @return true para sucesso e false para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    
    @Override
    public boolean atualizar(Fornecedor t) throws DatabaseException {
        super.atualizar(t);
        String sql = "UPDATE fornecedor " +
                " SET cnpj_fornecedor = ?" +
                " WHERE cod_pessoa=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getCNPJ());
            ps.setInt(2, t.getCodigo());
            
            int r = ps.executeUpdate();
            
            ps.close();
            return r == 1;
         } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
    
    /**
     * Método inserir fornecedor
     * @param t Objeto fornecedor
     * @return true para sucesso e false para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    
    @Override
    public boolean inserir(Fornecedor t) throws DatabaseException {
        super.inserir(t);
        String sql = "insert into fornecedor(cod_pessoa,cnpj_fornecedor) "
                + "values (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getCodigo());
            ps.setString(2, t.getCNPJ());
            

            int r = ps.executeUpdate();
            ps.close();     
            return r == 1;
            
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
    
    /**
     * Método para remover fornecedor
     * @param t Objeto fornecedor
     * @return true para sucesso e false para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    
    @Override
    public boolean remover(Fornecedor t) throws DatabaseException {
        String sql = "DELETE FROM pessoa " +
                     " WHERE cod_pessoa=?";
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
     * Método listar todos fornecedores
     * @return fornecedores
     * @throws DatabaseException Erro na conexão com o banco
     */
    
    @Override
    public List<Fornecedor> listarTodos() throws DatabaseException {
        String sql = "select * from fornecedor inner join pessoa on "
                + "fornecedor.cod_pessoa = pessoa.cod_pessoa order by pessoa.nome_pessoa";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Fornecedor> fornecedores = new ArrayList<>();
            while (rs.next()) {
                fornecedores.add( getInstance(rs));
            }
            rs.close();
            ps.close();
            return fornecedores;            
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
    
    /**
     * Método buscar fornecedores por código
     * @param codigo Código fornecedor
     * @return fornecedor
     * @throws DatabaseException Erro na conexão com o banco
     */
    
    @Override
    public Fornecedor buscar(int codigo) throws DatabaseException {
        String sql = "select * from fornecedor inner join pessoa on "
                + "fornecedor.cod_pessoa = pessoa.cod_pessoa WHERE fornecedor.cod_pessoa=?";
        PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
            // prepared statement para busca
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, codigo);

            // executa um select
            rs = stmt.executeQuery();
	    Fornecedor fornecedor = null;
	    if (rs.next()) {
		fornecedor = getInstance(rs);
            }			
            rs.close();
            stmt.close();
            return fornecedor;
	} catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
	}
    }
    
    /**
     * Método buscar fornecedores por nome
     * @param nome Nome fornecedor
     * @return fornecedor
     * @throws DatabaseException Erro na conexão com o banco
     */
     
    @Override
    public Fornecedor buscar (String nome) throws DatabaseException {
        String sql = "select * from fornecedor inner join pessoa on "
                + "fornecedor.cod_pessoa = pessoa.cod_pessoa WHERE nome_fornecedor = ? " ;
        PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
            // prepared statement para busca
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, nome);

            // executa um select
            rs = stmt.executeQuery();
	    Fornecedor fornecedor = null;
	    if (rs.next()) {
		fornecedor = getInstance(rs);
            }			
            rs.close();
            stmt.close();
            return fornecedor;
	} catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
	}
    }

    /**
     * Método selecionar fornecedor
     * @param nome Nome do fornecedor
     * @return fornecedor
     * @throws DatabaseException Erro na conexão com o banco
     */

    @Override
    public List<Fornecedor> selecionar(String nome) throws DatabaseException {
            String sql = "select * from fornecedor inner join pessoa on "
                + "fornecedor.cod_pessoa = pessoa.cod_pessoa where nome_pessoa like ?";
            
     try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, "%" +nome+ "%");
            
            ResultSet rs = ps.executeQuery();
            ArrayList<Fornecedor> fornecedor = new ArrayList<>();
            while (rs.next()) {
                fornecedor.add(getInstance(rs));
            }
            rs.close();
            ps.close();
            return fornecedor;            
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        } 
    }
}
