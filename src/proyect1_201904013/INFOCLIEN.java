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
import static proyect1_201904013.CREARCLIEN.AVATAR;
import static proyect1_201904013.CREARCLIEN.contadorCliente;
import static proyect1_201904013.PROYECT1_201904013.CLIENTES;

/**
 *
 * @author Isai Figueroa
 */
public class INFOCLIEN extends JFrame {
      JPanel PANELITO; 
     JTextField NIT,NOMBRE,EDAD,SEXO,IMAGEN,NIT2;
     String MAVATAR="";
     JLabel img2;
     File archivo;
     static boolean OPCION=false;
     
public INFOCLIEN (){
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
   Label N1 =new Label("NIT");
   N1.setBounds(30,30,80,30);
   N1.setForeground(Color.white);
   N1.setFont(new Font ("Tahoma",Font.BOLD,22));
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
   
   Label N6 =new Label("AVATAR");
   N6.setBounds(30,290,80,30);
   N6.setForeground(Color.white);
   N6.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N6); 
   
   NIT = new JTextField();
NIT.setBounds(150, 30, 175, 30);
PANELITO.add(NIT);

 NOMBRE = new JTextField();
NOMBRE.setBounds(150, 90, 175, 30);
NOMBRE.setEditable(false);
PANELITO.add(NOMBRE);

 EDAD = new JTextField();
    EDAD.setBounds(150, 140, 175, 30);
    EDAD.setEditable(false);
PANELITO.add(EDAD);

 SEXO = new JTextField();
SEXO.setBounds(150, 190, 175, 30);
SEXO.setEditable(false);
PANELITO.add(SEXO);

NIT2 = new JTextField();
NIT2.setBounds(150, 240, 175, 30);
NIT2.setEditable(false);
PANELITO.add(NIT2);

/* IMAGEN = new JTextField();
IMAGEN.setBounds(150, 290, 250, 190);
IMAGEN.setEditable(false);
PANELITO.add(IMAGEN);*/
img2 = new JLabel();
img2.setBounds(150, 290, 250, 250);
PANELITO.add(img2);
  

        
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
    
    /*Seleccionar una imagen*/
    Seleccionar.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           JFileChooser fc =new JFileChooser();
            int op=fc.showDialog(PANELITO,null);
            if(op==JFileChooser.APPROVE_OPTION){
                OPCION=true;
                try {
                    archivo=fc.getSelectedFile();
                    MAVATAR=archivo.toString();
                    System.out.println(MAVATAR);
                    ImageIcon avar =new ImageIcon(MAVATAR);
                    
                     img2.setIcon(new ImageIcon(avar.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
                   
                    System.out.println(MAVATAR);
                    repaint();
                    
                } catch (Exception e2) {
                  e2.getStackTrace();
                }
  
            }
           
                 }
   });

      volver.addActionListener(new ActionListener() {      
   /*PARA VOLVER A Administracion de Clientes*/
    @Override
           public void actionPerformed(ActionEvent e) {
           ADMINCLIEN volver= new ADMINCLIEN();
           volver.setVisible(true);
           volver.repaint();
           setVisible(false);
           
           }
       });
      
      /*consultar  informacion por nit*/ 
      
      consultar.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
          int cnit;
           cnit=Integer.parseInt(NIT.getText().trim());
           if(COMPROBAR(cnit)==true){
               
           }else{
               JOptionPane.showMessageDialog(null, "El NIT : "+ cnit +" No existe");
           }
  
       }
   });
      
      /*Modificar datos*/
      modificar.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           NOMBRE.setEditable(true);
           EDAD.setEditable(true);
           SEXO.setEditable(true);
           NIT2.setEditable(true);
           Seleccionar.setEnabled(true);
            
             
       }
   });
      /*Guardar los datos*/
     save.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           int cnit;
          
            cnit=Integer.parseInt(NIT2.getText());
           if (COMPROBAR_MODIFICAR(cnit)==true) {
               NOMBRE.setText("");
               EDAD.setText("");
               SEXO.setText("");
               NIT2.setText("");
            JOptionPane.showMessageDialog(null, "SE MODIFICÓ CORRECTAMENTE");
           } else {
                  
              
           }
           
                  }
   });
     
     /*Eliminar los datos*/
     eliminar.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
      int cnit;
           cnit=Integer.parseInt(NIT.getText());
           if (COMPROBAR_ELIMINAR(cnit)==true) {
               JOptionPane.showMessageDialog(null, "SE ELIMINÓ CORRECTAMENTE");
           } else {
                JOptionPane.showMessageDialog(null, "EL NIT "+cnit+ " NO EXISTE");
           }
 
       }
   });
}

