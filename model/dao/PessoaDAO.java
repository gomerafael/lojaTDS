/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model.dao;

import lojatds.model.Pessoa;

/**
 * Interface PessoaDAO
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */

public interface PessoaDAO<T extends Pessoa> extends GenericDAO<T>{
    
    /**
     * Método atualizar
     * @param t Objeto T
     * @return true para sucesso e false para falha
     * @throws DatabaseException Erro na conexão no banco
     */
    boolean atualizar(T t) throws DatabaseException;
    
    
}
