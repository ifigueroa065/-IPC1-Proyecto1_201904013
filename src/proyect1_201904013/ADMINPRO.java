/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect1_201904013;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static proyect1_201904013.CREARPRO.contadorPro;
import static proyect1_201904013.PROYECT1_201904013.PRODUCTOS;

/**
 *
 * @author Isai Figueroa
 */
public class ADMINPRO extends JFrame {
     JPanel PANELITO; 
     JTextField usuario,contraseña;
     static   String OPCIONESCOMBO[]=new String[10];
     
public ADMINPRO (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(600, 300);
    setTitle("Administración de Productos");
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
JButton dash =new JButton("Dashboard");
    dash.setBounds(100,20,215,40);
    PANELITO.add(dash);
    dash.addActionListener(new DESDASHPRO(this));

 JButton carga =new JButton("Carga masiva ");
carga.setBounds(100,75,215,40);
    PANELITO.add(carga);
    
   /*CARGA MASIVA DE PRODUCTOS*/
   carga.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("me estoy ejecutando");
 JFileChooser fc =new JFileChooser();
            int op=fc.showDialog(PANELITO,null);
            if(op==JFileChooser.APPROVE_OPTION){
                try {
                    File archivo=fc.getSelectedFile();
                    FileReader fr=new FileReader(archivo);
                    BufferedReader br=new BufferedReader(fr);
                    
                    String linea;
                    while ((linea=br.readLine())!= null) {
                       String [] datosPRO=linea.split(",");
                       
                       /*leyendo archivo*/
                       String NOMBREL=datosPRO[0];
                       float PRECIOL=Float.parseFloat(datosPRO[1]);
                       int CANTIDADL =Integer.parseInt(datosPRO[2]);
                       String IMGNL=datosPRO[3];
                       if(contadorPro<PRODUCTOS.length){
                           if (COMPROBAR(NOMBREL)==true) {
                               JOptionPane.showMessageDialog(null, "EL  PRODUCTO "+ NOMBREL+ " YA EXISTE");
                           } else {
                              
                                    OPCIONESCOMBO[contadorPro]=NOMBREL;
                        PRODUCTOS[contadorPro]=new PRODUCTO(NOMBREL, PRECIOL, CANTIDADL, IMGNL);
                        System.out.println(PRODUCTOS[contadorPro].getIMAGEN());
                       contadorPro++;   
                               
                               
                               
                           }
                       }else{
                           JOptionPane.showMessageDialog(null, "Se excedió el numero de Productos");
                       break;
                        
                       }
                    }
                    for (int i = 0; i < contadorPro; i++) {
                        System.out.println(OPCIONESCOMBO[i]); 
                    }
                    JOptionPane.showMessageDialog(null, "Se han cargado los datos de Productos correctamente");
                } catch (Exception e2) {
                  e2.getStackTrace();
                }
                
  
            }        

    }
});
    
    JButton vista =new JButton("Vista Informativa");
vista.setBounds(100,130,215,40);
    PANELITO.add(vista);
    vista.addActionListener(new DESINFOPRO(this));
   
    
    JButton crear =new JButton("Crear Producto");
 crear.setBounds(100,185,215,40);
    PANELITO.add(crear);
    crear.addActionListener(new DESCREARPRO(this));
       
    
    
    JButton volver = new JButton("VOLVER");
        volver.setBounds(425, 20, 100, 25);
        PANELITO.add(volver);
    //PARA CREAR UN USUARIO

      volver.addActionListener(new ActionListener() {      
   /*PARA VOLVER A VENTANA ANTERIOR*/
    @Override
           public void actionPerformed(ActionEvent e) {
           INTPRINCI volver= new INTPRINCI();
           volver.setVisible(true);
           volver.repaint();
           setVisible(false);
           
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

public boolean COMPROBARCANT(int cantidad){
        boolean condicional = false;

        for (int i = 0; i < contadorPro; i++) {

            if (cantidad>0) {
              //si el usuario existe
                condicional = true;
                
            }else{
            condicional=false;
            }
           
        }
           
        return condicional;
    }
}
