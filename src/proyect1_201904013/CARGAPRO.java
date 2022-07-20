/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect1_201904013;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Isai Figueroa
 */
public class CARGAPRO extends JFrame{
      JPanel PANELITO; 
     JTextField usuario,contraseña;
     
public CARGAPRO (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(600, 300);
    setTitle("Carga masiva de Productos");
    setLocationRelativeTo(null);
    /*llamamos al metodo que agrega botones al panel */
    iniciar();
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
}
private void iniciar(){

    crearpanel();
   VENTANA();
}

private void  crearpanel(){
    /*se crea el panel y se le da color*/
this.PANELITO=new JPanel();
this.PANELITO.setBackground(new Color(50,50,80));
this.PANELITO.setLayout(null);
this.add(PANELITO);

}
public void VENTANA(){
JButton volver = new JButton("VOLVER");
        volver.setBounds(425, 20, 100, 25);
        PANELITO.add(volver);
    //PARA CREAR UN USUARIO

      volver.addActionListener(new ActionListener() {      
   /*PARA VOLVER AL LOGIN*/
    @Override
           public void actionPerformed(ActionEvent e) {
           ADMINPRO volver= new ADMINPRO();
           volver.setVisible(true);
           volver.repaint();
           setVisible(false);
           
           }
       });
}
}