public boolean COMPROBAR(int nit){
    /*se comprueba que el nit exista*/
        boolean condicional = false;
String edad="";
String ruta="";

        for (int i = 0; i < contadorCliente; i++) {

            if (CLIENTES[i].getNIT()==nit) {
              //si el usuario existe
              /*Se mandan a llamar los datos en base al nit*/
              NOMBRE.setText(CLIENTES[i].getNOMBRE());
              EDAD.setText(Integer.toString(CLIENTES[i].getEDAD()));
              SEXO.setText(Character.toString(CLIENTES[i].getSEXO()));
              
              ruta=(CLIENTES[i].getAVATAR());
              ImageIcon imagen =new ImageIcon(ruta);
            
                /*se le da un nuevo tamaño a la imagen*/
                img2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
                

                repaint();
              
              NIT2.setText(Integer.toString(CLIENTES[i].getNIT()));
               condicional = true;
                break;
            }else{
            condicional=false;
            }
           
        }
           
        return condicional;
    }


public boolean COMPROBAR_MODIFICAR(int nit){
    /*se comprueba que el nit exista*/
    boolean condicional = false;
    String edad = "";
    String ruta = "";
    for (int i = 0; i < contadorCliente; i++) {
        
        if (CLIENTES[i].getNIT() == nit) {
            //si el usuario existe
            /*Se mandan a llamar los datos en base al nit*/
            
            CLIENTES[i].setNOMBRE(NOMBRE.getText());
            CLIENTES[i].setEDAD(Integer.parseInt(EDAD.getText()));
            CLIENTES[i].setSEXO(SEXO.getText().charAt(0));
            if (NOMBRE.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Falta de llenar campos");                
            } else if (EDAD.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Falta de llenar campos");                
            } else if (NIT2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Falta de llenar campos");                
            } else if (SEXO.equals("")) {                
                JOptionPane.showMessageDialog(null, "Falta de llenar campos");                
            } else {
            if (MAVATAR.equals("")) {
                CLIENTES[i].setAVATAR(CLIENTES[i].getAVATAR());
            } else {
                CLIENTES[i].setAVATAR(MAVATAR);
                //System.out.println("Uso la ruta nueva" + MAVATAR);
                ImageIcon imagen = new ImageIcon(MAVATAR);

                /*se le da un nuevo tamaño a la imagen*/
                img2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
                repaint();
            }
           
            }
            
            
            condicional = true;
            
        } else {
            
            int RNIT, REDAD;
            char RSEX;
            String RAVATAR, RNOMBRE;
            
            RNOMBRE = NOMBRE.getText();
            REDAD = Integer.parseInt(EDAD.getText());
            RSEX = (SEXO.getText().charAt(0));
            RNIT = Integer.parseInt(NIT2.getText());            
            
            if (NOMBRE.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Falta de llenar campos");                
            } else if (EDAD.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Falta de llenar campos");                
            } else if (NIT2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Falta de llenar campos");                
            } else if (SEXO.equals("")) {                
                JOptionPane.showMessageDialog(null, "Falta de llenar campos");                
            } else {
                CLIENTES[i].setNOMBRE(RNOMBRE);
                CLIENTES[i].setEDAD(REDAD);
                CLIENTES[i].setSEXO(RSEX);                
                CLIENTES[i].setNIT(RNIT);
                if (MAVATAR.equals("")) {
                    CLIENTES[i].setAVATAR(CLIENTES[i].getAVATAR());
                    
                } else {
                    CLIENTES[i].setAVATAR(MAVATAR);
                    System.out.println("Uso la ruta nueva" + MAVATAR);
                    ImageIcon imagen = new ImageIcon(MAVATAR);

                    /*se le da un nuevo tamaño a la imagen*/
                    img2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
                    repaint();
                }
                
                NOMBRE.setText("");
                EDAD.setText("");
                NIT.setText("");
                NIT2.setText("");
                SEXO.setText("");
                //System.out.println("Se modificó el nit de un cliente cliente");                
                
            }
            
            condicional = false;
        }
        
    }
    
    return condicional;
}

