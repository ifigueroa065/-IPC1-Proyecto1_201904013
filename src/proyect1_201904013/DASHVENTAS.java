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
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static proyect1_201904013.CREARVENTA.contadorDET;
import static proyect1_201904013.CREARVENTA.contadorVENTA;
import static proyect1_201904013.PROYECT1_201904013.ADETALLE;
import static proyect1_201904013.PROYECT1_201904013.VENTA;

/**
 *
 * @author Isai Figueroa
 */
public class DASHVENTAS extends JFrame{
     JPanel PANELITO; 
     JTextField VENTAS,IVA;
    static  Object TABLA[][]=new Object[100][100];
     
public DASHVENTAS (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(750, 450);
    setTitle("Dashboard de Ventas");
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
        volver.setBounds(625, 20, 100, 25);
        PANELITO.add(volver);
        
        JButton tablas = new JButton("Tablas");
        tablas.setBounds(20, 20, 100, 25);
        PANELITO.add(tablas);
        
        JButton valorventas = new JButton("VALOR VENTAS");
        valorventas.setBounds(170, 20, 150, 25);
        PANELITO.add(valorventas);
        
        JButton totiva = new JButton("TOTAL IVA");
        totiva.setBounds(170, 60, 150, 25);
        PANELITO.add(totiva);
        
        VENTAS = new JTextField();
        VENTAS.setBounds(350, 20, 175, 25);
        PANELITO.add(VENTAS);

        IVA = new JTextField();
        IVA.setBounds(350, 60, 175, 25);
        PANELITO.add(IVA);
        
   Label N5 =new Label("VENTAS EN EL SISTEMA");
   N5.setBounds(30,150,250,25);
   N5.setForeground(Color.white);
   N5.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N5); 
    
      volver.addActionListener(new ActionListener() {      
   /*PARA VOLVER AL ADMINISTRADOR DE VENTAS*/
          
    @Override
           public void actionPerformed(ActionEvent e) {
           ADMINVEN volver= new ADMINVEN();
           volver.setVisible(true);
           volver.repaint();
           setVisible(false);
           
           }
       });
  tablas.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < contadorVENTA; i++) {
            TABLA[i][0]=VENTA[i].getCODIXVENTA();
            TABLA[i][1]=VENTA[i].getNIT();
            TABLA[i][2]=VENTA[i].getTOTAL();
           
        }
    String []columnas={"CODIGO DE VENTA","CLIENTE","TOTAL"};
        JTable tablita=new JTable(TABLA, columnas);
        tablita.setEnabled(false);
        JScrollPane bblean=new JScrollPane(tablita);
  
      bblean.setBounds(70, 205, 500, 100);
        PANELITO.add(bblean);   
    }
    
});
  valorventas.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          float temp = 0;
          for (int i = 0; i < contadorVENTA; i++) {
              temp = temp + VENTA[i].getTOTAL();
          }
          VENTAS.setText(String.valueOf(temp));
      }
        });
 totiva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               float temp = 0;
          for (int i = 0; i < contadorVENTA; i++) {
              temp = temp + VENTA[i].getIVA();
          }
          IVA.setText(String.valueOf(temp));
        
                
            }
        });
}
}
