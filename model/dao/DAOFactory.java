/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model.dao;

import lojatds.model.dao.jdbc.JDBCDAOFactory;

/**
 * Classe abstrata DAOFactory
 * @author Patrick, Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public abstract class DAOFactory {
    
    /**
     * Método getDAOFactory
     * @return JDBCDAOFactory
     */
    public static DAOFactory getDAOFactory() {
        
        return new JDBCDAOFactory();
    }
    
    /**
     * Método getClienteDAO
     * @return clienteDAO
     */
    public abstract ClienteDAO getClienteDAO();
    
    /**
     * Método getCompraDAO
     * @return compraDAO
     */
    public abstract CompraDAO getCompraDAO();
    
    /**
     * Método getFornecedorDAO
     * @return fornecedorDAO
     */
    public abstract FornecedorDAO getFornecedorDAO();
    
    /**
     * Método getProdutoDAO
     * @return produtoDAO
     */
    public abstract ProdutoDAO getProdutoDAO();
    
    /**
     * Método getVendaDAO
     * @return vendaDAO
     */
    public abstract VendaDAO getVendaDAO();
}
