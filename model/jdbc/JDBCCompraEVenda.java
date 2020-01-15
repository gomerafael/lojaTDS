/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model.dao.jdbc;

import lojatds.model.CompraEVenda;
import lojatds.model.dao.CompraEVendaDAO;

/**
 * Classe abstrata JDBCCompraEVenda
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 * @param <T> tmplate para inserir o objeto
 */
public abstract class JDBCCompraEVenda<T extends CompraEVenda> extends JDBCAbstractDAO implements CompraEVendaDAO<T>{
    
    
}
