/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lojatds.model.Venda;

/**
 * Classe VendaTableModel
 * @author Rafael, Patrick
 * @version 2.0
 * @since 10/06/2016
 */
public class VendaTableModel extends AbstractTableModel {
    
    private List<Venda>vendas;
    
    private static final int CODIGO_VENDA = 0;
    private static final int CODIGO_CLIENTE = 1;
    private static final int TOTAL = 2;
   
    public VendaTableModel () {
        vendas = new ArrayList<>();
    }
    /**
     * Método vendaTableModel
     * @param vendas lista de vendas 
     */
    public VendaTableModel(List<Venda> vendas) {
        this.vendas = new ArrayList<>(vendas);
    }
    /**
     * Método getRowCount
     * @return tamanho
     */
    @Override
    public int getRowCount() {
        return vendas.size();
    }
    /**
     * Método getColumnCount tamanho de colunas
     * @return 3
     */
    @Override
    public int getColumnCount() {
        return 3;
    }
    /**
     * Método Object getValue venda
     * @param rowIndex Numero de linha 
     * @param columnIndex Numero de coluna
     * @return valor
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venda venda = vendas.get(rowIndex);
        switch (columnIndex) {
            case CODIGO_VENDA : return venda.getCod();
            case CODIGO_CLIENTE : return venda.getCliente().getCodigo();
            case TOTAL : return venda.getTotal();
            
            default:throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Método getColumnName coluna
     * @param column numero de colunas
     * @return coluna
     */
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case CODIGO_VENDA : return "Código de venda";
            case CODIGO_CLIENTE : return "Código do cliente";
            case TOTAL : return "Total da venda";
            
            default:throw new IndexOutOfBoundsException();
        }
    }
    /**
     * Método updateVendas venda
     * @param vendas lista de vendas 
     */
    public void updateVendas(List<Venda> vendas) {
        this.vendas = new ArrayList<>(vendas);
        fireTableDataChanged();
    }
    /**
     * Método getVendas venda
     * @param linha Numero de linhas
     * @return linha
     */
    public Venda getVendas(int linha) {
        return vendas.get(linha);
    }
}
