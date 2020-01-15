/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model.dao;

import java.util.List;
import lojatds.model.Cliente;

/**
 * Interface ClienteDAO
 * @author Patrick, Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public interface ClienteDAO extends PessoaDAO<Cliente>  {
    
    /**
     * Método buscar cliente
     * @param nome Nome cliente
     * @return cliente
     * @throws DatabaseException Erro na conexão do banco
     */
    Cliente buscar(String nome) throws DatabaseException;
}
