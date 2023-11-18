
package controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Produto;

public class ProdutoDAO 
{
    private final Connection con;
    private PreparedStatement cmd;
    
    public ProdutoDAO()
    {
        con = Conexao.conectar();
    }
    
    public int inserir (Produto p)
    {
        try
        {
            String SQL = "insert into tb_produto (nome, preco, quantidade, categoria_id) values (?,?,?,?);";
            cmd = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            cmd.setString(1, p.getNome());
            cmd.setDouble(2, p.getPreco());
            cmd.setInt(3, p.getQuantidade());
            cmd.setInt(4, p.getCategoria_id());
            
            if(cmd.executeUpdate() > 0)
            {
                ResultSet rs = cmd.getGeneratedKeys();
             
            if (rs.next())
                return rs.getInt("id"); 
            }    
            return -1;
        }
        catch (Exception e)
        {
            System.err.println ("ERRO:" + e.getMessage());
            return -1;
        }
        finally
        {
            Conexao.desconectar(con);
        }    
    }
    
     public int atualizar (Produto p) {
        try {
            String SQL = "update tb_produto set nome=?, preco=?, quantidade=?, categoria_id=? where id=?";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, p.getNome());
            cmd.setDouble(2, p.getPreco());
            cmd.setInt(3, p.getQuantidade());
            cmd.setInt(4, p.getCategoria_id());
            cmd.setInt(5, p.getId());
            if(cmd.executeUpdate() > 0)
                return 0;
            
            return -1;
        }catch (SQLException e) {
            System.err.println("ERRO" + e.getMessage());
            return -1;
        }finally{
            Conexao.desconectar(con);
        }
    }
      
    public List<Produto> pesquisarPorNome(String nome) 
    {
        try {
            String SQL = "select p.*, c.nome as categoria_nome "
                        + "from tb_produto as p "
                        + "inner join tb_categoria as c "
                        + "on (p.categoria_id = c.id) "
                        + "where p.nome ilike ?";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, '%' + nome + '%');
            ResultSet rs = cmd.executeQuery();
            List<Produto> lista = new ArrayList<>();
            while (rs.next())
            {
                Produto p = new Produto(rs.getInt("id"),
                                        rs.getString("nome"),
                                        rs.getDouble("preco"),
                                        rs.getInt("quantidade"),
                                        rs.getInt("categoria_id"),
                                        rs.getString("categoria_nome"));
                
                p.setTotal(p.getPreco() * p.getQuantidade());
                lista.add(p);
                
            }    
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.desconectar(con);
        }
    }
        public List<Produto> listar() {
        try {
            String SQL = "select p.*, c.nome as categoria_nome "
                    + "from tb_produto as p "
                    + "inner join tb_categoria as c "
                    + "on (p.categoria_id = c.id) "
                    + "order by p.nome";
            cmd = con.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();
            List<Produto> lista = new ArrayList<>();
            while (rs.next()) {
                Produto p = new Produto(
                    rs.getInt("id"),rs.getString("nome"),
                    rs.getDouble("preco"), rs.getInt("quantidade"),
                    rs.getInt("categoria_id"),rs.getString("categoria_nome")
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
}
