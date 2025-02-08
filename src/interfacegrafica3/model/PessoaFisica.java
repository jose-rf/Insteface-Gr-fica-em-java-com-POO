/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacegrafica3.model;

/**
 *
 * @author Professor
 */
public class PessoaFisica extends Pessoa {
    private String cpf;
    private String dtNascimento;
    
    public PessoaFisica(String nome, String email, String endereco, String telefone,
                        String cpf, String dtNascimento, int id){
        super(nome, email, endereco, telefone, id);
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Override
    public String toString() {
        return "PessoaFisica{"    +
                  "nome="         + super.getNome()     + 
                ", email="        + super.getEmail()    +
                ", endereco="     + super.getEndereco() +
                ", telefone="     + super.getTelefone() +
                ", cpf="          + cpf                 + 
                ", dtNascimento=" + dtNascimento        + '}';
    }
    
    
}
