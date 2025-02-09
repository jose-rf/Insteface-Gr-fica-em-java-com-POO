package interfacegrafica3.repository;

import java.sql.ResultSet;
import interfacegrafica3.model.Fornecedor;
import interfacegrafica3.model.Uf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;

public class FornecedorRepository implements Crud<Fornecedor> {

    @Override
    public boolean inserir(Connection connection, Fornecedor fornecedor) {
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO cadastro_fornecedor "
                    + "(nome, email, endereco, uf, telefone, cnpj, inscricaoEstadual, nomeFantasia, categoria) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            stmt = connection.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getEmail());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setInt(4, fornecedor.getUf().getId()); // Certifique-se de que a UF existe no BD
            stmt.setString(5, fornecedor.getTelefone());
            stmt.setString(6, fornecedor.getCnpj());
            stmt.setString(7, fornecedor.getInscricaoEstadual());
            stmt.setString(8, fornecedor.getNomeFantasia());
            stmt.setString(9, fornecedor.getCategoria());

            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao inserir fornecedor: " + ex.getMessage(),
                    "Erro ao inserir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    @Override
    public boolean atualizar(Connection connection, Fornecedor fornecedor) {
        String sql = "UPDATE cadastro_fornecedor SET "
                + "nome = ?, email = ?, telefone = ?, cnpj = ?, inscricaoEstadual = ?, "
                + "nomeFantasia = ?, categoria = ?, uf = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getEmail());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setString(4, fornecedor.getCnpj());
            stmt.setString(5, fornecedor.getInscricaoEstadual());
            stmt.setString(6, fornecedor.getNomeFantasia());
            stmt.setString(7, fornecedor.getCategoria());
            stmt.setInt(8, fornecedor.getUf().getId()); // Confirme que a UF existe
            stmt.setInt(9, fornecedor.getId()); // ID do fornecedor a ser atualizado

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao atualizar fornecedor: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    @Override
    public boolean deletar(Connection connection, Fornecedor fornecedor) {
        String sql = "DELETE FROM cadastro_fornecedor WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, fornecedor.getId());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir fornecedor: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public Fornecedor selecionar(Connection connection, String operador, int id) {
        String sql = "SELECT * FROM cadastro_fornecedor WHERE id " + operador + " ? ORDER BY id ASC LIMIT 1";
        Fornecedor fornecedor = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                fornecedor = new Fornecedor(
                        res.getString("cnpj"),
                        res.getString("inscricaoEstadual"),
                        res.getString("nomeFantasia"),
                        res.getString("nome"),
                        res.getString("email"),
                        res.getString("endereco"),
                        res.getString("telefone"),
                        res.getString("categoria"),
                        new Uf("", "", res.getInt("uf")), // Criando UF com ID correto
                        res.getInt("id")
                );
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao buscar fornecedor: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        return fornecedor;
    }

    @Override
    public List<Fornecedor> listar(Connection connection, String nomeDaTabela) {
        // Implementação futura caso necessário
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
