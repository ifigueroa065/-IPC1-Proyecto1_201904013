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
import static proyect1_201904013.CREARCLIEN.contadorCliente;
import static proyect1_201904013.PROYECT1_201904013.CLIENTES;

/**
 *
 * @author Isai Figueroa
 */
public class ADMINCLIEN extends JFrame{
    JPanel PANELITO; 
     JTextField usuario,contraseña;
     
public ADMINCLIEN (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(600, 300);
    setTitle("Administración de Clientes");
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
    dash.addActionListener(new DESDASHCLIEN(this));
    

 JButton carga =new JButton("Carga masiva ");
carga.setBounds(100,75,215,40);
    PANELITO.add(carga);
    //carga.addActionListener(new DCARGACLIENT(this));
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
                       String [] datos=linea.split(",");
                       String nombre=datos[0];
                       int edad=Integer.parseInt(datos[1]);
                       char sexo=datos[2].charAt(0);
                       int nit=Integer.parseInt(datos[3]);
                       String avatar=datos[4];
                       if(contadorCliente<CLIENTES.length){
                           if (COMPROBAR(nit)==true) {
                               JOptionPane.showMessageDialog(null, "EL NIT "+ nit+ " YA EXISTE");
                           } else {
                           CLIENTES[contadorCliente]=new CLIENTE(nombre, edad, sexo, nit, avatar);
                        System.out.println(CLIENTES[contadorCliente].getAVATAR());
                       contadorCliente++;     
                           }
    
                           
                        
                       }else{
                           JOptionPane.showMessageDialog(null, "Se excedió el numero de clientes");
                       break;
                        
                       }
                      
                       
                    }
                    JOptionPane.showMessageDialog(null, "Se han cargado los datos correctamente");
                } catch (Exception e2) {
                  e2.getStackTrace();
                }
                
  
            }
    }
});
    
    JButton vista =new JButton("Vista Informativa");
vista.setBounds(100,130,215,40);
    PANELITO.add(vista);
    vista.addActionListener(new DESINFOCLIEN(this));
    
    JButton crear =new JButton("Crear Cliente");
 crear.setBounds(100,185,215,40);
    PANELITO.add(crear);
   crear.addActionListener(new DCREARCLIEN(this));
    
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
