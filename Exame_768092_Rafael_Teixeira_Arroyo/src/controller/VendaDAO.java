package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Venda;
import java.sql.Date;



public class VendaDAO {
    
    private final Connection con;
    private PreparedStatement cmd;
    
    public VendaDAO(){
        con = Conexao.conectar();
    }
   
    public int inserir(Venda v){
        try {
            String SQL="insert into tb_venda (id_funcionario, id_produto, id_cliente, data, total, quantidade) values (?,?,?,?,?,?);";
            cmd = con.prepareStatement(SQL);
            
            cmd.setInt(1, v.getId_fun());
            cmd.setInt(2, v.getProd_id());
            cmd.setString(3, v.getCpf());
            //Date date = java.sql.Date.valueOf(v.getDate());
            cmd.setDate(4, (Date) v.getDate());
            cmd.setFloat(5, v.getTotal());
            cmd.setInt(6, v.getQuantidade());
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
    public List<Venda> listar() {
        try {
            String SQL = "select * "
                    + "from tb_venda ";
                    
            cmd = con.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();
            List<Venda> lista = new ArrayList<>();
            while (rs.next()) {
                Venda v = new Venda(
                    rs.getInt("id"),
                    rs.getInt("id_funcionario"),
                    rs.getString("id_cliente"),
                    rs.getDate("data"),
                    rs.getFloat("total"),
                    rs.getInt("quantidade"),
                    rs.getInt("id_produto")
                    
                    
                    
                    
                );
                lista.add(v);
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
