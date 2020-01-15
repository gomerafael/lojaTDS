/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.controller;

import java.util.List;
import lojatds.model.Cliente;
import lojatds.model.dao.DAOFactory;
import lojatds.model.dao.DatabaseException;
import lojatds.model.dao.jdbc.JDBCClienteDAO;

/**
 * Classe controlador cliente
 *
 * @author Patrick
 * @author Rafa
 * @version 2.0
 * @since 10/06/2016
 */
public class ClienteController extends GenericController<Cliente> {

    /**
     * Construtor da classe controller
     *
     * @param dao Conexão com o banco
     */
    public ClienteController(DAOFactory dao) {
        super(dao);
    }

    /**
     * Método cadastrar cliente
     *
     * @param t Cliente a ser cadastrado
     * @return 1 para cliente cadastrado, 0 para cleinte não condastrado
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public boolean cadastrar(Cliente t) throws DatabaseException {
        boolean retorno = false;
        if (t != null) {
            if (dao.getClienteDAO().buscar(t.getCodigo()) == null) {
                retorno = dao.getClienteDAO().inserir(t);
            }
        }

        if (retorno == true) {
            setChanged();
            notifyObservers();
        }
        return retorno;
    }

    /**
     * Método atualizar cliente
     *
     * @param t Cliente a ser atualizado
     * @return 1 para cliente atualizado, 0 para cleinte não atualizado
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public boolean atualizar(Cliente t) throws DatabaseException {
        boolean retorno = false;
        if (t != null) {
            retorno = dao.getClienteDAO().atualizar(t);
        }

        if (retorno == true) {
            setChanged();
            notifyObservers();
        }

        return retorno;
    }

    /**
     * Método excluir cliente
     *
     * @param cod Código do cliente a ser excluido
     * @return true para cliente exlcuido, false para cliente não escluido
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public boolean excluir(int cod) throws DatabaseException {
        if (dao.getClienteDAO().remover(dao.getClienteDAO().buscar(cod))) {
            setChanged();
            notifyObservers();
            return true;
        }
        return false;
    }

    /**
     * Método listar ccliente
     *
     * @return Lista de todos cliente cadastrado no banco
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public List<Cliente> listar() throws DatabaseException {
        return dao.getClienteDAO().listarTodos();
    }

    /**
     * Método pesquiser clientes pelo nome
     *
     * @param nome Nome dos clientse a serem pesquisados
     * @return Lista dos clientes que contem o nome pesquisado
     * @throws DatabaseException Erro na conexão do banco
     */
    @Override
    public List<Cliente> pesquisar(String nome) throws DatabaseException {
        return dao.getClienteDAO().selecionar(nome);
    }

}
