/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect1_201904013;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static proyect1_201904013.CREARPRO.contadorPro;
import static proyect1_201904013.PROYECT1_201904013.PRODUCTOS;

/**
 *
 * @author Isai Figueroa
 */
public class INFOPRO extends JFrame{
    JPanel PANELITO; 
     JTextField NOMBREB,NOMBRE,PRECIO,CANTIDAD;
     JLabel img3;
     File archivo;
  static String IMAGENG="";
     
public INFOPRO (){
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
   Label N1 =new Label("NOMBRE");
   N1.setBounds(30,30,96,30);
   N1.setForeground(Color.white);
   N1.setFont(new Font ("Tahoma",Font.BOLD,20));
   PANELITO.add(N1);

Label N2 =new Label("Nombre");
   N2.setBounds(30,90,100,30);
   N2.setForeground(Color.white);
   N2.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N2);   
   
   Label N3 =new Label("Precio");
   N3.setBounds(30,140,80,30);
   N3.setForeground(Color.white);
   N3.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N3);   
   
   Label N4 =new Label("Cantidad");
   N4.setBounds(30,190,100,30);
   N4.setForeground(Color.white);
   N4.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N4);   
   
   Label N5 =new Label("Imagen");
   N5.setBounds(30,240,80,30);
   N5.setForeground(Color.white);
   N5.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N5); 
   
   NOMBREB = new JTextField();
NOMBREB.setBounds(150, 30, 175, 30);
PANELITO.add(NOMBREB);

 NOMBRE = new JTextField();
    NOMBRE.setBounds(150, 90, 175, 30);
    NOMBRE.setEditable(false);
PANELITO.add(NOMBRE);

 PRECIO = new JTextField();
    PRECIO.setBounds(150, 140, 175, 30);
    PRECIO.setEditable(false);
PANELITO.add(PRECIO);

 CANTIDAD = new JTextField();
CANTIDAD.setBounds(150, 190, 175, 30);
CANTIDAD.setEditable(false);
PANELITO.add(CANTIDAD);
  

        
JButton volver = new JButton("VOLVER");
        volver.setBounds(475, 15, 100, 25);
        PANELITO.add(volver);
        JButton consultar = new JButton("CONSULTAR");
        consultar.setBounds(425, 85, 125, 25);
        PANELITO.add(consultar);
        
        JButton modificar = new JButton("MODIFICAR");
        modificar.setBounds(425, 125, 125, 25);
        PANELITO.add(modificar);
        
        JButton eliminar = new JButton("ELIMINAR");
        eliminar.setBounds(425, 165, 125, 25);
        PANELITO.add(eliminar);
        
        JButton save = new JButton("GUARDAR");
        save.setBounds(425, 215, 125, 25);
        PANELITO.add(save);
        
        JButton Seleccionar = new JButton("Seleccionar");
    Seleccionar.setBounds(415, 300, 125, 25);
    Seleccionar.setEnabled(false);
    PANELITO.add(Seleccionar);
        
