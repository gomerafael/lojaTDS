/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatds.model;

/**
 * Classe que define um cliente com efetuação de compra na loja
 * @author Patrick
 * @author Rafael
 * @version 2.0 
 * @since 10/06/2016
 */
public class Cliente extends Pessoa{
    private String CPF;
   
    /**
     * Construtor da classe Cliente
     * @param nome Nome do cliente
     * @param codigo Código para identificação 
     * @param telefone Telefone do cliente
     * @param CEP CEP do cliente
     * @param CPF CPF do cliente
     * @param UF UF do cliente
     * @param logradouro Logradouro do cliente
     * @param cidade Cidade do cliente
     * @exception Exception Verifica se está preenchido o nome
     */
    public Cliente(String nome, int codigo, String telefone, String CEP, String cidade, 
            String UF, String logradouro, String CPF) throws Exception {
        super(nome, codigo, telefone, CEP, cidade, UF, logradouro);
        if(nome == null || nome.equals("")){
            throw new Exception("Algo errado não esta certo");
         }
        this.CPF = CPF;
    }
    
   
    /**
     * Construtor default
     */
    public Cliente() {
        
    }
    /**
     * Construtor de cópia
     * @param a Objeto a ser copiado
     * @throws Exception Verifica se está preenchido o nome
     */
    public Cliente(Cliente a) throws Exception {
        super(a);
        this.CPF = a.CPF;
    }

    
    
    /**
     * Método getCPF
     * @return Retorna o CPF do cliente cadastrado
     */
    public String getCPF() {
        return CPF;
    }
    
    /**
     * Método setCPF 
     * @param CPF CPF do cliente cadastrado
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
