
package model;

public class VendaItem 
{
    private int id;
    private int produto_id;
    private int quantidade;
    private double valor_unitario;
    private int estoque_atual;

    public VendaItem() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public int getEstoque_atual() {
        return estoque_atual;
    }

    public void setEstoque_atual(int estoque_atual) {
        this.estoque_atual = estoque_atual;
    }

    public VendaItem(int produto_id, int quantidade, double valor_unitario, int estoque_atual) {
        this.produto_id = produto_id;
        this.quantidade = quantidade;
        this.valor_unitario = valor_unitario;
        this.estoque_atual = estoque_atual;
    }
}
