/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model.dao;

/**
 * Classe DatabaseException
 * @author Patrick, Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public class DatabaseException extends Exception{


    public DatabaseException() {
        super("Erro no Banco de Dados");
    }

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(Throwable cause) {
        super(cause);
    } 
    
    
}
