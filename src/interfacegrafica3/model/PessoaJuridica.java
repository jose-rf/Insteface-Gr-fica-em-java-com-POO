/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacegrafica3.model;

/**
 *
 * @author Professor
 */
public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private String inscricaoEstadual;
    private String nomeFantasia;

    public PessoaJuridica(String cnpj, String inscricaoEstadual, String nomeFantasia, 
                          String nome, String email, String endereco, 
                          String telefone, int id) {
        super(nome, email, endereco, telefone, id);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{"       + 
                "nome="                + super.getNome()     + 
                ", email="             + super.getEmail()    +
                ", endereco="          + super.getEndereco() +
                ", telefone="          + super.getTelefone() +
                ", cnpj="              + cnpj                + 
                ", inscricaoEstadual=" + inscricaoEstadual   + 
                ", nomeFantasia="      + nomeFantasia        + '}';
    }
    
    
    
}
