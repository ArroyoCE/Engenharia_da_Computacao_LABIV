
package controller;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;


public class CategoriaDAO 
{
        
    private final Connection con;
    private PreparedStatement cmd;
    
    public CategoriaDAO()
    {
        con = Conexao.conectar();
    }
    
    
    
     public int atualizar (Categoria c) {
        try {
            String SQL = "update tb_categoria set nome=? where id=?";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, c.getNome());
            cmd.setInt(2, c.getId());
            if(cmd.executeUpdate() > 0)
                return c.getId();
            
            return -1;
        }catch (SQLException e) {
            System.err.println("ERRO" + e.getMessage());
            return -1;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
   public List<Categoria> pesquisarPorNome(String nome)
   {
          try {
            String SQL="select * from tb_categoria where nome ilike ?";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, '%'+nome+'%');
            ResultSet rs = cmd.executeQuery();        
            List<Categoria> lista = new ArrayList<>();        
           
           while (rs.next()) {
                Categoria c = new Categoria(rs.getInt("id"), rs.getString("nome"));
                
            lista.add(c);
            }
           
           return lista;
          }
        catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
            }
        finally
        {
            Conexao.desconectar(con);
        }
   } 
   
   public Categoria pesquisarPorId(int id) {
       
       try {
            String SQL="select * from tb_categoria where id=?";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            ResultSet rs = cmd.executeQuery();        
                    
           
           if (rs.next()) {
                Categoria c = new Categoria(rs.getInt("id"), rs.getString("nome"));
                
            return c;
           }
           else
               return null;
            }
        catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
            }
        finally
        {
            Conexao.desconectar(con);
        }
   }
       
   
   
   
   
   public int inserir(Categoria u)
   {
        try {
            String SQL="insert into tb_categoria (nome) values (?);";
            cmd = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            cmd.setString(1, u.getNome());
                    
           if (cmd.executeUpdate() > 0) {
                ResultSet rs = cmd.getGeneratedKeys();
           if (rs.next()) 
                 return rs.getInt("id"); 
           }
                return -1;
            }
        catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
            }
        finally
        {
            Conexao.desconectar(con);
        }
   }
   
   public List<Categoria> listar()
   {
          try {
            String SQL="select * from tb_categoria order by nome;";
            cmd = con.prepareStatement(SQL);
            
            ResultSet rs = cmd.executeQuery();        
            List<Categoria> lista = new ArrayList<>();        
           
            while (rs.next()) {
                Categoria c = new Categoria(rs.getInt("id"), rs.getString("nome"));
                
            lista.add(c);
            }
           
           return lista;
          }
        catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
            }
        finally
        {
            Conexao.desconectar(con);
        }
   }
   
   
}
