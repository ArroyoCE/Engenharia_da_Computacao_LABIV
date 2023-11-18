package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String DATABASE = "FARMACIA";
    private static final String HOST = "localhost";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://" + HOST + "/" + DATABASE;
    private static final String USR = "postgres";
    private static final String PWD = "password";

    public static Connection conectar() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USR, PWD);
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }

    public static void desconectar(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Connection con = conectar();
        if (con!= null){
            System.out.println("Conexão realizada com sucesso.");
            desconectar(con);
        }
    }

}

