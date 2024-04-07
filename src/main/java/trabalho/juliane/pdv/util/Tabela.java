package trabalho.juliane.pdv.util;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Tabela {
    
    public JTable criarTabela(JPanel jpn, Object[] largura, Object[] pos, Object[] col) throws NullPointerException {
        
        
        //método para impedir edição de células na tabela
        JTable tabela = new JTable(new DefaultTableModel()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Impedir a edição de todas as células
                return false;
            }
        };
        tabela.setVisible(true);
        JScrollPane jsp = new JScrollPane(tabela);
        //x, y, width, height
        jsp.setBounds(2, 26, 400, 350);
        
        jsp.setVisible(true);
        jpn.add(jsp);
        DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();

        for (int i = 0; i < col.length; i++) {
            modeloTabela.addColumn(col[i]);
        }

        //CRIANDO OBJETO PARA ALINHAMENTO DOS DADOS DENTRO DA TABELA
        DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();

        //ADICIONANDO POSIÇÕES
        centro.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);

        //TRABALHANDO COM AS COLUNAS
        for (int i = 0; i < largura.length; i++) {
            if (pos[i].equals("centro")) {
                pos[i] = centro;
            }
            if (pos[i].equals("direita")) {
                pos[i] = direita;
            }
            if (pos[i].equals("esquerda")) {
                pos[i] = esquerda;
            }

            tabela.getColumnModel().getColumn(i).setMaxWidth(Integer.parseInt(largura[i].toString()));
            tabela.getColumnModel().getColumn(i).setCellRenderer((TableCellRenderer) pos[i]);

        }
        return tabela;

    }
    
}
