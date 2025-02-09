package interfacegrafica3.model;

public class Fornecedor extends PessoaJuridica {
    private String categoria;
    private Uf uf;

    public Fornecedor(int id, String cnpj, String inscricaoEstadual, String nomeFantasia, 
                      String nome, String email, String endereco, 
                      String telefone, String categoria, Uf uf) {
        super(cnpj, inscricaoEstadual, nomeFantasia, nome, email, endereco, telefone, id);
        this.categoria = categoria;
        this.uf = uf;
    }

    public Fornecedor() {
    }

    public Fornecedor(int aInt, String string, String string0, String string1, String string2, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Fornecedor(int aInt, String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Fornecedor(int aInt, String string, String string0, String string1, String string2, String string3, String string4, String string5) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    // Método para pegar o ID de 'uf' (caso seja necessário)
    public int getUfId() {
        if (this.uf != null) {
            return this.uf.getId(); // Certifique-se de que a classe Uf tenha o método getId()
        }
        return -1; // Ou outro valor para indicar que o 'uf' não está definido
    }
}
