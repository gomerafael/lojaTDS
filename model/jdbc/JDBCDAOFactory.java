/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model.dao.jdbc;

import lojatds.model.dao.ClienteDAO;
import lojatds.model.dao.CompraDAO;
import lojatds.model.dao.CompraEVendaDAO;
import lojatds.model.dao.DAOFactory;
import lojatds.model.dao.FornecedorDAO;
import lojatds.model.dao.PessoaDAO;
import lojatds.model.dao.ProdutoDAO;
import lojatds.model.dao.VendaDAO;

/**
 * Classe JDBCDAOFactory
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public class JDBCDAOFactory extends DAOFactory{
    private static ClienteDAO clienteDAO;
    private static FornecedorDAO fornecedorDAO;
    private static ProdutoDAO produtoDAO;
    private static CompraDAO compraDAO;
    private static VendaDAO vendaDAO;
    
    
    /**
     * Método getClienteDAO
     * @return clienteDAO 
     */
    @Override
    public ClienteDAO getClienteDAO() {
        if(clienteDAO == null) {
            clienteDAO = new JDBCClienteDAO();
        }
        return clienteDAO;
    }
    
    /**
     * Método getCompraDAO
     * @return compraDAO
     */
    @Override
    public CompraDAO getCompraDAO() {
        if(compraDAO == null) {
            compraDAO = new JDBCCompraDAO();
        }
        return compraDAO;
    }

    /**
     * Método getFornecedorDAO
     * @return fornecedorDAO
     */
    @Override
    public FornecedorDAO getFornecedorDAO() {
        if(fornecedorDAO == null) {
            fornecedorDAO = new JDBCFornecedorDAO();
        }
        return fornecedorDAO;
    }
    
    /**
     * Método getProdutoDAO
     * @return produtoDAO
     */
    @Override
    public ProdutoDAO getProdutoDAO() {
        if(produtoDAO == null) {
            produtoDAO = new JDBCProdutoDAO();
        }
        return produtoDAO;
    }

    @Override
    public VendaDAO getVendaDAO() {
        if(vendaDAO == null){
                vendaDAO = new JDBCVendaDAO();
        }
        
        return vendaDAO;
    }
    
}