public boolean COMPROBAR_ELIMINAR(int nit){
boolean condicional = false;

        for (int i = 0; i < contadorCliente; i++) {

            if (CLIENTES[i].getNIT()==nit) {
              //si el usuario existe
              
            CLIENTES[i].setNOMBRE("");
            CLIENTES[i].setEDAD(0);
            CLIENTES[i].setSEXO(SEXO.getText().charAt(0));
            CLIENTES[i].setAVATAR("");
            ORDENAR();       
            contadorCliente--;
                System.out.println("Contador = "+ contadorCliente);
                condicional = true;
                
            }else{
            condicional=false;
            }
           
        }
           
        return condicional;

}
 public void ORDENAR(){
     String auxiliar;
     char auxsexo;
     String auxavatar;
     int auxnit;
     int auxedad;
 for (int i = 0; i < (contadorCliente - 1); i++) {
            for (int j = 0; j < (contadorCliente - 1); j++) {
                if (CLIENTES[j].getNOMBRE().equals("")) {
                    //OBTENIENDO VALORES Y GUARDANDOLOS
                    auxiliar = CLIENTES[j].getNOMBRE();
                    auxedad=CLIENTES[i].getEDAD();
                    auxsexo=CLIENTES[i].getSEXO();
                    auxnit=CLIENTES[i].getNIT();
                    auxavatar=CLIENTES[i].getAVATAR();
                    //SETEANDO LA POSICION ACTUAL EL VALOR  DE LA POSICION SIGUIENTE
                    CLIENTES[j].setNOMBRE(CLIENTES[j + 1].getNOMBRE());
                    CLIENTES[j].setEDAD(CLIENTES[j + 1].getEDAD());
                    CLIENTES[i].setSEXO(CLIENTES[j + 1].getSEXO());
                    CLIENTES[i].setNIT(CLIENTES[j + 1].getNIT());
                    CLIENTES[i].setAVATAR(CLIENTES[j + 1].getAVATAR());
                   
                    //SETEANDO LA POSICION SIGUIENTE CON LA POSICION ACTUAL
                    CLIENTES[j + 1].setNOMBRE(auxiliar);
                    CLIENTES[j + 1].setEDAD(auxedad);
                    CLIENTES[j + 1].setSEXO(auxsexo);
                    CLIENTES[j + 1].setNIT(auxnit);
                    CLIENTES[j + 1].setAVATAR(auxavatar);
                    
                    
                  
                }
            }
        }
 
    //IMPRIMIENDO LOS DATOS YA ORDENADOS
        /* System.out.println(" DATOS ORDENADOS POR NOMBRE :");
        System.out.println("************************************");

        for (int i = 0; i < contadorCliente; i++) {

            System.out.println(" NOMBRE: " + CLIENTES[i].getNOMBRE());
            System.out.println("EDAD : " +CLIENTES[i].getEDAD());
            System.out.println("NIT : "+CLIENTES[i].getNIT());

        }*/
 }
}