img3 = new JLabel();
img3.setBounds(150, 290, 250, 250);
PANELITO.add(img3);



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
      
      Seleccionar.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
       JFileChooser fc =new JFileChooser();
            int op=fc.showDialog(PANELITO,null);
            if(op==JFileChooser.APPROVE_OPTION){
               
                try {
                    archivo=fc.getSelectedFile();
                    IMAGENG=archivo.toString();
                    System.out.println(IMAGENG);
                    ImageIcon avar =new ImageIcon(IMAGENG);
                    
                     img3.setIcon(new ImageIcon(avar.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
                   
                    System.out.println(IMAGENG);
                    repaint();
                    
                } catch (Exception e2) {
                  e2.getStackTrace();
                }
  
            }
       }
   });
      
 consultar.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           
            String cnombre;
           cnombre=NOMBREB.getText().trim();
           if(COMPROBAR(cnombre)==true){
               
           }else{
               JOptionPane.showMessageDialog(null, "El Producto "+ cnombre +" No existe");
           }
  
                }
   });
 
 modificar.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           NOMBRE.setEditable(true);
           PRECIO.setEditable(true);
           CANTIDAD.setEditable(true);
           Seleccionar.setEnabled(true);
           
                 }
   });
 
 save.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
       String newnombre;
          
            newnombre=NOMBRE.getText();
           if (COMPROBAR_MODIFICAR(newnombre)==true) {
               NOMBRE.setText("");
               PRECIO.setText("");
               CANTIDAD.setText("");
            JOptionPane.showMessageDialog(null, "SE MODIFICÓ CORRECTAMENTE");
           } else {
                  
              
           }     
       }
   });
      eliminar.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
         String NOMBE;
           NOMBE=NOMBREB.getText();
           if (COMPROBAR_ELIMINAR(NOMBE)==true) {
               JOptionPane.showMessageDialog(null, "SE ELIMINÓ CORRECTAMENTE");
           } else {
                JOptionPane.showMessageDialog(null, "EL PRODUCTO "+NOMBE+ " NO EXISTE");
           }
       }
   });
}

public boolean COMPROBAR(String nombre){
    /*se comprueba que el nit exista*/
        boolean condicional = false;

String ruta="";

        for (int i = 0; i < contadorPro; i++) {

            if (PRODUCTOS[i].getNOMBRE().equals(nombre)) {
              //si el usuario existe
              /*Se mandan a llamar los datos en base al nit*/
              NOMBRE.setText(PRODUCTOS[i].getNOMBRE());
              PRECIO.setText(Float.toString(PRODUCTOS[i].getPRECIO()));
              CANTIDAD.setText(Integer.toString(PRODUCTOS[i].getCANTIDAD()));
              
              ruta=(PRODUCTOS[i].getIMAGEN());
              ImageIcon imagen =new ImageIcon(ruta);
            
                /*se le da un nuevo tamaño a la imagen*/
                img3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
                

                repaint();
               condicional = true;
                break;
            }else{
            condicional=false;
            }
           
        }
           
        return condicional;
    }

