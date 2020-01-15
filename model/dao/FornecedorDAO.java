/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model.dao;

import java.util.List;
import lojatds.model.Cliente;
import lojatds.model.Fornecedor;


/**
 * Interface FornecedorDAO
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public interface FornecedorDAO extends PessoaDAO<Fornecedor> {
    
    /**
     * Método buscar fornecedor
     * @param nome Nome fornecedor
     * @return fornecedor
     * @throws DatabaseException Erro na conexão do banco
     */
    Fornecedor buscar(String nome) throws DatabaseException;

}
