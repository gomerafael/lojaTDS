/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model.dao.jdbc;

import java.sql.Connection;

/**
 * Classe JDBCAbstractDAO
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public class JDBCAbstractDAO {
    protected Connection connection;
    
    public JDBCAbstractDAO() {
        connection = ConnectionFactory.getConnection();
    }
}
