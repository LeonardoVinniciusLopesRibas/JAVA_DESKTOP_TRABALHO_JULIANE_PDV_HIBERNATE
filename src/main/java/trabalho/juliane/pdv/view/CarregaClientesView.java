package trabalho.juliane.pdv.view;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import trabalho.juliane.pdv.dao.ClienteDao;
import trabalho.juliane.pdv.model.Cliente;
import trabalho.juliane.pdv.util.EntityManagerUtil;
import trabalho.juliane.pdv.util.SetIcon;
import trabalho.juliane.pdv.util.Tabela;

public class CarregaClientesView extends javax.swing.JInternalFrame {

    private ClienteDao clienteDao;
    private DefaultListModel<Cliente> clienteListModel;
    SetIcon si = new SetIcon();
    
    public CarregaClientesView() {
        initComponents();
        si.setIconFechar(jbFechar);
        clienteDao = new ClienteDao(EntityManagerUtil.getManager());
        clienteListModel = new DefaultListModel<>();
        carregarClientes();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbFechar = new javax.swing.JButton();
        jpnClientes = new javax.swing.JPanel();

        jbFechar.setText("FECHAR");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnClientesLayout = new javax.swing.GroupLayout(jpnClientes);
        jpnClientes.setLayout(jpnClientesLayout);
        jpnClientesLayout.setHorizontalGroup(
            jpnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnClientesLayout.setVerticalGroup(
            jpnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(314, Short.MAX_VALUE)
                .addComponent(jbFechar)
                .addContainerGap())
            .addComponent(jpnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbFechar)
                .addGap(0, 34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void carregarClientes() {
    try {
        // Criar a tabela com as colunas necessárias
        Object[] colunas = {"ID", "Nome", "Documento"}; // Colunas da tabela
        Object[] largura = {60, 200, 150}; // Largura das colunas
        Object[] alinhamento = {"centro", "esquerda", "esquerda"}; // Alinhamento das colunas
        JTable tabelaClientes = new Tabela().criarTabela(jpnClientes, largura, alinhamento, colunas);

        // Limpar o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaClientes.getModel();
        modeloTabela.setRowCount(0);

        // Carregar os clientes do banco de dados
        ArrayList<Cliente> clientes = clienteDao.selectAllCliente();
        if (clientes != null) {
            for (Cliente cliente : clientes) {
                // Adicionar cada cliente como uma nova linha na tabela
                modeloTabela.addRow(new Object[]{cliente.getId(), cliente.getNome(), cliente.getCpfcnpj()});
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar os clientes.");
        }
    } catch (NullPointerException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao criar a tabela de clientes.");
    }
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbFechar;
    private javax.swing.JPanel jpnClientes;
    // End of variables declaration//GEN-END:variables
}
