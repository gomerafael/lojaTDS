/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model;

/**
 * Classe abstrata cliente com os atributos essenciais para um cliente se
 * cadastrar em uma loja.
 *
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public abstract class Pessoa implements Comparable<Pessoa>, Cloneable {

    private String nome;
    private int codigo;
    private String telefone;
    private String CEP;
    private String cidade;
    private String logradouro;
    private String UF;
    
    /**
     * Construtor da classe Pessoa;
     *
     * @param nome Nome da pessoa a ser cadastrada
     * @param codigo Código para pesquisa ou cadastro de pessoa
     * @param telefone Telefone da pessoa
     * @param CEP CEP da pessoa
     * @param cidade Cidade da pessoa
     * @param UF UF da pessoa
     * @param logradouro Logradouro da pessoa
     * @throws Exception Verifica se está preenchido o nome
     */
    public Pessoa(String nome, int codigo, String telefone, String CEP, 
            String cidade, String UF, String logradouro) throws Exception {
        if (nome == null || nome.equals("")) {
            throw new Exception("Algo errado não esta certo");
        }
        this.nome = nome;
        this.codigo = codigo;
        this.telefone = telefone;
        this.CEP = CEP; 
        this.cidade = cidade;
        this.UF = UF;
        this.logradouro = logradouro;
    }

    /**
     * Construtor default
     */
    public Pessoa() {
    }

    /**
     * Construtor de cópia;
     *
     * @param a Objeto do tipo cliente
     * @throws Exception Verifica se está preenchido o nome
     */
    public Pessoa(Pessoa a) throws Exception {
        this.nome = a.nome;
        if (nome == null || nome.equals("")) {
            throw new Exception("Algo errado não esta certo");
        }
        this.codigo = a.codigo;
        this.telefone = a.telefone;
        this.CEP = a.CEP; 
        this.cidade = a.cidade;
        this.UF = a.UF;
        this.logradouro = a.logradouro;
    }

    /**
     * Método getNome
     *
     * @return Nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método getCodigo
     *
     * @return Código de cadastro do cliente
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Método setNome
     *
     * @param nome Nome do cliente cadastrado
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método setCodigo
     *
     * @param codigo Código do cliente cadastrado
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    /**
     * Método compareTo sobrescrito
     * @param o Objeto usado durante a comparação
     * @return 0 Se o objeto é igual, -1 se for menor ou 1 se for maior.
     */
    @Override
    public int compareTo(Pessoa o) {
        if (this.codigo > o.codigo) {
            return 1;
        }
        if (this.codigo < o.codigo) {
            return -1;
        }
        if (this.codigo == o.codigo) {
            return 0;
        }
        return 0;
    }
    /**
     * Método getTelefone
     * @return telefone 
     */
    public String getTelefone() {
        return telefone;
    }
    /**
     * Método setTelefone
     * @param telefone telefone da pessoa
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Método getCEP
     * @return CEP 
     */
    public String getCEP() {
        return CEP;
    }
    /**
     * Método setCEP
     * @param CEP CEP da pessoa 
     */
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    /**
     * Método getCidade
     * @return cidade
     */
    public String getCidade() {
        return cidade;
    }
    /**
     * Método setCidade
     * @param cidade Cidade da pessoa
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    /**
     * Método getUF
     * @return UF
     */
    public String getUF() {
        return UF;
    }
    /**
     * Método setUF
     * @param UF UF da pessoa
     */
    public void setUF(String UF) {
        this.UF = UF;
    }
    
    /**
     * Método getLogradouro
     * @return logradouro da pessoa 
     */
    public String getLogradouro() {
        return logradouro;
    }
    /**
     * Método setLogradouro
     * @param logradouro logradouro da pessoa 
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    
    /**
     * Método clone sobrescrito
     * @return Clone do objeto
     * @throws CloneNotSupportedException Objeto não pode ser clonado
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
