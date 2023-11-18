
package model;


public class Produto 
{
    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    private int categoria_id;
    private String categoria_nome;
    private Double total;
    
    public Produto()
    {
        
    }        

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Produto(int id, String nome, double preco, int quantidade, int categoria_id, String categoria_nome) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria_id = categoria_id;
        this.categoria_nome = categoria_nome;
    }
    
    public Produto (String c)
    {
        this.categoria_nome = c;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getCategoria_nome() {
        return categoria_nome;
    }

    public void setCategoria_nome(String categoria_nome) {
        this.categoria_nome = categoria_nome;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
