package interfacegrafica3.repository;

import interfacegrafica3.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FornecedorRepository implements Crud<Fornecedor> {
    
    @Override
    public boolean inserir(Connection connection, Fornecedor entity) {
        String sql = "INSERT INTO cadastro_fornecedor (cnpj, inscricao_estadual, nome_fantasia, nome, email, telefone, categoria, uf) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getCnpj());
            stmt.setString(2, entity.getInscricaoEstadual());
            stmt.setString(3, entity.getNomeFantasia());
            stmt.setString(4, entity.getNome());
            stmt.setString(5, entity.getEmail());
            stmt.setString(6, entity.getTelefone());
            stmt.setString(7, entity.getCategoria());
            stmt.setString(8, "n/a");
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public boolean atualizar(Connection connection, Fornecedor entity) {
        String sql = "UPDATE cadastro_fornecedor SET cnpj = ?, inscricao_estadual = ?, nome_fantasia = ?, nome = ?, email = ?, telefone = ?, categoria = ?, uf = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, entity.getCnpj());
            stmt.setString(2, entity.getInscricaoEstadual());
            stmt.setString(3, entity.getNomeFantasia());
            stmt.setString(4, entity.getNome());
            stmt.setString(5, entity.getEmail());
            stmt.setString(6, entity.getTelefone());
            stmt.setString(7, entity.getCategoria());
            stmt.setString(8, "n/a");
            stmt.setInt(9, entity.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar fornecedor: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public boolean deletar(Connection connection, Fornecedor entity) {
        String sql = "DELETE FROM cadastro_fornecedor WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, entity.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar fornecedor: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public Fornecedor selecionar(Connection connection, String operador, int id) {
        String sql = "SELECT * FROM cadastro_fornecedor WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                return new Fornecedor(
                    res.getInt("id"),
                    res.getString("cnpj"),
                    res.getString("inscricao_estadual"),
                    res.getString("nome_fantasia"),
                    res.getString("nome"),
                    res.getString("email"),
                    res.getString("telefone"),
                    res.getString("categoria"),
                    res.getString("uf")
                );
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar fornecedor: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null; // Caso não encontre, retorna null
    }

    @Override
    public List<Fornecedor> listar(Connection connection, String nomeDaTabela) {
        List<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM cadastro_fornecedor";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                fornecedores.add(new Fornecedor(
                    res.getInt("id"),
                    res.getString("cnpj"),
                    res.getString("inscricao_estadual"),
                    res.getString("nome_fantasia"),
                    res.getString("nome"),
                    res.getString("email"),
                    res.getString("telefone"),
                    res.getString("categoria"),
                    res.getString("uf")
                ));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar fornecedores: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return fornecedores;
    }
}
