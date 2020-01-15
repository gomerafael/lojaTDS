/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.controller;

import java.util.List;
import lojatds.model.Produto;
import lojatds.model.Venda;
import lojatds.model.dao.DAOFactory;
import lojatds.model.dao.DatabaseException;

/**
 * Classe Controlador de venda
 * @author Rafael
 * @author Patrick
 * @version 2.0
 * @since 10/06/2016
 */
public class VendaController extends GenericController<Venda> {

    /**
     * Construtr da classe
     * @param dao conecçao com o banco
     */
    public VendaController(DAOFactory dao) {
        super(dao);
    }

    /**
     * Método cadastrar venda
     * @param t Venda a ser fetuada
     * @return true pra venda efetuada, para com não efetuada
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public boolean cadastrar(Venda t) throws DatabaseException {
        boolean retorno = false;
        //boolean retorno1 = true;
        if (t != null) {
            
            retorno = dao.getVendaDAO().inserir(t);
            //retorno1 = dao.getVendaDAO().efetuarVenda(t);
            
        }
        setChanged();
        notifyObservers();

        return retorno;
    }

    /**
     * Método excluir venda
     * @param cod Código da venda a ser excluida
     * @return True para exclusão efetuada, false para falha
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public boolean excluir(int cod) throws DatabaseException {
        if (dao.getVendaDAO().remover(dao.getVendaDAO().buscar(cod))) {
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
    public List<Venda> pesquisar(String nome) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método não implementado 
     */
    @Override
    public boolean atualizar(Venda t) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método para listar todas as venda realizadas
     * @return Lista contendo todos as venda
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public List<Venda> listar() throws DatabaseException {
        return dao.getVendaDAO().listarTodos();
    }
    
    /**
     * Método mostar a lisda de venda de ma compra especifica
     * @param cod Código da venda a ser realizada
     * @return Lista contendo os produto da venda
     * @throws DatabaseException Erro na conexão do banco
     */
    public List<Produto> listaDeVenda(int cod) throws DatabaseException {
        return dao.getProdutoDAO().getListaDeVenda(cod);
    }
    
}