public boolean COMPROBAR_MODIFICAR(String nombre){
    /*se comprueba que el nit exista*/
    boolean condicional = false;
    String edad = "";
    String ruta = "";
    for (int i = 0; i < contadorPro; i++) {
        
        if (PRODUCTOS[i].getNOMBRE().equals(nombre)) {
            //si el usuario existe
            /*Se mandan a llamar los datos en base al nit*/
            PRODUCTOS[i].setPRECIO(Float.parseFloat(PRECIO.getText()));
            PRODUCTOS[i].setCANTIDAD(Integer.parseInt(CANTIDAD.getText()));
            if (NOMBRE.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Falta de llenar campos");                
            } else if (PRECIO.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Falta de llenar campos");                
            } else if (CANTIDAD.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Falta de llenar campos");                
            } else {
            if (IMAGENG.equals("")) {
                PRODUCTOS[i].setIMAGEN(PRODUCTOS[i].getIMAGEN());
            } else {
                PRODUCTOS[i].setIMAGEN(IMAGENG);
                //System.out.println("Uso la ruta nueva" + MAVATAR);
                ImageIcon imagen = new ImageIcon(IMAGENG);

                /*se le da un nuevo tamaño a la imagen*/
                img3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
                repaint();
            }
           
            }
            
            
            condicional = true;
            
        } else {
            
            int RCANTIDAD;
            float RPRECIO;
            String RNOMBRE;
            
            RNOMBRE = NOMBRE.getText();
            RCANTIDAD= Integer.parseInt(CANTIDAD.getText());
            RPRECIO = (Float.parseFloat(PRECIO.getText()));
                     
            
            if (NOMBRE.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Falta de llenar campos");                
            } else if (PRECIO.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Falta de llenar campos");                
            } else if (CANTIDAD.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Falta de llenar campos");                
            }else {
                PRODUCTOS[i].setNOMBRE(RNOMBRE);
                PRODUCTOS[i].setCANTIDAD(RCANTIDAD);
                PRODUCTOS[i].setPRECIO(RPRECIO);                
                if (IMAGENG.equals("")) {
                    PRODUCTOS[i].setIMAGEN(PRODUCTOS[i].getIMAGEN());
                    
                } else {
                    PRODUCTOS[i].setIMAGEN(IMAGENG);
                    System.out.println("Uso la ruta nueva" + IMAGENG);
                    ImageIcon imagen = new ImageIcon(IMAGENG);

                    /*se le da un nuevo tamaño a la imagen*/
                    img3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
                    repaint();
                }
                
                NOMBRE.setText("");
                PRECIO.setText("");
                CANTIDAD.setText("");
                
                //System.out.println("Se modificó el nit de un cliente cliente");                
                
            }
            
            condicional = false;
        }
        
    }
    
    return condicional;
}
public boolean COMPROBAR_ELIMINAR(String nombre){
boolean condicional = false;

        for (int i = 0; i < contadorPro; i++) {

            if (PRODUCTOS[i].getNOMBRE().equals(nombre)) {
              //si el usuario existe
              
            PRODUCTOS[i].setNOMBRE("");
            PRODUCTOS[i].setCANTIDAD(0);
            PRODUCTOS[i].setPRECIO(0);
            PRODUCTOS[i].setIMAGEN("");
            ORDENAR();       
            contadorPro--;
                System.out.println("Contador = "+ contadorPro);
                condicional = true;
                
            }else{
            condicional=false;
            }
           
        }
           
        return condicional;

}
public void ORDENAR(){
     String auxiliar;
     String auximg;
     float auxprecio;
     int auxcant;
 for (int i = 0; i < (contadorPro - 1); i++) {
            for (int j = 0; j < (contadorPro - 1); j++) {
                if (PRODUCTOS[j].getNOMBRE().equals("")) {
                    //OBTENIENDO VALORES Y GUARDANDOLOS
                    auxiliar = PRODUCTOS[j].getNOMBRE();
                    auxcant=PRODUCTOS[i].getCANTIDAD();
                    auxprecio=PRODUCTOS[i].getPRECIO();
                    auximg=PRODUCTOS[i].getIMAGEN();
                    
                    //SETEANDO LA POSICION ACTUAL EL VALOR  DE LA POSICION SIGUIENTE
                    PRODUCTOS[j].setNOMBRE(PRODUCTOS[j + 1].getNOMBRE());
                    PRODUCTOS[j].setCANTIDAD(PRODUCTOS[j + 1].getCANTIDAD());
                    PRODUCTOS[i].setPRECIO(PRODUCTOS[j + 1].getPRECIO());
                    PRODUCTOS[i].setIMAGEN(PRODUCTOS[j + 1].getIMAGEN());
                   
                   
                    //SETEANDO LA POSICION SIGUIENTE CON LA POSICION ACTUAL
                    PRODUCTOS[j + 1].setNOMBRE(auxiliar);
                    PRODUCTOS[j + 1].setCANTIDAD(auxcant);
                    PRODUCTOS[j + 1].setPRECIO(auxprecio);
                    PRODUCTOS[j + 1].setIMAGEN(auximg);
                    
                    
                  
                }
            }
        }
 
    //IMPRIMIENDO LOS DATOS YA ORDENADOS
         System.out.println(" DATOS ORDENADOS POR NOMBRE :");
        System.out.println("************************************");

        for (int i = 0; i < contadorPro; i++) {

            System.out.println(" NOMBRE: " + PRODUCTOS[i].getNOMBRE());
            System.out.println("CANTIDAD : " +PRODUCTOS[i].getCANTIDAD());
            System.out.println("PRECIO : "+PRODUCTOS[i].getPRECIO());

        }
 }
}
