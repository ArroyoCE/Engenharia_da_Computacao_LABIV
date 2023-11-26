package view;

import controller.ClienteDAO;
import controller.FornecedorDAO;
import controller.FuncionarioDAO;
import controller.ProdutoDAO;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Fornecedor;
import model.Funcionario;
import model.Produto;


public class FormConsulta extends javax.swing.JFrame {

    /**
     * Creates new form FormConsulta
     */
    public FormConsulta() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Farmácia Popular - Consulta");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        btnFornecedores.doClick();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnFornecedores = new javax.swing.JRadioButton();
        btnClientes = new javax.swing.JRadioButton();
        btnFuncionarios = new javax.swing.JRadioButton();
        btnEstoque = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabPesquisa = new javax.swing.JTable();
        txtBusca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTA");

        buttonGroup1.add(btnFornecedores);
        btnFornecedores.setSelected(true);
        btnFornecedores.setText("Fornecedores");
        btnFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedoresActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnClientes);
        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnFuncionarios);
        btnFuncionarios.setText("Funcionários");
        btnFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionariosActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnEstoque);
        btnEstoque.setText("Estoque");
        btnEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstoqueActionPerformed(evt);
            }
        });

        tabPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPesquisaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabPesquisa);

        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnFornecedores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFuncionarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14)))
                .addGap(137, 137, 137))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFornecedores)
                    .addComponent(btnClientes)
                    .addComponent(btnFuncionarios)
                    .addComponent(btnEstoque))
                .addGap(18, 18, 18)
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedoresActionPerformed
        configurarTabelaFornecedores();
        List<Fornecedor> lista = new FornecedorDAO().listar();
        
               
        DefaultTableModel m = (DefaultTableModel)tabPesquisa.getModel();
            
            for(Fornecedor f : lista)
            {
                m.addRow(new Object[]{
                f.getCNPJ(), f.getTelefone(), f.getNome()});
                
            }
            tabPesquisa.setModel(m);
    }//GEN-LAST:event_btnFornecedoresActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        configurarTabelaClientes();
         List<Cliente> lista = new ClienteDAO().listar();
        
               
        DefaultTableModel m = (DefaultTableModel)tabPesquisa.getModel();
            
            for(Cliente f : lista)
            {
                m.addRow(new Object[]{
                f.getCpf(), f.getNome(), f.getEmail()});
                
            }
            tabPesquisa.setModel(m);
        
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionariosActionPerformed
        configurarTabelaFuncionarios();
         List<Funcionario> lista = new FuncionarioDAO().listar();
        
               
        DefaultTableModel m = (DefaultTableModel)tabPesquisa.getModel();
            
            for(Funcionario f : lista)
            {
                m.addRow(new Object[]{
                f.getId(), f.getNome(), f.getCargo()});
                
            }
            tabPesquisa.setModel(m);
    }//GEN-LAST:event_btnFuncionariosActionPerformed

    private void btnEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstoqueActionPerformed
            configurarTabelaEstoque();
            List<Produto> lista = new ProdutoDAO().listar();
        
               
        DefaultTableModel m = (DefaultTableModel)tabPesquisa.getModel();
            
            for(Produto p : lista)
            {
                m.addRow(new Object[]{
                p.getId_produto(), p.getFornecedor(), p.getNome(), p.getValor(), p.getQuantidade() });
                
            }
            tabPesquisa.setModel(m);
    }//GEN-LAST:event_btnEstoqueActionPerformed

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        String chave = txtBusca.getText();
        
        if (!chave.isEmpty() & btnFornecedores.isSelected())
        {
            List<Fornecedor> lista = new FornecedorDAO().pesquisarPorNome(chave);
            configurarTabelaFornecedores();
            
            DefaultTableModel m = (DefaultTableModel)tabPesquisa.getModel();
            
            for(Fornecedor f : lista)
            {
                m.addRow(new Object[]{
                         f.getCNPJ(), f.getNome(), f.getTelefone()});
                
            }
            tabPesquisa.setModel(m);
            
        }
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void tabPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPesquisaMouseClicked
        if(evt.getClickCount() == 2)
        {    
            
        
            if (btnEstoque.isSelected())
            {
            int linha = tabPesquisa.getSelectedRow();   
            String id = tabPesquisa.getValueAt(linha, 0).toString();
            String fornecedor = tabPesquisa.getValueAt(linha, 1).toString();
            String nome = tabPesquisa.getValueAt(linha, 2).toString();
            String preco = tabPesquisa.getValueAt(linha, 3).toString();
            String qtd = tabPesquisa.getValueAt(linha, 4).toString();
            Produto p = new Produto();
            p.setId_produto(parseInt(id));
            p.setFornecedor(fornecedor);
            p.setNome(nome);
            p.setValor(parseFloat(preco));
            p.setQuantidade(parseInt(qtd));
            FormCadastro f = new FormCadastro(p);
            f.setVisible(true);
            this.dispose();
            }
            
            else if (btnFuncionarios.isSelected())
            {
            int linha = tabPesquisa.getSelectedRow();    
            String id = tabPesquisa.getValueAt(linha, 0).toString();
            String nome = tabPesquisa.getValueAt(linha, 1).toString();
            String cargo = tabPesquisa.getValueAt(linha, 2).toString();
            
            Funcionario f = new Funcionario();
            f.setNome(nome);
            f.setId(id);
            f.setCargo(cargo);
            FormCadastro n = new FormCadastro(f);
            n.setVisible(true);
            this.dispose();   
            }    
        }
        else
        {
            
        }    
    }//GEN-LAST:event_tabPesquisaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        FormMenu f = new FormMenu();
        f.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing
    
    private void configurarTabelaFornecedores() {
        DefaultTableModel m = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        m.addColumn("CNPJ");
        m.addColumn("Nome");
        m.addColumn("Telefone");
        tabPesquisa.setModel(m);
    }
    
       private void configurarTabelaClientes() {
        DefaultTableModel m = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        m.addColumn("CPF");
        m.addColumn("Nome");
        m.addColumn("E-mail");
        tabPesquisa.setModel(m);
    }
       
    private void configurarTabelaFuncionarios() {
        DefaultTableModel m = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        m.addColumn("ID");
        m.addColumn("Nome");
        m.addColumn("Cargo");
        tabPesquisa.setModel(m);
    }
    
    private void configurarTabelaEstoque() {
        DefaultTableModel m = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        m.addColumn("ID");
        m.addColumn("Fornecedor");
        m.addColumn("Nome");
        m.addColumn("Custo Unitário");
        m.addColumn("Quantidade");
        tabPesquisa.setModel(m);
    }
  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormConsulta().setVisible(true);
               
            }
            
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnClientes;
    private javax.swing.JRadioButton btnEstoque;
    private javax.swing.JRadioButton btnFornecedores;
    private javax.swing.JRadioButton btnFuncionarios;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabPesquisa;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
