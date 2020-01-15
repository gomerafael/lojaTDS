/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model.dao;

import java.util.List;
import lojatds.model.CompraEVenda;
import lojatds.model.Pessoa;
import lojatds.model.Produto;

/**
 * Interface CompraEVendaDAO
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 * @param <T> templeite do para entrada de objeto
 */
 
 
public interface CompraEVendaDAO<T extends CompraEVenda > extends GenericDAO<T>{
    
    /**
     * Método add no carrinho
     * @param l Lista de produtos
     * @param cod Código produto
     * @return true para sucesso false para falha
     * @throws DatabaseException Erro na conexão do banco
     */
    public boolean addCarrinho(List<Produto> l,int cod) throws DatabaseException;
    
}
