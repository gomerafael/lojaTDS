/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.controller;

import java.util.List;
import lojatds.model.Fornecedor;
import lojatds.model.dao.DAOFactory;
import lojatds.model.dao.DatabaseException;

/**
 * classe controlador fornecedor
 * @author Rafael
 * @author Patrick
 * @version 2.0
 * @since 10/06/2016
 */
public class FornecedorController extends GenericController<Fornecedor> {

    /**
     * cotrutor da classe
     * @param dao Conexão com o banco
     */
    public FornecedorController(DAOFactory dao) {
        super(dao);
    }
    
    /**
     * Método cadastrar e atualizar fornecedor
     * @param t Fornecedor a ser cadastrado
     * @return  1 para fornecedor cadastrado, 0 para fornecedor não condastrado
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public boolean cadastrar(Fornecedor t) throws DatabaseException {
        boolean retorno = false;
        if (t != null) {            
            if (dao.getFornecedorDAO().buscar(t.getCodigo()) == null) {
                retorno = dao.getFornecedorDAO().inserir(t);
            } else {
                retorno = dao.getFornecedorDAO().atualizar(t);
            }
        }
        if (retorno == true) {
            setChanged();
            notifyObservers();
        }
        return retorno;
    }

    /**
     * Método excluir fornecedor
     * @param cod Codigo do fornecedor a ser excluido
     * @return 1 Para fornecedor excluido 0 para falha
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public boolean excluir(int cod) throws DatabaseException {
        if (dao.getFornecedorDAO().remover(dao.getFornecedorDAO().buscar(cod))) {
            setChanged();
            notifyObservers();
            return true;
        }
        return false;
    }

    

    /**
     * Lista para imprimir todos os fornecedores
     * @return Lista com todos os fornecedores
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public List<Fornecedor> listar() throws DatabaseException {
        return dao.getFornecedorDAO().listarTodos();
    }

    /**
     * Metodo para aualizar dados do fornecedor 
     * @param t fornecedor a ser atualizado
     * @return 1 para atualização com suesso 0 para falha
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public boolean atualizar(Fornecedor t) throws DatabaseException {
        boolean retorno = false;
        if (t != null) { 
           retorno = dao.getFornecedorDAO().atualizar(t); 
        }
        
        if (retorno == true) {
            setChanged();
            notifyObservers();
        }
        
        return retorno;
    }

    /**
     * Método para obter fornecedores com nome especifico
     * @param nome Nome desejado
     * @return Lista contendo apenas os fornecedores com nomes pesquisado
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public List<Fornecedor> pesquisar(String nome) throws DatabaseException {
        return dao.getFornecedorDAO().selecionar(nome);
    }
    
}
