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
import static proyect1_201904013.CREARVENTA.contadorDET;
import static proyect1_201904013.CREARVENTA.contadorVENTA;
import static proyect1_201904013.PROYECT1_201904013.ADETALLE;
import static proyect1_201904013.PROYECT1_201904013.PRODUCTOS;
import static proyect1_201904013.PROYECT1_201904013.VENTA;


/**
 *
 * @author Isai Figueroa
 */
public class ADMINVEN extends JFrame{
   JPanel PANELITO; 
     JTextField usuario,contraseña;
     
public ADMINVEN (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(600, 300);
    setTitle("Administración de Ventas");
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

 JButton carga =new JButton("Carga masiva ");
carga.setBounds(100,75,215,40);
    PANELITO.add(carga);
    
    //productos.addActionListener(new DESADMINPRO(this));
    
    JButton vista =new JButton("Vista Informativa");
vista.setBounds(100,130,215,40);
    PANELITO.add(vista);
    //ventas.addActionListener(new DESADMINVEN(this));
    
    JButton crear =new JButton("Crear Venta");
 crear.setBounds(100,185,215,40);
    PANELITO.add(crear);
   // reporte.addActionListener(new DESREPORT(this));    
    
    
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
      crear.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        CREARVENTA VDV= new CREARVENTA();
           VDV.setVisible(true);
           VDV.repaint();
           setVisible(false);
    }
});
      dash.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      DASHVENTAS VDDV= new DASHVENTAS();
           VDDV.setVisible(true);
           VDDV.repaint();
           setVisible(false);   
        
    }
});
      
    vista.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
         INFOVENTA VDVI= new INFOVENTA();
           VDVI.setVisible(true);
           VDVI.repaint();
           setVisible(false);   
        
          }
});
      
     carga.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("me estoy ejecutando");
      float auxprecio=0;
      int auxinventario=0;
 JFileChooser fc =new JFileChooser();
            int op=fc.showDialog(PANELITO,null);
            if(op==JFileChooser.APPROVE_OPTION){
                try {
                    File archivo=fc.getSelectedFile();
                    FileReader fr=new FileReader(archivo);
                    BufferedReader br=new BufferedReader(fr);
                    
                    String linea;
                    /*Empiezo a leer el archivo de ventas*/
                    while ((linea=br.readLine())!= null) {
                       String [] datosVEN=linea.split(",");
                       
                       String CODIGOVENTA=datosVEN[0];
                       int NITCLIENTE=Integer.parseInt(datosVEN[1]);
                       String NOMBREPRO=datosVEN[2];
                       int CANTCOMPRADA=Integer.parseInt(datosVEN[3]);
                      /*PARA REALIZAR CALCULOS*/
                       float auxiva=0;
                       float auxtotal=0;
                        
                       if(contadorDET<ADETALLE.length){
                            
                                System.out.println("el contador de ventas es= "+ contadorDET);
                            for (int i = 0; i < contadorPro; i++) {
                            if (PRODUCTOS[i].getNOMBRE().equals(NOMBREPRO)) {
                            auxprecio=PRODUCTOS[i].getPRECIO();
                            auxinventario=PRODUCTOS[i].getCANTIDAD();
                            if (CANTCOMPRADA<=PRODUCTOS[i].getCANTIDAD()&&PRODUCTOS[i].getCANTIDAD()>0) {
                                VENTA[contadorDET].setNIT(NITCLIENTE);
                                ADETALLE[contadorDET] = new AGREGAR(CODIGOVENTA, NOMBREPRO, CANTCOMPRADA, auxprecio);
                                contadorDET++;
                                System.out.println("el contador de ventas es= "+ contadorDET);
                            }else{
                            JOptionPane.showMessageDialog(null, "No hay en inventario la cantidad solicitada");
                            }
                            break;
                            } else {}
                            }
                          
                     
                       }else{
                           JOptionPane.showMessageDialog(null, "Se excedió el numero de detalles");
                       break;}
                      
                       
                    }/*Terminé de leer el archivo y guardar datos*/
                    
                    /*Empiezo a generar ventas*/
                    if (contadorVENTA<VENTA.length) {
                         
                        for (int i = 0; i < contadorDET; i++) {
                            
                        }
   
                        
                        
                    } else {
                         JOptionPane.showMessageDialog(null, "Se excedió el numero de Ventas");
                    }
                    
                    
                    
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Se han cargado las ventas correctamente");
                } catch (Exception e2) {
                  e2.getStackTrace();
                }
                
  
            } 
        
    }
});
        
        
}   


}
