/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * Classe para definir os atributos de compra e venda
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public abstract class CompraEVenda {
    private int cod;
    private static List<Produto> lista;
    private float total;
    
    
    /**
     * Construtor defaut
     */
    public CompraEVenda(){
       this.lista =  new LinkedList<>(); 
    }

    

    /**
     * Construtor defaut
     * @param cod Código da compra
     * @param total Total da compra/venda
     * 
     */
    public CompraEVenda(int cod, float total) {
        this.cod = cod;
        this.total = total;
    }
    

    /**
     * Método getCodigo
     * @return Código da compra
     */
    public int getCod() {
        return cod;
    }

    /**
     * Método setCodigo
     * @param cod Código do compra
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * Método getLista
     * @return Lista de compra
     */
    public  List<Produto> getLista() {
        return this.lista;
    }

    /**
     * Método setLista
     * @param lista Lista de compra
     */
    public  void setLista(List<Produto> lista) {
        CompraEVenda.lista = lista;
    }
    
    /**
     * Método add produto
     * @param p produto para ser adicionado
     * @return lista
     */
    public  List<Produto> addProduto(Produto p){
            lista.add(p);
        return lista;
    }
    
   
    
    public Produto buscanalista(Produto p){
        for (Iterator<Produto> iterator = lista.iterator(); iterator.hasNext();) {
            Produto next = iterator.next();
            if (next.getCodigo() == p.getCodigo()){
                return p;
            }
        }
        return null;
    }
    
    /**
     * Método remover produto
     * @param p produto a ser removido
     * @return lista 
     */
    public  List<Produto> removerProduto(Produto p){
        lista.remove(p);
        return lista;
    }
    

    
    /**
     * Método getTotal
     * @return total
     */
    public float getTotal() {
        return total;
    }
    /**
     * Método setTotal
     * @param total Total de compra/venda
     */
    public void setTotal(float total) {
        this.total = total;
    }
    
    
}
