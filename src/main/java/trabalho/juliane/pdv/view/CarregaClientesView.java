package trabalho.juliane.pdv.view;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import trabalho.juliane.pdv.dao.ClienteDao;
import trabalho.juliane.pdv.model.Cliente;
import trabalho.juliane.pdv.util.EntityManagerUtil;

public class CarregaClientesView extends javax.swing.JInternalFrame {

    private ClienteDao clienteDao;
    private DefaultListModel<Cliente> clienteListModel;
    
    public CarregaClientesView() {
        initComponents();
        clienteDao = new ClienteDao(EntityManagerUtil.getManager());
        clienteListModel = new DefaultListModel<>();
        carregarClientes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jtbClientes = new javax.swing.JTable();

        jtbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NOME", "DOCUMENTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtbClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarClientes() {

        ArrayList<Cliente> clientes = clienteDao.selectAllCliente();
        if (clientes != null) {
            clienteListModel.clear();
            for (Cliente cliente : clientes) {
                clienteListModel.addElement(cliente);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar os clientes.");
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jtbClientes;
    // End of variables declaration//GEN-END:variables
}
