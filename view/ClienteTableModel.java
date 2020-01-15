/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lojatds.model.Cliente;

/**
 *
 * @author Rafa
 */
public class ClienteTableModel extends AbstractTableModel {
    
    private List<Cliente> clientes;
    
    //codigo para as colunas
    private static final int CODIGO = 0;
    private static final int NOME = 1;
    private static final int CPF = 2;
    private static final int TELEFONE = 3;
    private static final int CIDADE = 4;
    private static final int LOGRADOURO = 5;
    private static final int CEP = 6;
    private static final int UF = 7;
    
    public ClienteTableModel() {
        clientes = new ArrayList<>();
    }
    
    public ClienteTableModel(List<Cliente> clientes) {
        this.clientes = new ArrayList<>(clientes);
    }
     
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch (columnIndex) {
            case CODIGO : return cliente.getCodigo();
            case NOME : return cliente.getNome();
            case CPF : return cliente.getCPF();
            case TELEFONE : return cliente.getTelefone();
            case CIDADE : return cliente.getCidade();
            case LOGRADOURO : return cliente.getLogradouro();
            case CEP : return cliente.getCEP();
            case UF : return cliente.getUF();
            default:throw new IndexOutOfBoundsException();
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case CODIGO : return "Código";
            case NOME : return "Nome";
            case CPF : return "CPF";
            case TELEFONE : return "Telefone";
            case CIDADE : return "Cidade";
            case LOGRADOURO : return "Logradouro";
            case CEP : return "CEP";
            case UF : return "UF";
            default:throw new IndexOutOfBoundsException();
        }
    }
    
    public void updateClientes(List<Cliente> clientes) {
        this.clientes = new ArrayList<>(clientes);
        fireTableDataChanged();
    }
    
    public Cliente getCliente(int linha) {
        return clientes.get(linha);
    }
}
