/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacegrafica3.model;

/**
 *
 * @author Professor
 */
public class Pessoa {
    
    private int id;
    private String nome;
    private String email;
    private String endereco;
    private String telefone;

    public Pessoa(String nome, String email, String endereco, 
            String telefone, int id) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.id = id;
    }
    
    public Pessoa(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: "     + this.nome     + "\n" +
               "Endereco: " + this.endereco + "\n" +
               "Telefone: " + this.telefone + "\n" + 
               "E-mail: "   + this.email;
    }
    
    
    
    
}
