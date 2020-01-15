/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * Classe que cria o objeto compra
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public class Compra extends CompraEVenda {  
    private Fornecedor fornecedor;


    /**
     * Construtor da Classe
     * @param fornecedor Fornecedor da compra
     * @param cod Código do cliente que realizou a compra 
     * @param total Total compra
     */
    public Compra(Fornecedor fornecedor, int cod, float total) {    
        super(cod, total);
        this.fornecedor = fornecedor;
    }

    /**
     * Construtor defaut
     */
    public Compra() {
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

   


    /**
     * Imprime uma nota fiscal da compra e 
     * os dados necessários
     */
  /*  public void notaFiscal(){
        System.out.println("--------------");
        System.out.println(" Nota fistcal de Compra");
        System.out.println("--------------");
        System.out.println("Cliente: " + fornecedor.getNome()+ "  " + fornecedor.getCodigo());
        System.out.println("Produtos: ");
        for (Iterator<Produto> iterator = getLista().iterator(); iterator.hasNext();) {
                Produto next = iterator.next();
            System.out.println(next.getNome() + " " + next.getQuantidade() + " X " +
                                next.getPrecoDeCompra() + " = " +
                                (next.getQuantidade() * next.getPrecoDeCompra()));
            total= total + (next.getQuantidade() * next.getPrecoDeCompra());
        }
        Caixa.compra(total);
        System.out.println("Total: " + total);
    }*/
     
}
