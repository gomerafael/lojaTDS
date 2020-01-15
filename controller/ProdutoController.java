/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.controller;

import java.util.List;
import lojatds.model.Produto;
import lojatds.model.dao.DAOFactory;
import lojatds.model.dao.DatabaseException;

/**
 * Classe controlador Produto
 * @author Rafael
 * @author Patrick
 * @version 2.0
 * @since 10/06/2016
 */
public class ProdutoController extends GenericController<Produto> {

    /**
     * Construtr da classe
     * @param dao conecçao com o banco
     */
    public ProdutoController(DAOFactory dao) {
        super(dao);
    }

    /**
     * Método cadastrar produto
     * @param t Produto a ser cadastrado
     * @return  1 para produto cadastrado, 0 para produto não condastrado
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public boolean cadastrar(Produto t) throws DatabaseException {
        boolean retorno = false;
        if (t != null) {            
            if (dao.getProdutoDAO().buscar(t.getCodigo()) == null) {
                retorno = dao.getProdutoDAO().inserir(t);
            } 
        }
        if (retorno == true) {
            setChanged();
            notifyObservers();
        }
        return retorno;
    }

    /**
     * Método excluir produto
     * @param cod Codigo do produto a ser excluido
     * @return 1 Para produto excluido 0 para falha
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public boolean excluir(int cod) throws DatabaseException {
        if (dao.getProdutoDAO().remover(dao.getProdutoDAO().buscar(cod))) {
            setChanged();
            notifyObservers();
            return true;
        }
        return false;
    }

    /**
     * Método atualizar produto
     * @param t Produto a ser atualizado
     * @return  1 para Produto atualizado, 0 para Produto não atualizado
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public boolean atualizar(Produto t) throws DatabaseException {
        boolean retorno = false;
        if (t != null) { 
           retorno = dao.getProdutoDAO().atualizar(t); 
        }
        
        if (retorno == true) {
            setChanged();
            notifyObservers();
        }
        
        return retorno;
    }

    /**
     * Lista para imprimir todos os produtos
     * @return Lista com todos os produtos
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public List<Produto> listar() throws DatabaseException {
        return dao.getProdutoDAO().listarTodos();
    }

    /**
     * Método para obter produtos com nome especifico
     * @param nome Nome desejado
     * @return Lista contendo apenas os produtos com nomes pesquisado
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public List<Produto> pesquisar(String nome) throws DatabaseException {
        return dao.getProdutoDAO().selecionar(nome);
    }
    
}
