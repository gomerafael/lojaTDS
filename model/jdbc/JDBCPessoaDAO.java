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
import lojatds.model.Pessoa;
import lojatds.model.dao.DatabaseException;
import lojatds.model.dao.PessoaDAO;

/**
 * Classe abstrata JDBCPessoaDAO
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */

public abstract class JDBCPessoaDAO<T extends Pessoa> extends JDBCAbstractDAO implements PessoaDAO<T> {
    
    //ConnectionFactory conex = new ConnectionFactory();
    //Pessoa pes = new Pessoa();
    
    /**
     * Construtor da classe
     */
    public JDBCPessoaDAO() {
        super();
    }
    
    /**
     * Método para atualizar pessoa
     * @param t Objeto pessoa
     * @return true para sucesso e false para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    
    @Override
    public boolean atualizar(T t) throws DatabaseException {
        String sql = "UPDATE pessoa " +
                " SET nome_pessoa=?, telefone_pessoa = ?, cep_pessoa= ?, "
                + "cidade_pessoa=?, logradouro_pessoa=?, uf_pessoa=?" +
                " WHERE cod_pessoa=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getNome());
            ps.setString(2, t.getTelefone());
            ps.setString(3, t.getCEP());
            ps.setString(4, t.getCidade());
            ps.setString(5, t.getLogradouro());
            ps.setString(6, t.getUF());
            ps.setInt(7, t.getCodigo());
            int r = ps.executeUpdate();
            ps.close();
            return r == 1;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * Método para inserir pessoa
     * @param t Objeto pessoa
     * @return true para sucesso e false para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public boolean inserir(T t) throws DatabaseException {
        //conex.getConnection();
        
        String sql = "insert into pessoa(nome_pessoa, telefone_pessoa, CEP_pessoa, cidade_pessoa, "
                + "logradouro_pessoa, UF_pessoa,cod_pessoa)"
                + " values (?, ?, ?, ?, ?, ?,?)";
        try {
            
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, t.getNome());
            ps.setString(2, t.getTelefone());
            ps.setString(3, t.getCEP());
            ps.setString(4, t.getCidade());
            ps.setString(5, t.getLogradouro());
            ps.setString(6, t.getUF());
            t.setCodigo(getNextCodigo());
            ps.setInt(7, t.getCodigo());
            
            
            int r = ps.executeUpdate();
            ps.close();
            return r == 1;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
    
    /**
     * Método para remover pessoa
     * @param t Objeto pessoa
     * @return true para sucesso e false para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    @Override
    public boolean remover(T t) throws DatabaseException {
        String sql = "DELETE FROM pessoa "
                + " WHERE cod_pessoa=?";
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
     * Método getNextCodigo
     * @return nextval
     * @throws SQLException Erro na conexão com o banco
     */
    private int getNextCodigo() throws SQLException {
        String sql = "select nextval('pessoa_cod_pessoa_seq')";
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        rs.next();
        return rs.getInt("nextval");
    }

}
