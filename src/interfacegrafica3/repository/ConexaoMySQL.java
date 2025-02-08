/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacegrafica3.repository;

import interfacegrafica3.model.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author Professor
 */
public class ConexaoMySQL {
    private Conexao conexao = null;
    public static Connection connection = null;
    
    public ConexaoMySQL(Conexao conexao){
        this.conexao = conexao;
    }
    
    public boolean conectar(){
        if(conexao != null){
            try{
                String url = "jdbc:mysql://" + conexao.getEndereco() +
                             ":" + conexao.getPorta() +
                             "/" + conexao.getNomeBanco();
                
                //pegar a classe da Librarie q adicionamos:
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                connection = DriverManager.getConnection(
                        url,
                        conexao.getUser(),
                        conexao.getPassword()
                );
                return true;                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(
                        null,
                        "Erro ao conectar no banco de dados: " + ex.getMessage(),
                        "Erro ao conectar",
                        JOptionPane.ERROR_MESSAGE
                ); 
                return false;
            } //catch
        }else{
            return false;
        }
    }
    
    public boolean insert(Pessoa pessoa){
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
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
}
