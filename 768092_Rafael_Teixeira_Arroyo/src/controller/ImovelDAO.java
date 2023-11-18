
package controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Imovel;


public class ImovelDAO 
{
    private final Connection con;
    private PreparedStatement cmd;
    
    public ImovelDAO()
    {
        con = Conexao.conectar();
    }
    
    public int inserir (Imovel i)
    {
        try
        {
            String SQL = "insert into tb_vendas (nome_proprietario, telefone_proprietario, tipo, valor_venda, status) values (?,?,?,?,?);";
            cmd = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            cmd.setString(1, i.getProprietario());
            cmd.setString(2, i.getTelefone());
            cmd.setString(3, i.getTipo());
            cmd.setDouble(4, i.getValor());
            cmd.setString(5, i.getStatus());
            
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

    

  public List<Imovel> listar() 
    {
        try {
            String SQL = "select * from tb_vendas";
                        
            
            cmd = con.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();
            List<Imovel> lista = new ArrayList<>();
            while (rs.next())
            {
                Imovel i = new Imovel  (rs.getInt("id"),
                                        rs.getString("nome_proprietario"),
                                        rs.getString("telefone_proprietario"),
                                        rs.getString("tipo"),
                                        rs.getDouble("valor_venda"),
                                        rs.getString("status"));
                
                lista.add(i);
                
            }    
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.desconectar(con);
        }
    }
  


public List<Imovel> pesquisarTipo(String tipo) 
    {
        try {
            String SQL = "select * from tb_vendas where tipo ilike ?";
                     
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, tipo);
            ResultSet rs = cmd.executeQuery();
            List<Imovel> lista = new ArrayList<>();
            while (rs.next())
            {
                 Imovel i = new Imovel  (rs.getInt("id"),
                                        rs.getString("nome_proprietario"),
                                        rs.getString("telefone_proprietario"),
                                        rs.getString("tipo"),
                                        rs.getDouble("valor_venda"),
                                        rs.getString("status"));
                
                lista.add(i);
                
            }    
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.desconectar(con);
        }
    }

public List<Imovel> pesquisarStatus(String status) 
    {
        try {
            String SQL = "select * from tb_vendas where status ilike ?";
                     
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, status);
            ResultSet rs = cmd.executeQuery();
            List<Imovel> lista = new ArrayList<>();
            while (rs.next())
            {
                 Imovel i = new Imovel  (rs.getInt("id"),
                                        rs.getString("nome_proprietario"),
                                        rs.getString("telefone_proprietario"),
                                        rs.getString("tipo"),
                                        rs.getDouble("valor_venda"),
                                        rs.getString("status"));
                
                lista.add(i);
                
            }    
            return lista;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.desconectar(con);
        }
    }
     
}

    
  