/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.controller;

import java.util.List;
import java.util.Observable;
import lojatds.model.dao.DAOFactory;
import lojatds.model.dao.DatabaseException;

/**
 * Controlador Generico
 * @author Rafael
 * @author Patrick
 * @param <T> Template para objeto de entrada
 * @version 2.0
 * @since 10/06/2016
 */
public abstract class GenericController<T> extends Observable {

    protected DAOFactory dao = null;

    /**
     * Contrutor da classe
     *
     * @param dao Conecçao com o banco
     */
    protected GenericController(DAOFactory dao) {
        this.dao = dao;
    }

    /**
     * Método para cadastrar
     * @param t Objeto a ser cadastrado
     * @return 1 exito ,0 para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    public abstract boolean cadastrar(T t) throws DatabaseException;

    /**
     * Método para excluir
     * @param cod Codigo do objeto a ser excluir
     * @return 1 exito ,0 para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    public abstract boolean excluir(int cod) throws DatabaseException;

    /**
     * Méetodo pesquisar pelo nome
     * @param nome Nome do Objeto a ser cadastrado
     * @return Lista com os objeto desejadao
     * @throws DatabaseException Erro na conexão com o banco
     */
    public abstract List<T> pesquisar(String nome) throws DatabaseException;

    /**
     *  Método atualizar Objeto
     * @param t objeto a ser atualizado
     * @return  1 para exito, 0 para falha
     * @throws DatabaseException Erro na conexão com o banco
     */
    public abstract boolean atualizar(T t) throws DatabaseException;

    /**
     * Listar todos os objeto do tipo T
     * @return Lista com todos os objeto T
     * @throws DatabaseException Erro na conexão com o banco
     */
    public abstract List<T> listar() throws DatabaseException;
}
