package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Produto;


public class ProdutoDAO {
    
    private final Connection con;
    private PreparedStatement cmd;
    
    public ProdutoDAO(){
        con = Conexao.conectar();
    }
   
    public int inserir(Produto u){
        try {
            String SQL="insert into tb_estoque (id_fornecedor, nome_produto, preco_custo, quantidade) values (?,?,?,?);";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, u.getFornecedor());
            cmd.setString(2, u.getNome());
            cmd.setDouble(3, u.getValor());
            cmd.setInt(4, u.getQuantidade());
            if (cmd.executeUpdate() > 0){
                return 1;  
            }else{
                return -1;
            }
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            System.err.println("ERRO: " + e.getSQLState());
            if (e.getSQLState().equals("23505")){
                return -2;
            }
            return -1;
        }finally{
            Conexao.desconectar(con);
        }
        
    }
    
      public List<Produto> listar() {
        try {
            String SQL = "select * "
                    + "from tb_estoque "
                    + "order by nome_produto";
            cmd = con.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();
            List<Produto> lista = new ArrayList<>();
            while (rs.next()) {
                Produto p = new Produto(
                    rs.getInt("id_produto"),
                    rs.getString("nome_produto"),
                    rs.getInt("quantidade"),
                    rs.getString("id_fornecedor"),
                    rs.getFloat("preco_custo")       
                );
                lista.add(p);
            } 
            return lista;
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.desconectar(con);
        }
    }
    
      public String atualizar (Produto p) 
      {
        try {
            String SQL = "update tb_estoque set id_fornecedor = ?, nome_produto=?, preco_custo=?, quantidade = ? where id_produto=?";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, p.getFornecedor());
            cmd.setString(2, p.getNome());
            cmd.setFloat(3, p.getValor());
            cmd.setInt(4, p.getQuantidade());
            cmd.setInt(5, p.getId_produto());
            if(cmd.executeUpdate() > 0)
                return p.getNome();
            
            return "Erro";
        }catch (SQLException e) {
            System.err.println("ERRO" + e.getMessage());
            return "Erro";
        }finally{
            Conexao.desconectar(con);
        }
    }
            
}
