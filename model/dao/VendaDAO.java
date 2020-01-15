/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model.dao;

import lojatds.model.CompraEVenda;
import lojatds.model.Venda;

/**
 * Interface VendaDAO
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public interface VendaDAO extends CompraEVendaDAO<Venda> {
    /**
     * Método efetuar venda
     * @param t Objeto venda
     * @return true para sucesso e false para falha
     * @throws DatabaseException  Erro na conexão do banco
     */
    boolean efetuarVenda(Venda t) throws DatabaseException;
}
