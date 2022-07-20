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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static proyect1_201904013.INTERFAZ.contador;
import static proyect1_201904013.PROYECT1_201904013.REGISTRO;

/**
 *
 * @author Isai Figueroa
 */
public class INTPRINCI extends JFrame{
     JPanel PANELITO; 
     JTextField usuario,contraseña;
     
     
public INTPRINCI (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(600, 300);
    setTitle("INTERFAZ PRINCIPAL");
    setLocationRelativeTo(null);
    /*llamamos al metodo que agrega botones al panel */
    iniciar();
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
}
private void iniciar(){

    crearpanel();
    LOGIN();
}

private void  crearpanel(){
    /*se crea el panel y se le da color*/
this.PANELITO=new JPanel();
this.PANELITO.setBackground(new Color(50,50,80));
this.PANELITO.setLayout(null);
this.add(PANELITO);

}
public void LOGIN(){
 
  

JButton clientes =new JButton("Administración de Clientes");
    clientes.setBounds(100,20,215,40);
    PANELITO.add(clientes);
    clientes.addActionListener(new DISADMINCLIEN(this));
    
    JButton productos =new JButton("Administración de Productos");
productos.setBounds(100,75,215,40);
    PANELITO.add(productos);
    
    productos.addActionListener(new DESADMINPRO(this));
    
    JButton ventas =new JButton("Administración de Ventas");
ventas.setBounds(100,130,215,40);
    PANELITO.add(ventas);
    ventas.addActionListener(new DESADMINVEN(this));
    JButton reporte =new JButton("Reportes");
reporte.setBounds(100,185,215,40);
    PANELITO.add(reporte);
    reporte.addActionListener(new DESREPORT(this));
    
    JButton volver = new JButton("VOLVER");
        volver.setBounds(425, 20, 100, 25);
        PANELITO.add(volver);
        

      volver.addActionListener(new ActionListener() {      
   /*PARA VOLVER AL LOGIN*/
    @Override
           public void actionPerformed(ActionEvent e) {
           INTERFAZ volver= new INTERFAZ();
           volver.setVisible(true);
           volver.repaint();
           setVisible(false);
           
           }
       });
        
}
}
