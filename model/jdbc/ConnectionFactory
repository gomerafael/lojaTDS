/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe ConnectionFactory
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public class ConnectionFactory {
    private static Connection conn;
    private static final String URL =
            "jdbc:postgresql://localhost:5432/lojatds";
    
    /**
     * Método getConnection
     * @return conexao com o banco
     */
    public static Connection getConnection() {
        if (conn == null) {
            try {
                //https://jdbc.postgresql.org/
                //DriverManager.registerDriver(new org.postgresql.Driver());
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(URL, 
                        "postgres", "estrela");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.exit(1);                        
            }
        }
        return conn;
    }
    
}
