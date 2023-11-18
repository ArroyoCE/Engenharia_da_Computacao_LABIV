package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Usuario;
import java.sql.ResultSet;

/*
    DAO - Data Access Object
    É um classe que contém todas as operaçõs que serão
    realizada no banco de dados;

*/

public class UsuarioDAO {
    
    private final Connection con;
    private PreparedStatement cmd;
    
    public UsuarioDAO(){
        con = Conexao.conectar();
    }
    
    //Criar uma nova conta de Usuário
    public int inserir(Usuario u){
        try {
            String SQL="insert into tb_usuario (nome,email,senha) values (?,?,md5(?));";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, u.getNome());
            cmd.setString(2, u.getEmail());
            cmd.setString(3, u.getSenha());
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
    public boolean login (Usuario u)
    {
        try {
        String SQL = "select * from tb_usuario where email=? and senha=md5(?)";
        cmd = con.prepareStatement(SQL);
        cmd.setString(1, u.getEmail());
        cmd.setString(2, u.getSenha());
        
        ResultSet rs = cmd.executeQuery();
        if (rs.next())
            return true;
        else
            return false;
        }
    catch (Exception e)
    {
        System.err.println("ERRO: " + e.getMessage());
        return false;
    }
    finally
        {
            Conexao.desconectar(con);
        }
    }
            
}
