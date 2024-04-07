/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.juliane.pdv.util;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author leona
 */
public class PosicaoFormulario {
 
    public void abrirFormulario(JInternalFrame janela, JDesktopPane desktop){
        
        int lDesk = desktop.getWidth();
        int aDesk = desktop.getHeight();
        int lIframe = janela.getWidth();
        int aIframe = janela.getHeight();
        
        janela.setLocation(lDesk / 2 - lIframe / 2, aDesk / 2 - aIframe / 2);
        desktop.add(janela);
        janela.setVisible(true);
    }
    
}
