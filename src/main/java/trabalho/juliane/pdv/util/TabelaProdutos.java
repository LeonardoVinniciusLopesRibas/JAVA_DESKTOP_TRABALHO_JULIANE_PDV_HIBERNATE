package trabalho.juliane.pdv.util;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabelaProdutos {
    private DefaultTableModel modeloTabela;
    private JTable tabela;

    public JTable criarTabela(JPanel jpn) {
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("Código Rápido");
        modeloTabela.addColumn("Descrição");
        modeloTabela.addColumn("Valor de Venda");

        tabela = new JTable(modeloTabela);
        JScrollPane jsp = new JScrollPane(tabela);
        jsp.setBounds(2, 26, 400, 350);
        jpn.add(jsp);

        return tabela;
    }

    public void adicionarProduto(int id, String codigoRapido, String descricao, double valorVenda) {
        modeloTabela.addRow(new Object[]{id, codigoRapido, descricao, valorVenda});
    }

    public void limparTabela() {
        modeloTabela.setRowCount(0);
    }
}
