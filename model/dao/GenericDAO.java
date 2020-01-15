/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model.dao;

import java.util.List;

/**
 * Interface GenericDAO
 * @author Patrick
 * 
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */

public interface GenericDAO<T> {
    
    /**
     * Método boolean Inserir
     * @param t Objeto T
     * @return true para sucesso false para falha
     * @throws DatabaseException Erro na conexão do banco
     */
    boolean inserir(T t) throws DatabaseException;
    
    /**
     * Método boolean Remover
     * @param t Objeto T
     * @return true para sucesso false para falha
     * @throws DatabaseException Erro na conexão do banco
     */
    boolean remover(T t) throws DatabaseException;
    
    /**
     * Método Listar todos
     * @return Lista com todos os objeto
     * @throws DatabaseException Erro na conexão do banco
     */
    List<T> listarTodos() throws DatabaseException;
    
    /**
     * Método buscar por código
     * @param codigo Código objeto 
     * @return Objeto
     * @throws DatabaseException Erro na conexão do banco
     */
    T buscar(int codigo) throws DatabaseException;
    
    /**
     * Método selecionar pelo nome
     * @param nome Nome objeto 
     * @return Lista com o objeto desejado
     * @throws DatabaseException Erro na conexão do banco
     */
    List<T> selecionar (String nome) throws DatabaseException;
    
}
