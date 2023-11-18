package controller;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;
import model.Funcionario;


public class FuncionarioDAO {
    
    private final Connection con;
    private PreparedStatement cmd;
    
    public FuncionarioDAO(){
        con = Conexao.conectar();
    }
   
    public int inserir(Funcionario f){
        try {
            String SQL="insert into tb_funcionario (nome,cargo) values (?,?);";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, f.getNome());
            cmd.setString(2, f.getCargo());
            
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
    
    public List<Funcionario> listar() {
        try {
            String SQL = "select * "
                    + "from tb_funcionario "
                    + "order by nome";
            cmd = con.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();
            List<Funcionario> lista = new ArrayList<>();
            while (rs.next()) {
                Funcionario f = new Funcionario(
                    rs.getString("id"),
                    rs.getString("nome"),
                    rs.getString("cargo")
                );
                lista.add(f);
            } 
            return lista;
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.desconectar(con);
        }
    }
    
    public String atualizar (Funcionario f) 
      {
        try {
            String SQL = "update tb_funcionario set nome = ?, cargo = ? where id = ?";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, f.getNome());
            cmd.setString(2, f.getCargo());
            cmd.setInt(3, parseInt(f.getId()));
            
            if(cmd.executeUpdate() > 0)
                return f.getNome();
            
            return "Erro";
        }catch (SQLException e) {
            System.err.println("ERRO" + e.getMessage());
            return "Erro";
        }finally{
            Conexao.desconectar(con);
        }
    }
            
}
