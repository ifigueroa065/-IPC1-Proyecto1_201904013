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
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static proyect1_201904013.CREARPRO.contadorPro;
import static proyect1_201904013.CREARVENTA.contadorDET;
import static proyect1_201904013.CREARVENTA.contadorVENTA;
import static proyect1_201904013.PROYECT1_201904013.ADETALLE;
import static proyect1_201904013.PROYECT1_201904013.PRODUCTOS;
import static proyect1_201904013.PROYECT1_201904013.VENTA;

/**
 *
 * @author Isai Figueroa
 */
public class INFOVENTA extends JFrame{
     JPanel PANELITO; 
     JTextField NIT,CODIGO,TOTAL,IVA;
     JLabel img2;
     File archivo;
     static boolean OPCION=false;
     static Object TABLA[][] = new Object[6][6];
     
public INFOVENTA (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(600, 550);
    setTitle("Vista Informativa");
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
   Label N1 =new Label("CODIGO DE VENTA");
   N1.setBounds(30,30,160,30);
   N1.setForeground(Color.white);
   N1.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N1);

Label N2 =new Label("NIT");
   N2.setBounds(30,90,30,30);
   N2.setForeground(Color.white);
   N2.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N2);   
   
   Label N3 =new Label("PRODUCTOS EN LA VENTA");
   N3.setBounds(30,140,185,30);
   N3.setForeground(Color.white);
   N3.setFont(new Font ("Tahoma",Font.BOLD,14));
   PANELITO.add(N3);   
   
   Label N4 =new Label("TOTAL DE LA VENTA");
   N4.setBounds(30,370,150,30);
   N4.setForeground(Color.white);
   N4.setFont(new Font ("Tahoma",Font.BOLD,14));
   PANELITO.add(N4);   
   
   Label N5 =new Label("IVA");
   N5.setBounds(150,430,30,30);
   N5.setForeground(Color.white);
   N5.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N5); 
   
   
   
   CODIGO = new JTextField();
CODIGO.setBounds(200, 30,100, 30);
PANELITO.add(CODIGO);

 NIT = new JTextField();
NIT.setBounds(80, 90, 100, 30);
NIT.setEditable(false);
PANELITO.add(NIT);

 TOTAL = new JTextField();
TOTAL.setBounds(200,370, 150, 30);
TOTAL.setEditable(false);
PANELITO.add(TOTAL);

IVA = new JTextField();
IVA.setBounds(200,430, 150, 30);
IVA.setEditable(false);
PANELITO.add(IVA);

JButton consultar = new JButton("CONSULTAR");
    consultar.setBounds(450, 85, 125, 25);
    PANELITO.add(consultar);
  

        
JButton volver = new JButton("VOLVER");
        volver.setBounds(475, 15, 100, 25);
        PANELITO.add(volver);

volver.addActionListener(new ActionListener() {      
   /*PARA VOLVER AL ADMINISTRADOR DE CLIENTES*/
          
    @Override
           public void actionPerformed(ActionEvent e) {
           ADMINVEN volver= new ADMINVEN();
           volver.setVisible(true);
           volver.repaint();
           setVisible(false);
           
           }
       });
consultar.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           System.out.println("me estoy ejecutando");
           String codix=CODIGO.getText();
             if (COMPROBAR(codix)==true) {
               
           } else {
                 JOptionPane.showMessageDialog(null, "El CODIGO DE VENTA  "+ codix +" NO EXISTE");
                 
           }
       }
   });
}
public boolean COMPROBAR(String codigoventa){
    /*se comprueba que el nit exista*/
        boolean condicional = false;
float auxprecio=0;
        for (int i = 0; i < contadorVENTA; i++) {
            if (VENTA[i].getCODIXVENTA().equals(codigoventa)) {
              //si el codigo de venta existe
              
              /*Se mandan a llamar los datos en base al codigo de venta*/
                int contrpo = VENTA[i].getContpro();
                NIT.setText(String.valueOf(VENTA[i].getNIT()));
                TOTAL.setText(String.valueOf(VENTA[i].getTOTAL()));
                IVA.setText(String.valueOf(VENTA[i].getIVA()));
                /*creando la tabla de detalle*/
                for (int j = 0; j < contadorDET; j++) {
                    if (ADETALLE[j].getCODIGOVENTA().equals(codigoventa)) {
                        TABLA[j][0] = ADETALLE[j].getNOMBREPRO();
                        TABLA[j][1] = ADETALLE[j].getCANTCOMPRADA();
                        TABLA[j][2] = ADETALLE[j].getPRECIOPRO();
                        String[] columnas = {"PRODUCTO", "CANTIDAD", "PRECIO"};
                        JTable tablita = new JTable(TABLA, columnas);
                        tablita.setEnabled(false);
                        JScrollPane bblean = new JScrollPane(tablita);
                        bblean.setBounds(50, 190, 400, 120);
                        PANELITO.add(bblean);
                    } else {
                    }
                }
    
             
             
               condicional = true;
                break;
            }else{
            condicional=false;
            }
           
        }
           
        return condicional;
    }
public void CREARTABLA(){

        for (int i = 0; i < contadorDET; i++) {
            TABLA[i][0]=ADETALLE[i].getNOMBREPRO();
            TABLA[i][1]=ADETALLE[i].getCANTCOMPRADA();
        }
    String []columnas={"PRODUCTO","CANTIDAD"};
        JTable tablita=new JTable(TABLA, columnas);
        tablita.setEnabled(false);
        JScrollPane bblean=new JScrollPane(tablita);
   
        bblean.setBounds(50, 390, 400, 120);
        PANELITO.add(bblean);
}
}
