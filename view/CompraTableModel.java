/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lojatds.model.Compra;

/**
 *
 * @author Rafa
 */
public class CompraTableModel extends AbstractTableModel {
    
    private List<Compra> compras;
    
    private static final int CODIGO_COMPRA = 0;
    private static final int CODIGO_FORNECEDOR = 1;
    private static final int TOTAL = 2;
    
    
    public CompraTableModel () {
        compras = new ArrayList<>();
    }

    public CompraTableModel(List<Compra> compras) {
        this.compras = new ArrayList<>(compras);
    }
    
    @Override
    public int getRowCount() {
        return compras.size();
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Compra compra = compras.get(rowIndex);
        switch (columnIndex) {
            case CODIGO_COMPRA : return compra.getCod();
            case CODIGO_FORNECEDOR : return compra.getFornecedor().getCodigo();
            case TOTAL : return compra.getTotal();
            
            default:throw new IndexOutOfBoundsException();
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case CODIGO_COMPRA : return "Código compra";
            case CODIGO_FORNECEDOR : return "Código fornecedor";
            case TOTAL : return "Total";
            
            default:throw new IndexOutOfBoundsException();
        }
    }
    
    public void updateCompras(List<Compra> compras) {
        this.compras = new ArrayList<>(compras);
        fireTableDataChanged();
    }
    
    public Compra getCompra(int linha) {
        return compras.get(linha);
    }
    
}
