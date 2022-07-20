/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect1_201904013;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Isai Figueroa
 */
public class DCARGACLIENT implements ActionListener  {
    JFrame ventanaAnterior;
 
public DCARGACLIENT (JFrame ventanaAnterior){
this.ventanaAnterior=ventanaAnterior;
} 
    @Override
    public void actionPerformed(ActionEvent e) {
 /*se hace visible la ventana NUEVA y se cierra la anterior*/      
        CARCLIENTE VDC =new CARCLIENTE();
        VDC.setVisible(true);
        VDC.repaint();
        ventanaAnterior.setVisible(false);
    }
}
