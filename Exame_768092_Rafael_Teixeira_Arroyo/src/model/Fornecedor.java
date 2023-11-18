
package model;


public class Fornecedor {
    private String CNPJ;
    private String Nome;
    private String Telefone;

    public Fornecedor() {
        }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public Fornecedor(String CNPJ, String Nome, String Telefone) {
        this.CNPJ = CNPJ;
        this.Nome = Nome;
        this.Telefone = Telefone;
    }
    
    
    
}
