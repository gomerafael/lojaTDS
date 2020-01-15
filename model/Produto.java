/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model;

/**
 * Classe que especifíca um produto cadastrado no estoque
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public class Produto implements Comparable<Produto>, Cloneable {
    
    private String nome;
    private int quantidade;
    private int codigo;
    private float precoDeCompra;
    private float precoDeVenda;

    /**
     * Construtor default
     */
    public Produto() {
    }

    /**
     * Método para clonar o objeto
     * @return Clone do objeto
     * @throws CloneNotSupportedException Nao epossivel clonar um objeto
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    
    /**
     * Construtor da classe Produto, que define as principais características dos produtos
     * @param nome Nome do produto a cadastrar
     * @param codigo Código do produto a cadastrar
     * @param quantidade Quantidade do produto a cadastrar
     * @param precoDeCompra Preço do produto que foi comprado
     * @param precoDeVenda Preço do produto a ser vendido
     * @exception Exception Verifica se está preenchido o nome
     */
    public Produto(String nome, int codigo, int quantidade, float precoDeCompra, float precoDeVenda) throws Exception {
        this.nome = nome;
        if(nome == null || nome.equals("")){
            throw new Exception("Algo errado não esta certo");
        }
        this.quantidade = quantidade;
        this.codigo = codigo;
        this.precoDeCompra = precoDeCompra;
        this.precoDeVenda = precoDeVenda;
    }

    /**
     * Construtor de cópia
     * @param a Objeto a ser copiado
     */
    public Produto(Produto a){
        this.nome = a.nome;
        this.quantidade = a.quantidade;
        this.codigo = a.codigo;
        this.precoDeCompra = a.precoDeCompra;
        this.precoDeVenda = a.precoDeVenda;
    }
    
    /**
     * Método getNome
     * @return Nome do produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método setNome
     * @param nome Nome do produto cadastrado
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método getQuantidade
     * @return Quantidade do produto em estoque
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Metodo setQuantidade
     * @param quantidade Quantidade de produto no estoque
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Método getCodigo
     * @return Código do produto cadastrado
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Método setCodigo
     * @param codigo Código do produto cadastrado
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Método getPreço_de_compra 
     * @return Preço do produto que foi comprado
     */
    public float getPrecoDeCompra() {
        return precoDeCompra;
    }

    /**
     * Método setPreco_de_compra
     * @param precoDeCompra valor do produto comprado
     */
    public void setPrecoDeCompra(float precoDeCompra) {
        this.precoDeCompra = precoDeCompra;
    }

    /**
     * Método getPreco_de_venda
     * @return Retorna o valor que o produto será vendido
     */
    public float getPrecoDeVenda() {
        return precoDeVenda;
    }

    /**
     * Método setPreco_de_venda
     * @param precoDeVenda Valor do produto que será venddo
     */
    public void setPrecoDeVenda(float precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    /**
     * Método toString sobrescrito
     * @return String - Nome, Int - Código, Int - Quantidade, Float - Preço de compra, Float - Preço de venda
     * EX: Caderno: 002 Quantidade: 5 Preço de compra: 10,00 Preço de venda: 15,00
     */
    @Override
    public String toString() {
        return  nome + " " + "Codigo: " +codigo + " Quantidade: " + quantidade + " Preco de Compra: "
                + precoDeCompra + " Preco de Venda: " + precoDeVenda + "\n";
    }
    
    /**
     * Método compareTo sobrescrito
     * @param o Objeto usado durante a comparação
     * @return 0 se o objeto é igual, -1 se for menor ou 1 se for maior.
     */
    @Override
    public int compareTo(Produto o) {
        if(this.codigo > o.codigo){
            return 1;
        }
        if(this.codigo < o.codigo){
            return -1;
        }
        if(this.codigo == o.codigo){
            return 0;
        }
        return 0;  
    }  
}
