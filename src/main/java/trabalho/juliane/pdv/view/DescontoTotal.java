package trabalho.juliane.pdv.view;

public class DescontoTotal extends javax.swing.JInternalFrame {

    private double descontoTotal;
    private PdvView pdvView;

    public DescontoTotal(PdvView pdvView, double descontoTotal) {
        initComponents();
        this.descontoTotal = descontoTotal;
        this.pdvView = pdvView;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfDescontoTotal = new javax.swing.JTextField();
        jbAddDescontoTotal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jtfDescontoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescontoTotalActionPerformed(evt);
            }
        });

        jbAddDescontoTotal.setText("Add");
        jbAddDescontoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddDescontoTotalActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aplicar Desconto EM PORCENTAGEM");

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jtfDescontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAddDescontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDescontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAddDescontoTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAddDescontoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddDescontoTotalActionPerformed
        // TODO add your handling code here:
        String descontoStr = jtfDescontoTotal.getText();

        try {
            // Converte o valor do desconto para double
            double desconto = Double.parseDouble(descontoStr);

            pdvView.calcularRateioDesconto(desconto);
            dispose();
        } catch (NumberFormatException e) {
            // Trata o caso em que o valor informado não é um número válido
            // Aqui você pode exibir uma mensagem de erro ao usuário
            System.err.println("Valor de desconto inválido: " + descontoStr);
        }

    }//GEN-LAST:event_jbAddDescontoTotalActionPerformed

    private void jtfDescontoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescontoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescontoTotalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbAddDescontoTotal;
    private javax.swing.JTextField jtfDescontoTotal;
    // End of variables declaration//GEN-END:variables
}
