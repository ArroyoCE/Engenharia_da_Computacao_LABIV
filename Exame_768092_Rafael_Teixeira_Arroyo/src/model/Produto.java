
package model;



public class Produto {
    

    
    private int id_produto;
    private String nome;
    private int quantidade;
    private String fornecedor;
    private Float valor;

    
    public Produto(int id_produto, String nome, int quantidade, String fornecedor, Float valor) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.valor = valor;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
    
    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
 @Override
    public String toString() 
    {
        return nome;
    }
    
}
