/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model.dao;
import lojatds.model.Compra;
import lojatds.model.CompraEVenda;
/**
 * Interface CompraDAO
 * @author Patrick, Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public interface CompraDAO extends CompraEVendaDAO<Compra> {

 /**
 * Método efetuar
 * @param t Compra/venda
 * @return true para compra efetuada com sucesso e false para falha durante a compra
 * @throws DatabaseException Erro na conexão do banco
 */
    boolean efetuarCompra(Compra t) throws DatabaseException;
}
