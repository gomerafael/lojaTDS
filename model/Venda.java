/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model;




/**
 * Classe que cria o objeto Venda
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public class Venda extends CompraEVenda {  
    private Cliente cliente;
    
    
    /**
     * * Construtor da classe
     * @param cod Código do cliente que participou da venda
     * @param cliente Objeto cliente que vai participar da venda
     * @param total Total da venda
     */
    public Venda(Cliente cliente, int cod, float total) {    
        super(cod, total);
        this.cliente = cliente;
    }

    /**
     * Construtor defaut
     */
    public Venda() {
    }
    /**
     * Método getCliente
     * @return cliente
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**
     * Método setCliente
     * @param cliente Cleinte a ser setado
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
   

    
}
