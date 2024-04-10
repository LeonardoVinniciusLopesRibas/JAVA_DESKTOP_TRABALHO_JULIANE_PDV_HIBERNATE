
package trabalho.juliane.pdv.view;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import trabalho.juliane.pdv.dao.ProdutoDao;
import trabalho.juliane.pdv.model.Produto;
import trabalho.juliane.pdv.util.EntityManagerUtil;
import trabalho.juliane.pdv.util.SetIcon;
import trabalho.juliane.pdv.util.Tabela;

public class CarregaProdutosView extends javax.swing.JInternalFrame {


    private ProdutoDao produtoDao;
    private DefaultListModel<Produto> produtoListModel;
    
    SetIcon si = new SetIcon();
    JTable tabelaProdutos = null;
    int id = 0;
    String codigorapido = null;
    String descricao = null;
    int qtd = 0;
    double valorvenda = 0.0;
    private PdvView pdvView;
    
    public CarregaProdutosView(PdvView pdvView) {
        initComponents();
        si.setIconFechar(jbFechar);
        produtoDao = new ProdutoDao(EntityManagerUtil.getManager());
        produtoListModel = new DefaultListModel<>();
        carregaProdutos();
        this.pdvView = pdvView;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnProdutos = new javax.swing.JPanel();
        jbFechar = new javax.swing.JButton();

        javax.swing.GroupLayout jpnProdutosLayout = new javax.swing.GroupLayout(jpnProdutos);
        jpnProdutos.setLayout(jpnProdutosLayout);
        jpnProdutosLayout.setHorizontalGroup(
            jpnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnProdutosLayout.setVerticalGroup(
            jpnProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );

        jbFechar.setText("FECHAR");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(397, Short.MAX_VALUE)
                .addComponent(jbFechar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void carregaProdutos(){
        try{
            Object[] colunas = {"Id", "Codigo Rápido", "Descrição", "Valor Venda"};
            Object[] largura = {60, 60, 200, 100};
            Object[] alinhamento = {"centro", "centro", "esquerda", "esquerda"};
            tabelaProdutos = new Tabela().criarTabela(jpnProdutos, largura, alinhamento, colunas);
            
            DefaultTableModel modeloTabela = (DefaultTableModel) tabelaProdutos.getModel();
            modeloTabela.setRowCount(0);
            
            ArrayList<Produto> produto = produtoDao.selectAllProduto();
            
            if(produto != null){
                for (Produto produtos : produto){
                    modeloTabela.addRow(new Object[] {produtos.getId(), produtos.getCodigoRapido(), produtos.getDescricao(), produtos.getValorVenda()});
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível carregar os produtos");
            }
        }catch(NullPointerException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao criar a tabela de produtos.");
        }
        tabelaProdutos.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event){
                if(!event.getValueIsAdjusting()){
                    int selectedRow = tabelaProdutos.getSelectedRow();
                    if(selectedRow != 1){
                        DefaultTableModel model = (DefaultTableModel) tabelaProdutos.getModel();
                        id = (Integer) model.getValueAt(selectedRow, 0);
                        codigorapido = model.getValueAt(selectedRow, 1).toString();
                        descricao = model.getValueAt(selectedRow, 2).toString();
                        qtd = 1;
                        valorvenda = (Double) model.getValueAt(selectedRow, 3);
                        enviarDadosProdutos(id, codigorapido, descricao, qtd, valorvenda);
                    }
                    
                }
            }

            private void enviarDadosProdutos(int id, String codigorapido, String descricao, int qtd, double valorvenda) {
                
                pdvView.enviaDadosProdutos(id, codigorapido, descricao, qtd, valorvenda);
                dispose();
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbFechar;
    private javax.swing.JPanel jpnProdutos;
    // End of variables declaration//GEN-END:variables
}
