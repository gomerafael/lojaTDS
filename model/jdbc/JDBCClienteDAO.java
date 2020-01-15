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
import javax.swing.JOptionPane;
import lojatds.model.Cliente;
import lojatds.model.Pessoa;
import lojatds.model.dao.ClienteDAO;
import lojatds.model.dao.DatabaseException;


/**
 * Classe JDBCClienteDAO
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */

public class JDBCClienteDAO extends JDBCPessoaDAO<Cliente> implements ClienteDAO {
    
    public JDBCClienteDAO() {
        super();
    }
    /**
     * Método para converter rs em objeto cliente
     * @param rs ResultSet a ser convertido
     * @return Objeto cliente
     * @throws SQLException Erro na conexão com o banco
     * @throws DatabaseException Erro na conexão com o banco
     */
    private Cliente getInstance(ResultSet rs) throws SQLException,DatabaseException {
        Cliente cliente = new Cliente();
        cliente.setNome(rs.getString("nome_pessoa"));
        cliente.setCodigo(rs.getInt("cod_pessoa"));
        cliente.setTelefone(rs.getString("telefone_pessoa"));
        cliente.setCEP(rs.getString("cep_pessoa"));
        cliente.setCidade(rs.getString("cidade_pessoa"));
        cliente.setLogradouro(rs.getString("logradouro_pessoa"));
        cliente.setUF(rs.getString("uf_pessoa"));
        cliente.setCPF(rs.getString("cpf_cliente"));
        return cliente;        
    }
    
    /**
     * Método para buscar cliente
     * @param nome Nome cliente a ser buscado
     * @return cliente desejado
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public Cliente buscar(String nome) throws DatabaseException {
        String sql = "select * from cliente inner join pessoa on "
                + "cliente.cod_pessoa = pessoa.cod_pessoa WHERE nome_pessoa = ? " ;
        PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
            // prepared statement para busca
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, nome);

            // executa um select
            rs = stmt.executeQuery();
	    Cliente cliente = null;
	    if (rs.next()) {
		cliente = getInstance(rs);
            }			
            rs.close();
            stmt.close();
            return cliente;
	} catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
	}
    }
    
    /**
     * Método para atualizar cliente
     * @param t Objeto cliente a ser atualizado
     * @return true para cliente atualizado e false para falha
     * @throws DatabaseException  Erro na conexão com o banco
     */
    
    @Override
    public boolean atualizar(Cliente t) throws DatabaseException {
        super.atualizar(t);
        String sql = "UPDATE cliente " +
                " SET cpf_cliente = ?" +
                " WHERE cod_pessoa=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getCPF());
            ps.setInt(2, t.getCodigo());
            
            int r = ps.executeUpdate();
            ps.close();
            return r == 1;
            
         } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Método para inserir cliente
     * @param t Objeto clientea ser inserido
     * @return true para cliente inserido e false para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    
    @Override
    public boolean inserir(Cliente t) throws DatabaseException {
        super.inserir(t);
        String sql = "insert into cliente(cod_pessoa,cpf_cliente) "
                + "values (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setInt(1, t.getCodigo());
            ps.setString(2, t.getCPF());
            
            int r = ps.executeUpdate();
            ps.close();     
            return r == 1;
            
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Método para remover cliente
     * @param t Objeto cliente a ser removido
     * @return true para cliente removido e false para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    
    @Override
    public boolean remover(Cliente t) throws DatabaseException {
        //super.remover(t);
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
     * Método para buscar cliente
     * @param codigo Código cliente desejado
     * @return cliente desejado
     * @throws DatabaseException Erro na conexão com o banco
     */
    
    @Override
    public Cliente buscar(int codigo) throws DatabaseException {
        String sql = "select * from cliente inner join pessoa on "
                + "cliente.cod_pessoa = pessoa.cod_pessoa WHERE cliente.cod_pessoa=?";
        PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
            // prepared statement para busca
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, codigo);

            // executa um select
            rs = stmt.executeQuery();
	    Cliente cliente = null;
	    if (rs.next()) {
		cliente = getInstance(rs);
            }			
            rs.close();
            stmt.close();
            return cliente;
	} catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
	}
    }
    
    /**
     * Método para listar todos clientes
     * @return lista com todos os clientes
     * @throws DatabaseException Erro na conexão com o banco
     */
    
    @Override
    public List<Cliente> listarTodos() throws DatabaseException {
        String sql = "select * from cliente inner join pessoa on "
                + "cliente.cod_pessoa = pessoa.cod_pessoa order by pessoa.nome_pessoa";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                clientes.add(getInstance(rs));
            }
            rs.close();
            ps.close();
            return clientes;            
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Método para selecionar clientes
     * @param nome Nome dos clientes
     * @return Lista de cliente 
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public List<Cliente> selecionar(String nome) throws DatabaseException {
        String sql = "select * from cliente inner join pessoa on "
                + "cliente.cod_pessoa = pessoa.cod_pessoa where nome_pessoa like ?";
            
     try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, "%" +nome+ "%");
            
            ResultSet rs = ps.executeQuery();
            ArrayList<Cliente> cliente = new ArrayList<>();
            while (rs.next()) {
                cliente.add(getInstance(rs));
            }
            rs.close();
            ps.close();
            return cliente;            
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
        
    }
}


