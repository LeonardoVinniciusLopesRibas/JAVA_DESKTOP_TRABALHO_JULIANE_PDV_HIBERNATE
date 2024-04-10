package trabalho.juliane.pdv.util;

import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel {
    
    @Override
    public boolean isCellEditable(int row, int column) {
        // Permitir edição apenas na coluna "Desconto"
        return column == getColumnCount() - 1; // Última coluna
    }
    
}
