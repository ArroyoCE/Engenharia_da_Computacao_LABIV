
package model;


public class Imovel 
{
    private int id;
    private String proprietario;
    private String telefone;
    private String tipo;
    private double valor;
    private String status;

    public Imovel() 
    {
    }
    

    public Imovel(int id, String proprietario, String telefone, String tipo, double valor, String status) {
        this.id = id;
        this.proprietario = proprietario;
        this.telefone = telefone;
        this.tipo = tipo;
        this.valor = valor;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
   
    
    
}
