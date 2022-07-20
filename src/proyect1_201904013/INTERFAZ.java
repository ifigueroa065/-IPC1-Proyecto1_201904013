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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static proyect1_201904013.PROYECT1_201904013.REGISTRO;
import static proyect1_201904013.PROYECT1_201904013.USUARIOS;

/**
 *
 * @author Isai Figueroa
 */
public class INTERFAZ extends JFrame {
     JPanel PANELITO; 
     JTextField usuario,contraseña;
     JLabel icon1;
     JButton Ingresar; 
    static int contador=1;
    static String olvide="";

     
public INTERFAZ (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(700, 350);
    setTitle("LOGIN");
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
     icon1=new JLabel(new ImageIcon("USUARIO.PNG"));
icon1.setBounds(30, 30, 46, 46);
PANELITO.add(icon1);

Label N1 =new Label("LOGIN");
   N1.setBounds(90,35,150,30);
   N1.setForeground(Color.white);
   N1.setFont(new Font ("Tahoma",Font.BOLD,24));
   PANELITO.add(N1);

Label N2 =new Label("Usuario");
   N2.setBounds(30,115,100,30);
   N2.setForeground(Color.white);
   N2.setFont(new Font ("Tahoma",Font.BOLD,24));
   PANELITO.add(N2);   
   
   Label N3 =new Label("Contraseña");
   N3.setBounds(30,175,140,30);
   N3.setForeground(Color.white);
   N3.setFont(new Font ("Tahoma",Font.BOLD,24));
   PANELITO.add(N3);   
   
Ingresar =new JButton("INGRESAR");
Ingresar.setBounds(30,235,125,35);
    PANELITO.add(Ingresar);
    
    JButton registrar =new JButton("REGISTRAR");
registrar.setBounds(550,20,115,35);
    PANELITO.add(registrar);
    
     JButton olvidar =new JButton("Olvidé mi contraseña");
olvidar.setBounds(500,235,160,35);
    PANELITO.add(olvidar);
    
 
registrar.addActionListener(new DESLOGIN(this));
    
   usuario = new JTextField();
usuario.setBounds(165, 115, 175, 30);
PANELITO.add(usuario);

contraseña = new JTextField();
contraseña.setBounds(185, 175, 155, 30);
PANELITO.add(contraseña);

olvidar.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
           olvide=JOptionPane.showInputDialog("Ingrese su usuario");
             for (int i = 0; i < contador; i++) {
                 if (REGISTRO[i].getUSUARIO().equals(olvide)) {
                     JOptionPane.showMessageDialog(null,"Su contraseña es : "+ REGISTRO[i].getCONTRASEÑA());
                     break;
                 }
             }
         }
     });


Ingresar.addActionListener(new ActionListener() {
    
    @Override
    public void actionPerformed(ActionEvent e) {              
       String US="";
       String PWD="";
        US=usuario.getText();
        PWD=contraseña.getText();
        
        if( COMPROBAR(US,PWD)==true){
            
        INTPRINCI itp =new INTPRINCI();
        itp.setVisible(true);
        itp.repaint();
        setVisible(false);
        usuario.setText("");
        contraseña.setText("");
             
        }else{
       JOptionPane.showMessageDialog(null,"EL usuario y/o contraseña no existe"); 
                       usuario.setText("");
                       contraseña.setText("");
        }
       
    }

   
    
});
}


 public boolean COMPROBAR(String usuario,String Contra){
        boolean condicional = false;

        for (int i = 0; i < contador; i++) {

            if (REGISTRO[i].getUSUARIO().equals(usuario)&&REGISTRO[i].getCONTRASEÑA().equals(Contra)) {
              //si el usuario existe
                condicional = true;
                break;
            }else{
            condicional=false;
            }
           
        }
           
        return condicional;
    }
}
