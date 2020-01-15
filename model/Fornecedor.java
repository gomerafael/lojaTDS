/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model;

/**
 * Classe que define um fornecedor da loja.
 * @author Patrick
 * @author Rafael
 * @version 2.0
 * @since 10/06/2016
 */
public class Fornecedor extends Pessoa{
   
    private String CNPJ;
    
    /**
     * Construtor da classe Fornecedor
     * @param nome Nome do fornecedor
     * @param codigo Código para identificação
     * @param telefone Telefone do fornecedor
     * @param CEP CEP do fornecedor
     * @param cidade Cidade do fornecedor
     * @param CNPJ CNPJ do fornecedor
     * @param logradouro Logradouro do fornecedor
     * @param UF UF do fornecedor
     * @exception Exception Verifica se está preenchido o nome
     */
    public Fornecedor(String nome, int codigo, String telefone, String CEP, String cidade, String UF, String logradouro, String CNPJ) throws Exception {
        super(nome, codigo, telefone, CEP, cidade, UF, logradouro);
        if(nome == null || nome.equals("")){
            throw new Exception("Algo errado não esta certo");
         }
        this.CNPJ = CNPJ;
    }
    
    /**
     * Construtor default
     */
    public Fornecedor(){
        
    }
    
    /**
     * Construtor de cópia
     * @param a Objeto a ser copiado
     * @exception Exception Verifica se está preenchido o nome
     */
    public Fornecedor(Fornecedor a) throws Exception{
        super(a);
        this.CNPJ = a.CNPJ;
    }
    
       
    
    /**
     * Método getCNPJ
     * @return CNPJ CNPJ do fornecedor;
     */
    public String getCNPJ() {
        return CNPJ;
    }
    
    /**
     * Método setCNPJ
     * @param CNPJ CNPJ do fornecedor
     */
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    /**
     * Método toString sobrescrevido
     * @return String - Nome, Int - Codigo, Int - CNPJ 
     */
    @Override
    public String toString() {
        return getNome() + " Codigo: " + getCodigo() + " CNPJ: " + CNPJ + "\n";
    }  
}
