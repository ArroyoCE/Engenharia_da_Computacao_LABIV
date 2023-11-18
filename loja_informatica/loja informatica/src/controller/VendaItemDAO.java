package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.VendaItem;

public class VendaItemDAO {

    private final Connection con;
    private PreparedStatement cmd;

    public VendaItemDAO() {
        con = Conexao.conectar();
    }

    public int inserir(VendaItem v) {
        try {
     
            String SQL = "insert into venda_item (produto_id,quantidade,"
                    + "valor_unitario) values (?,?,?)";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, v.getProduto_id());
            cmd.setInt(2, v.getQuantidade());
            cmd.setDouble(3, v.getValor_unitario());
            if (cmd.executeUpdate() > 0){
               
                String SQL1 = "update tb_produto set quantidade=? where id=?";
                cmd = con.prepareStatement(SQL1);
                cmd.setInt(1,v.getEstoque_atual()-v.getQuantidade());
                cmd.setInt(2, v.getProduto_id());
                return cmd.executeUpdate();
            }else{
                return -1;
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        } finally {
            Conexao.desconectar(con);
        }
    }

}