/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacegrafica3.repository;

import interfacegrafica3.model.Pessoa;
//import static interfacegrafica3.repository.ConexaoMySQL.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Professor
 */
public class PessoaRepository implements Crud<Pessoa> {
    
    //private Pessoa pessoa;
    
    public PessoaRepository(){
        //this.pessoa = pessoa;
    }

    /*
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }*/
    
    //Crud - Selecionar
    public Pessoa selecionar(int id){
        return null;
    }    
    
    //Crud - inserir
    @Override
    public boolean inserir(Connection connection, Pessoa pessoa) {
        PreparedStatement stmt = null;
        try{
            String comando = "INSERT INTO cadastro_pessoa(nome, endereco, email, telefone) " +
                             "VALUES(?, ?, ?, ?)";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEndereco());
            stmt.setString(3, pessoa.getEmail());
            stmt.setString(4, pessoa.getTelefone());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao inserir pessoa: " + ex.getMessage(),
                    "Erro ao inserir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        //return false;
    }

    //Crud - atualizar
    @Override
    public boolean atualizar(Connection connection, Pessoa pessoa) {
        PreparedStatement stmt = null;
        try{
            String comando = "UPDATE cadastro_pessoa SET " +
                             "nome = ?, endereco = ?, email = ?, telefone = ? " +
                             "WHERE id = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEndereco());
            stmt.setString(3, pessoa.getEmail());
            stmt.setString(4, pessoa.getTelefone());
            stmt.setInt(5, pessoa.getId());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao atualizar pessoa: " + ex.getMessage(),
                    "Erro ao atualizar",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }        
    }

    //Crud - deletar
    @Override
    public boolean deletar(Connection connection, Pessoa pessoa) {
        PreparedStatement stmt = null;
        try{
            String comando = "DELETE FROM cadastro_pessoa " +
                             "WHERE id = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1, pessoa.getId());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao excluir pessoa: " + ex.getMessage(),
                    "Erro ao excluir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }        
    }

    @Override
    public Pessoa selecionar(Connection connection, String operador, int id) {
        try{
            Pessoa pessoa = new Pessoa();
            PreparedStatement stmt = null;
            String comando = "SELECT * FROM cadastro_pessoa WHERE id " + 
                             operador + " ? ";
            if(operador.equals("<"))
                comando += " ORDER BY id DESC";
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if(res != null){
                while(res.next()){
                    pessoa.setId(Integer.parseInt(res.getString("id") ));
                    pessoa.setNome(res.getString("nome"));
                    pessoa.setEndereco(res.getString("endereco"));
                    pessoa.setTelefone(res.getString("telefone"));
                    pessoa.setEmail(res.getString("email"));                    
                    break;
                }
            }
            return pessoa;
        }catch(Exception ex){
            
            return null;
        }
    }

    @Override
    public List<Pessoa> listar(Connection connection, String nomeDaTabela) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


        
}
