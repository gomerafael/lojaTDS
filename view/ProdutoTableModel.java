/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lojatds.model.Produto;

/**
 * Classe ProdutoTableModel 
 * @author Rafael, Patrick
 * @version 2.0
 * @since 10/06/2016
 */
public class ProdutoTableModel extends AbstractTableModel{
    
    private List<Produto> produtos;
    
    private static final int CODIGO = 0;
    private static final int NOME = 1;
    private static final int QUANTIDADE = 2;
    private static final int PRECO_DE_COMPRA = 3;
    private static final int PRECO_DE_VENDA = 4;
   
    public ProdutoTableModel() {
        produtos = new ArrayList<>();
    }
    /**
     * Método produtoTableModel produto
     * @param produtos Lista de produto
     * 
     */
    public ProdutoTableModel(List<Produto> produtos) {
        this.produtos = new ArrayList<>(produtos);
    }
    /**
     * Método getRowCount produto
     * @return tamhnho
     */
    @Override
    public int getRowCount() {
        return produtos.size();
    }
    /**
     * Método getColumnCount tamanho
     * @return 5
     */
    @Override
    public int getColumnCount() {
        return 5;
    }
    /**
     * Método getValueAt
     * @param rowIndex numero de linhas
     * @param columnIndex numero de colunas
     * @return valor
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = produtos.get(rowIndex);
        switch (columnIndex) {
            case CODIGO : return produto.getCodigo();
            case NOME : return produto.getNome();
            case QUANTIDADE : return produto.getQuantidade();
            case PRECO_DE_COMPRA : return produto.getPrecoDeCompra();
            case PRECO_DE_VENDA : return produto.getPrecoDeVenda();
            
            default:throw new IndexOutOfBoundsException();
        }
    }
    /**
     * Método getColumnName coluna
     * @param column numedo de colunas
     * @return nome
     */
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case CODIGO : return "Código";
            case NOME : return "Nome";
            case QUANTIDADE : return "Quantidade";
            case PRECO_DE_COMPRA : return "Preço de compra";
            case PRECO_DE_VENDA : return "Preço de venda";
            
            default:throw new IndexOutOfBoundsException();
        }
    }
    /**
     * Método updateProdutos
     * @param produtos Lista de produtos
     */
    public void updateProdutos(List<Produto> produtos) {
        this.produtos = new ArrayList<>(produtos);
        fireTableDataChanged();
    }
    /**
     * Método getProduto  
     * @param linha numero de linhas
     * @return linha
     */
    public Produto getProduto(int linha) {
        return produtos.get(linha);
    }
}
