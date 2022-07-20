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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static proyect1_201904013.PROYECT1_201904013.CLIENTES;

/**
 *
 * @author Isai Figueroa
 */
public class CREARCLIEN extends JFrame{
   JPanel PANELITO; 
     JTextField NOMBRE,EDAD,NIT;
     JComboBox SEXO;
     static int contadorCliente =0;
     static String AVATAR="";
     JLabel img;
     
public CREARCLIEN (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(750, 600);
    setTitle("Crear Cliente");
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
 Label N1 =new Label("Nuevo Cliente");
   N1.setBounds(30,30,150,30);
   N1.setForeground(Color.white);
   N1.setFont(new Font ("Tahoma",Font.BOLD,18));
   PANELITO.add(N1);

Label N2 =new Label("Nombre");
   N2.setBounds(30,90,100,30);
   N2.setForeground(Color.white);
   N2.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N2);   
   
   Label N3 =new Label("Edad");
   N3.setBounds(30,140,80,30);
   N3.setForeground(Color.white);
   N3.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N3);   
   
   Label N4 =new Label("Sexo");
   N4.setBounds(30,190,100,30);
   N4.setForeground(Color.white);
   N4.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N4);   
   
   Label N5 =new Label("NIT");
   N5.setBounds(30,240,80,30);
   N5.setForeground(Color.white);
   N5.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N5); 
   
   Label N6 =new Label("Avatar");
   N6.setBounds(30,290,80,30);
   N6.setForeground(Color.white);
   N6.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N6); 
   


 NOMBRE = new JTextField();
    NOMBRE.setBounds(150, 90, 175, 30);
PANELITO.add(NOMBRE);

 EDAD = new JTextField();
    EDAD.setBounds(150, 140, 175, 30);
PANELITO.add(EDAD);

String sexito []= {"M","F"};
SEXO = new JComboBox(sexito);
SEXO.setBounds(150, 190, 175, 30);
PANELITO.add(SEXO);

 NIT = new JTextField();
NIT.setBounds(150, 240, 175, 30);
PANELITO.add(NIT);
 img=new JLabel();
                    img.setBounds(150, 290, 225, 225);
                     PANELITO.add(img);
    
    
    JButton crearcli = new JButton("CREAR");
    crearcli.setBounds(415, 105, 100, 25);
    PANELITO.add(crearcli);

    JButton Seleccionar = new JButton("Seleccionar");
    Seleccionar.setBounds(415, 300, 125, 25);
    PANELITO.add(Seleccionar);
    
    Seleccionar.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         JFileChooser fc =new JFileChooser();
            int op=fc.showDialog(PANELITO,null);
            if(op==JFileChooser.APPROVE_OPTION){
                
                try {
                    File archivo=fc.getSelectedFile();
                    AVATAR=archivo.toString();
                    ImageIcon avar =new ImageIcon(AVATAR);
                    
                     img.setIcon(new ImageIcon(avar.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
                   
                    System.out.println(AVATAR);
                    repaint();
                    
                } catch (Exception e2) {
                  e2.getStackTrace();
                }
  
            }
     }
 });
        
crearcli.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         if (contadorCliente<CLIENTES.length) {
            
             int RNIT,REDAD;
             char RSEX;
             String RAVATAR,RNOMBRE;
             
             RNOMBRE=NOMBRE.getText();
             REDAD=Integer.parseInt(EDAD.getText());
             RSEX=(SEXO.getSelectedItem().toString().charAt(0));
             RNIT=Integer.parseInt(NIT.getText());
             RAVATAR=AVATAR;
             
             
               if (NOMBRE.getText().equals("")) {
                     JOptionPane.showMessageDialog(null,"Falta de llenar campos");    
                 } else if(EDAD.getText().equals("")){
                 JOptionPane.showMessageDialog(null,"Falta de llenar campos"); 
                 }
                 else if(SEXO.getSelectedItem().equals("")){    
                     JOptionPane.showMessageDialog(null,"Falta de llenar campos"); 
                 }else if(NIT.getText().equals("")){
                 JOptionPane.showMessageDialog(null,"Falta de llenar campos"); 
                 }else if(AVATAR.equals("")){
                 JOptionPane.showMessageDialog(null,"Falta de llenar campos"); 
                 
                 }else{
                  if (COMPROBAR(RNIT)==true) {
                 JOptionPane.showMessageDialog(null, "EL NIT "+ RNIT+ " YA EXISTE");
                 NIT.setText("");
             } else {
                
                      CLIENTES[contadorCliente]=new CLIENTE(RNOMBRE, REDAD, RSEX, RNIT,RAVATAR);
             contadorCliente++;
             NOMBRE.setText("");
             EDAD.setText("");
             NIT.setText("");
             JOptionPane.showMessageDialog(null, "SE CREÓ CORRECTAMENTE");
                
             }
               
                 
                 
                 }
               
               
               
            
             
             
         } else {
             JOptionPane.showMessageDialog(null, "LIMITE DE USUARIOS ALCANZADO");
         }
     }
 });
    
JButton volver = new JButton("VOLVER");
        volver.setBounds(525, 20, 100, 25);
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
 public boolean COMPROBAR(int cnit){
        boolean condicional = false;

        for (int i = 0; i < contadorCliente; i++) {

            if (CLIENTES[i].getNIT()==cnit) {
              //si el usuario existe
                condicional = true;
                
            }else{
            condicional=false;
            }
           
        }
           
        return condicional;
    }
 

}
