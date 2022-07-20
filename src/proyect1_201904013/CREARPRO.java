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
import static proyect1_201904013.ADMINPRO.OPCIONESCOMBO;
import static proyect1_201904013.PROYECT1_201904013.PRODUCTOS;

/**
 *
 * @author Isai Figueroa
 */
public class CREARPRO extends JFrame {
     JPanel PANELITO; 
     JTextField NOMBRE,PRECIO,CANTIDAD;
     static int contadorPro=0;
     static String IMAGEN="";
     JLabel img2;
     
public CREARPRO (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(600, 550);
    setTitle("Crear Producto");
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
 Label N1 =new Label("Nuevo Producto");
   N1.setBounds(30,30,150,30);
   N1.setForeground(Color.white);
   N1.setFont(new Font ("Tahoma",Font.BOLD,18));
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
   
   img2=new JLabel();
                    img2.setBounds(150, 290, 225, 225);
                     PANELITO.add(img2);
   


 NOMBRE = new JTextField();
    NOMBRE.setBounds(150, 90, 175, 30);
PANELITO.add(NOMBRE);

 PRECIO = new JTextField();
    PRECIO.setBounds(150, 140, 175, 30);
PANELITO.add(PRECIO);

 CANTIDAD = new JTextField();
CANTIDAD.setBounds(150, 190, 175, 30);
PANELITO.add(CANTIDAD);


    JButton Seleccionar = new JButton("Seleccionar");
    Seleccionar.setBounds(415, 300, 125, 25);
    PANELITO.add(Seleccionar);
    
    JButton crearpro = new JButton("CREAR");
    crearpro.setBounds(415, 105, 100, 25);
    PANELITO.add(crearpro);

    JButton volver = new JButton("VOLVER");
    volver.setBounds(425, 20, 100, 25);
    PANELITO.add(volver);
    //PARA CREAR UN USUARIO

    volver.addActionListener(new ActionListener() {
        /*PARA VOLVER AL LOGIN*/
        @Override
        public void actionPerformed(ActionEvent e) {
            ADMINPRO volver = new ADMINPRO();
            volver.setVisible(true);
            volver.repaint();
            setVisible(false);

        }
    });
      
    crearpro.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
       if (contadorPro<PRODUCTOS.length) {
            
             int RCANTIDAD;
             float RPRECIO;
             String RIMAGEN,RNOMBRE;
             
             RNOMBRE=NOMBRE.getText();
             RPRECIO=Float.parseFloat(PRECIO.getText());
             RCANTIDAD=(Integer.parseInt(CANTIDAD.getText()));
             RIMAGEN=IMAGEN;
             
             
             
               if (NOMBRE.getText().equals("")) {
                     JOptionPane.showMessageDialog(null,"Falta de llenar campos");    
                 } else if(PRECIO.getText().equals("")){
                 JOptionPane.showMessageDialog(null,"Falta de llenar campos"); 
                 }
                 else if(CANTIDAD.equals("")){    
                     JOptionPane.showMessageDialog(null,"Falta de llenar campos"); 
                 }else if(IMAGEN.equals("")){
                 JOptionPane.showMessageDialog(null,"Falta de llenar campos"); 
                 }else{
                  if (COMPROBAR(NOMBRE.getText())==true) {
                 JOptionPane.showMessageDialog(null, "EL  PRODUCTO "+ NOMBRE.getText()+ " YA EXISTE");
                 NOMBRE.setText("");
             } else {
                OPCIONESCOMBO[contadorPro]=RNOMBRE;
                      PRODUCTOS[contadorPro]=new PRODUCTO(RNOMBRE, RPRECIO, RCANTIDAD, IMAGEN);
             contadorPro++;
             NOMBRE.setText("");
             PRECIO.setText("");
             CANTIDAD.setText("");
                     
             JOptionPane.showMessageDialog(null, "SE CREÓ CORRECTAMENTE");
             
             
             
             
             }
               
                 
                 
                 }
               
               
               
            
             
             
         } else {
             JOptionPane.showMessageDialog(null, "LIMITE DE USUARIOS ALCANZADO");
         }
         
         
         
     }
 });
    
Seleccionar.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
     JFileChooser fc =new JFileChooser();
            int op=fc.showDialog(PANELITO,null);
            if(op==JFileChooser.APPROVE_OPTION){
                
                try {
                    File archivo=fc.getSelectedFile();
                    IMAGEN=archivo.toString();
                    ImageIcon avar =new ImageIcon(IMAGEN);
                    
                     img2.setIcon(new ImageIcon(avar.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
                   
                    System.out.println(IMAGEN);
                    repaint();
                    
                } catch (Exception e2) {
                  e2.getStackTrace();
                }
  
            }    
     }
 });
      
      
}
 public boolean COMPROBAR(String nombre){
        boolean condicional = false;

        for (int i = 0; i < contadorPro; i++) {

            if (PRODUCTOS[i].getNOMBRE().equals(nombre)) {
              //si el usuario existe
                condicional = true;
                
            }else{
            condicional=false;
            }
           
        }
           
        return condicional;
    }
}
