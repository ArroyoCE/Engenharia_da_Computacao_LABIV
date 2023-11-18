package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;



public class FornecedorDAO {
    
    private final Connection con;
    private PreparedStatement cmd;
    
    public FornecedorDAO(){
        con = Conexao.conectar();
    }
   
    public int inserir(Fornecedor u){
        try {
            String SQL="insert into tb_fornecedor values (?,?,?);";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, u.getCNPJ());
            cmd.setString(2, u.getTelefone());
            cmd.setString(3, u.getNome());
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
    
    public List<Fornecedor> listar() {
        try {
            String SQL = "select * "
                    + "from tb_fornecedor "
                    + "order by nome";
            cmd = con.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();
            List<Fornecedor> lista = new ArrayList<>();
            while (rs.next()) {
                Fornecedor f = new Fornecedor(
                    rs.getString("cnpj"),
                    rs.getString("telefone"),
                    rs.getString("nome")
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
    
    public String atualizar (Fornecedor f) 
    {
        try {
            String SQL = "update tb_fornecedor set nome=?, telefone=? where cnpj=?";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, f.getNome());
            cmd.setString(2, f.getTelefone());
            cmd.setString(3, f.getCNPJ());
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
