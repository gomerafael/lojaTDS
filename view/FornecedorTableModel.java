/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lojatds.model.Fornecedor;

/**
 * Classe FornecedorTableModel
 * @author Rafael, Patrick
 * @version 2.0
 * @since 10/06/2016
 */
public class FornecedorTableModel extends AbstractTableModel {
    
     private List<Fornecedor> fornecedores;
     
     //codigo para as colunas
    private static final int CODIGO = 0;
    private static final int NOME = 1;
    private static final int CNPJ = 2;
    private static final int TELEFONE = 3;
    private static final int CIDADE = 4;
    private static final int LOGRADOURO = 5;
    private static final int CEP = 6;
    private static final int UF = 7;
    
    public FornecedorTableModel() {
        fornecedores = new ArrayList<>();
    }
    
    public FornecedorTableModel(List<Fornecedor> fornecedores) {
        this.fornecedores = new ArrayList<>(fornecedores);
    }
    
    @Override
    public int getRowCount() {
        return fornecedores.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fornecedor fornecedor = fornecedores.get(rowIndex);
        switch (columnIndex) {
            case CODIGO : return fornecedor.getCodigo();
            case NOME : return fornecedor.getNome();
            case CNPJ : return fornecedor.getCNPJ();
            case TELEFONE : return fornecedor.getTelefone();
            case CIDADE : return fornecedor.getCidade();
            case LOGRADOURO : return fornecedor.getLogradouro();
            case CEP : return fornecedor.getCEP();
            case UF : return fornecedor.getUF();
            default:throw new IndexOutOfBoundsException();
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case CODIGO : return "Código";
            case NOME : return "Nome";
            case CNPJ : return "CNPJ";
            case TELEFONE : return "Telefone";
            case CIDADE : return "Cidade";
            case LOGRADOURO : return "Logradouro";
            case CEP : return "CEP";
            case UF : return "UF";
            default:throw new IndexOutOfBoundsException();
        }
    }
    
    public void updateFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = new ArrayList<>(fornecedores);
        fireTableDataChanged();
    }
    
    public Fornecedor getFornecedor(int linha) {
        return fornecedores.get(linha);
    }
}
