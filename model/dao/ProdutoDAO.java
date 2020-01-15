/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model.dao;

import java.util.List;
import lojatds.model.Produto;

/**
 * Interface ProdutoDAO
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public interface ProdutoDAO extends GenericDAO<Produto> {
    
    /**
     * Método atualizar produto
     * @param p Produto
     * @return true para sucesso e false para falha
     * @throws DatabaseException Erro na conexão do banco
     */
    boolean atualizar(Produto p) throws DatabaseException;
    
    /**
     * Método buscar produto
     * @param nome Nome produto
     * @return Produto desejado
     * @throws DatabaseException Erro na conexão do banco
     */
    Produto buscar(String nome) throws DatabaseException;
    
    /**
     * Método get Lista de compra
     * @param cod Código compra
     * @return Lista dos produto em uma compra
     * @throws DatabaseException Erro na conexão do banco
     */
    public List<Produto> getListaDeCompra(int cod) throws DatabaseException;
    
    /**
     * Método get Lista de venda
     * @param cod Código venda
     * @return Lista dos produto em uma venda
     * @throws DatabaseException Erro na conexão do banco
     */
    public List<Produto> getListaDeVenda(int cod) throws DatabaseException;
}
