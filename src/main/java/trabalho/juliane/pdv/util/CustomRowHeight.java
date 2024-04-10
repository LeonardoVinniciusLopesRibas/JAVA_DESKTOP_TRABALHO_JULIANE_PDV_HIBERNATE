package trabalho.juliane.pdv.util;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomRowHeight extends DefaultTableCellRenderer{
    
    private int rowHeight;

    public CustomRowHeight() {
    }

    
    // Construtor para definir a altura desejada
    public CustomRowHeight(int rowHeight) {
        this.rowHeight = rowHeight;
    }

    // Método para configurar a altura da linha
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        table.setRowHeight(row, rowHeight); // Define a altura da linha
        return c;
    }
    
}
