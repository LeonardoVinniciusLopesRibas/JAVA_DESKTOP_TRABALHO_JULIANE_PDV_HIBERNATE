package trabalho.juliane.pdv.util;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SetIcon {

    public void setIconFinalizar(JButton jbFinalizar) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\TrabalhoJulianePdv\\TrabalhoJulianePdv\\src\\main\\java\\trabalho\\juliane\\pdv\\icon\\finalizar.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);//C:\Users\leona\OneDrive\Documentos\NetBeansProjects\TrabalhoJulianePdv\TrabalhoJulianePdv\src\main\java\trabalho\juliane\pdv\icon
        jbFinalizar.setIcon(imageIcon);

    }

    public void setFormaPagamento(JButton jbFormaPagamento) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\TrabalhoJulianePdv\\TrabalhoJulianePdv\\src\\main\\java\\trabalho\\juliane\\pdv\\icon\\formaPagamento.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jbFormaPagamento.setIcon(imageIcon);

    }

    public void setRemoverDesconto(JButton jbRemoverDesconto) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\TrabalhoJulianePdv\\TrabalhoJulianePdv\\src\\main\\java\\trabalho\\juliane\\pdv\\icon\\removerDesconto.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jbRemoverDesconto.setIcon(imageIcon);

    }

    public void setRemoverProduto(JButton jbRemoverProduto) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\TrabalhoJulianePdv\\TrabalhoJulianePdv\\src\\main\\java\\trabalho\\juliane\\pdv\\icon\\removerProduto.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jbRemoverProduto.setIcon(imageIcon);

    }

    public void setDesconto(JButton jbDescontoTotal) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\TrabalhoJulianePdv\\TrabalhoJulianePdv\\src\\main\\java\\trabalho\\juliane\\pdv\\icon\\descontoTotal.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jbDescontoTotal.setIcon(imageIcon);

    }

    public void setAdicionarProduto(JButton jbAddProduto) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\TrabalhoJulianePdv\\TrabalhoJulianePdv\\src\\main\\java\\trabalho\\juliane\\pdv\\icon\\addProduto.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jbAddProduto.setIcon(imageIcon);

    }

    public void setAdicionarCliente(JButton jbAddCliente) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\TrabalhoJulianePdv\\TrabalhoJulianePdv\\src\\main\\java\\trabalho\\juliane\\pdv\\icon\\addCliente.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jbAddCliente.setIcon(imageIcon);
        
    }

    public void setNovaVenda(JButton jbNovaVenda) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\TrabalhoJulianePdv\\TrabalhoJulianePdv\\src\\main\\java\\trabalho\\juliane\\pdv\\icon\\novaVenda.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jbNovaVenda.setIcon(imageIcon);

    }

    public void setSair(JButton jbSair) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\TrabalhoJulianePdv\\TrabalhoJulianePdv\\src\\main\\java\\trabalho\\juliane\\pdv\\icon\\sair.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jbSair.setIcon(imageIcon);

    }

    public void setIconFechar(JButton jbFechar) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\TrabalhoJulianePdv\\TrabalhoJulianePdv\\src\\main\\java\\trabalho\\juliane\\pdv\\icon\\sair.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jbFechar.setIcon(imageIcon);

    }
    
}
