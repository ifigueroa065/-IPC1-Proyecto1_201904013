/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect1_201904013;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Isai Figueroa
 */
public class CARCLIENTE extends JFrame {
      JPanel PANELITO; 
     JLabel CONFIRM;
     
public CARCLIENTE (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(600, 300);
    setTitle("Carga masiva de Clientes");
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
    
    CONFIRM =new JLabel("CARGA EXITOSA");
   CONFIRM .setBounds(150,150,300,30);
   CONFIRM .setForeground(Color.white);
   CONFIRM .setFont(new Font ("Tahoma",Font.BOLD,24));
   PANELITO.add(CONFIRM );
    
    JButton carga =new JButton("Carga masiva ");
     carga.setBounds(100,75,215,40);
    PANELITO.add(carga);
    
    
carga.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc =new JFileChooser();
            int op=fc.showDialog(PANELITO,null);
            if(op==JFileChooser.APPROVE_OPTION){
                
                try {
                    File archivo=fc.getSelectedFile();
                    FileReader fr=new FileReader(archivo);
                    BufferedReader br=new BufferedReader(fr);
                    
                    String linea;
                    while ((linea=br.readLine())!= null) {
                       System.out.println(linea);
                        
                    }
                    
                } catch (Exception e2) {
                  e2.getStackTrace();
                }
  
            }
        }
    });
    
JButton volver = new JButton("VOLVER");
        volver.setBounds(425, 20, 100, 25);
        PANELITO.add(volver);
    //PARA CREAR UN USUARIO

      volver.addActionListener(new ActionListener() {      
   /*PARA VOLVER AL LOGIN*/
    @Override
           public void actionPerformed(ActionEvent e) {
           ADMINCLIEN volver= new ADMINCLIEN();
           volver.setVisible(true);
           volver.repaint();
           setVisible(false);
           
           }
       });
}
}
