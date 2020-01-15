/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.controller;

import java.util.List;
import lojatds.model.Compra;
import lojatds.model.Produto;
import lojatds.model.dao.DAOFactory;
import lojatds.model.dao.DatabaseException;

/**
 * Classe controlador compras
 * @author rafael
 * @author patrick
 * @version 2.0
 * @since 10/06/2016
 */
public class CompraController extends GenericController<Compra> {

    /**
     * Construtor da classe
     * @param dao Conexão com o banco
     */
    public CompraController(DAOFactory dao) {
        super(dao);
    }

    /**
     * Método cadastrar compra
     * @param t compra a ser fetuada
     * @return true pra compra efetuada, para com nao efetuada
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public boolean cadastrar(Compra t) throws DatabaseException {
        boolean retorno = false;
        
        if (t != null) {
            retorno = dao.getCompraDAO().inserir(t);
            //retorno1 = dao.getCompraDAO().efetuarCompra(t);
            
        }

        setChanged();
        notifyObservers();

        return retorno;
    }

    /**
     * Método excluir compra
     * @param cod Código da compra a ser excluida
     * @return true para exclusão efetuada false para falha
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public boolean excluir(int cod) throws DatabaseException {
        if (dao.getCompraDAO().remover(dao.getCompraDAO().buscar(cod))) {
            setChanged();
            notifyObservers();
            return true;
        }
        return false;
    }

    /**
     * Método não implementado 
     */
    @Override
    public List<Compra> pesquisar(String nome) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método não implementado
     */
    @Override
    public boolean atualizar(Compra t) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método para listar todas as compras realizadas
     * @return Lista contendo todos as compras
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public List<Compra> listar() throws DatabaseException {
        return dao.getCompraDAO().listarTodos();
    }
    
    /**
     * Método mostar a lisda de compra de ma compra especifica
     * @param cod Código da compra a ser realizada
     * @return Lista coontendo os produto da compra
     * @throws DatabaseException Erro na conexão do banco
     */
    public List<Produto> listaDeCompra(int cod) throws DatabaseException {
        return dao.getProdutoDAO().getListaDeCompra(cod);
    }


}
