/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacegrafica3.repository;

import interfacegrafica3.model.Uf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Professor
 */
public class UfRepository implements Crud<Uf> {

    @Override
    public boolean inserir(Connection connection, Uf uf) {
        PreparedStatement stmt = null;
        try{
            String comando = "INSERT INTO uf(nome, sigla) " +
                             "VALUES(?, ?)";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, uf.getNome());
            stmt.setString(2, uf.getSigla());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao inserir uf: " + ex.getMessage(),
                    "Erro ao inserir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    @Override
    public boolean atualizar(Connection connection, Uf uf) {
        PreparedStatement stmt = null;
        try{
            String comando = "UPDATE uf SET " +
                             "nome = ?, sigla = ? " +
                             "WHERE id = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, uf.getNome());
            stmt.setString(2, uf.getSigla());
            stmt.setInt(3, uf.getId());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao atualizar uf: " + ex.getMessage(),
                    "Erro ao atualizar",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    @Override
    public boolean deletar(Connection connection, Uf uf) {
        PreparedStatement stmt = null;
        try{
            String comando = "DELETE FROM uf " +
                             "WHERE id = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1, uf.getId());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao excluir uf: " + ex.getMessage(),
                    "Erro ao excluir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }        
    }

    @Override
    public Uf selecionar(Connection connection, String operador, int id) {
        try{
            Uf uf = new Uf();
            PreparedStatement stmt = null;
            String comando = "SELECT * FROM uf WHERE id " + 
                             operador + " ? ";
            if(operador.equals("<"))
                comando += " ORDER BY id DESC";
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if(res != null){
                while(res.next()){
                    uf.setId(Integer.parseInt(res.getString("id") ));
                    uf.setNome(res.getString("nome"));
                    uf.setSigla(res.getString("sigla"));
                    break;
                }
            }
            return uf;
        }catch(Exception ex){            
            return null;
        }
    }

    @Override
    public List<Uf> listar(Connection connection, String nomeDaTabela) {
        try{
            List<Uf> ufList = new ArrayList<>();
            
            PreparedStatement stmt = null;
            String comando = "SELECT * FROM " + nomeDaTabela;
            stmt = connection.prepareStatement(comando);
            ResultSet res = stmt.executeQuery();
            if(res != null){
                while (res.next()) {
                    int id = res.getInt("id");
                    String nome = res.getString("nome");
                    String sigla = res.getString("sigla");
                
                    Uf uf = new Uf(nome, sigla, id);
                    ufList.add(uf);
                }
            }
            return ufList;
        }catch(Exception ex){            
            return null;
        }
    }
    
}
