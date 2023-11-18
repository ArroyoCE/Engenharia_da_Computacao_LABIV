package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;



public class ClienteDAO {
    
    private final Connection con;
    private PreparedStatement cmd;
    
    public ClienteDAO(){
        con = Conexao.conectar();
    }
   
    public int inserir(Cliente c){
        try {
            String SQL="insert into tb_cliente values (?,?,?);";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, c.getCpf());
            cmd.setString(2, c.getNome());
            cmd.setString(3, c.getEmail());
            if (cmd.executeUpdate() > 0){
                return 1;   //Usuário criado com sucesso
            }else{
                return -1;  //Não foi possível criar o usuário
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
    
    public List<Cliente> listar() {
        try {
            String SQL = "select * "
                    + "from tb_cliente "
                    + "order by nome";
            cmd = con.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();
            List<Cliente> lista = new ArrayList<>();
            while (rs.next()) {
            Cliente c = new Cliente(
                    rs.getString("cpf"),
                    rs.getString("nome"),
                    rs.getString("email")
                );
                lista.add(c);
            } 
            return lista;
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.desconectar(con);
        }            
    }
    
    public String atualizar (Cliente c) 
    {
        try {
            String SQL = "update tb_cliente set nome=?, email=? where cpf=?";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, c.getNome());
            cmd.setString(2, c.getEmail());
            cmd.setString(3, c.getCpf());
            if(cmd.executeUpdate() > 0)
                return c.getNome();
            
            return "Erro";
        }catch (SQLException e) {
            System.err.println("ERRO" + e.getMessage());
            return "Erro";
        }finally{
            Conexao.desconectar(con);
        }
    }
}
