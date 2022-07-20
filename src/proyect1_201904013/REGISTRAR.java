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
import javax.swing.plaf.OptionPaneUI;
import static proyect1_201904013.INTERFAZ.contador;
import static proyect1_201904013.PROYECT1_201904013.REGISTRO;
import static proyect1_201904013.PROYECT1_201904013.USUARIOS;

/**
 *
 * @author Isai Figueroa
 */
public class REGISTRAR extends JFrame {
    JLabel icon1;
    JPanel PANELITO;
    JTextField Rusuario, Rcontraseña,Rnombre,Ccontraseña;
    

    public REGISTRAR() {
        /*Se declara el tamaño y titulo de la ventana nueva */
        setSize(600, 400);
        setTitle("REGISTRAR USUARIO");
        setLocationRelativeTo(null);
        /*llamamos al metodo que agrega botones al panel */
        iniciar();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciar() {

        crearpanel();
        LOGIN();
    }

    private void crearpanel() {
        /*se crea el panel y se le da color*/
        this.PANELITO = new JPanel();
        this.PANELITO.setBackground(new Color(50, 50, 80));
        this.PANELITO.setLayout(null);
        this.add(PANELITO);

    }

    public void LOGIN() {
          icon1=new JLabel(new ImageIcon("AGREGA2.PNG"));
icon1.setBounds(35, 20, 73, 47);
PANELITO.add(icon1);

        Label N1 = new Label("REGISTRAR USUARIO");
        N1.setBounds(125, 30, 220, 30);
        N1.setForeground(Color.white);
        N1.setFont(new Font("Tahoma", Font.BOLD, 16));
        PANELITO.add(N1);

        Label N2 = new Label("Usuario");
        N2.setBounds(30, 90, 100, 30);
        N2.setForeground(Color.white);
        N2.setFont(new Font("Tahoma", Font.BOLD, 16));
        PANELITO.add(N2);

        Label N3 = new Label("Nombre");
        N3.setBounds(30, 140, 115, 30);
        N3.setForeground(Color.white);
        N3.setFont(new Font("Tahoma", Font.BOLD, 16));
        PANELITO.add(N3);

        Label N4 = new Label("Contraseña");
        N4.setBounds(30, 190, 115, 30);
        N4.setForeground(Color.white);
        N4.setFont(new Font("Tahoma", Font.BOLD, 16));
        PANELITO.add(N4);

        Label N5 = new Label("Confirmar contraseña");
        N5.setBounds(30, 240, 190, 30);
        N5.setForeground(Color.white);
        N5.setFont(new Font("Tahoma", Font.BOLD, 16));
        PANELITO.add(N5);

        JButton registrar = new JButton("REGISTRAR");
        registrar.setBounds(30, 300, 125, 35);
        PANELITO.add(registrar);

        JButton volver = new JButton("VOLVER");
        volver.setBounds(445, 20, 115, 30);
        PANELITO.add(volver);
       

        Rusuario = new JTextField();
        Rusuario.setBounds(165, 80, 200, 30);
        PANELITO.add(Rusuario);

        Rnombre = new JTextField();
        Rnombre.setBounds(165, 140, 200, 30);
        PANELITO.add(Rnombre);

        Rcontraseña = new JTextField();
        Rcontraseña.setBounds(165, 190, 200, 30);
        PANELITO.add(Rcontraseña);

        Ccontraseña = new JTextField();
        Ccontraseña.setBounds(220, 240, 175, 30);
        PANELITO.add(Ccontraseña);
        
        /*AGREGANDO ACCIONES A LOS BOTONES*/
        volver.addActionListener(new ActionListener() {      
   /*PARA VOLVER AL LOGIN*/
    @Override
           public void actionPerformed(ActionEvent e) {
           INTERFAZ volver= new INTERFAZ();
           volver.setVisible(true);
           volver.repaint();
           setVisible(false);
           
           }
       });
        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*para establecer el limite de usuarios*/
                if (contador < REGISTRO.length) {
                    
                    String USUARIO="", NOMBRE="", CONTRASEÑA="", C2 = "";
      
                    USUARIO = Rusuario.getText();
                    NOMBRE = Rnombre.getText();
                    CONTRASEÑA = Rcontraseña.getText();
                    C2=Ccontraseña.getText();
                    
                   
                      if (COMPROBAR(USUARIO)==true) {
                          //Si el usuario existe
                           JOptionPane.showMessageDialog(null,"EL usuario "+USUARIO + " ya existe"); 
                       Rusuario.setText("");
                    } else { 
                          
                         if (CONTRASEÑA.equals(C2)==false) {
                        JOptionPane.showMessageDialog(null,"las contraseñas no coinciden"); 
                        Rcontraseña.setText("");
                        Ccontraseña.setText("");
                    } else {
                             /*si no existe se registra satisfactoriamente*/
                             
                             if (Rusuario.getText().equals("")) {
                                 JOptionPane.showMessageDialog(null,"No ingresó datos"); 
                             }else{
                               REGISTRO[contador] = new USUARIO(USUARIO, NOMBRE, CONTRASEÑA);
                        contador = contador + 1;
                        
                         System.out.println("SE REGISTRO CORRECTAMENTE");
                         Rusuario.setText("");
                         Rnombre.setText("");
                         Rcontraseña.setText("");
                         Ccontraseña.setText("");
                             }
     
                      
                    }
                       
                    }          
                } else {
                    JOptionPane.showMessageDialog(null,"LIMITE DE USUARIOS ALCANZADO");
                }

            }
        });
        
        
        
        
    }
    
    public boolean COMPROBAR(String usuario){
        boolean condicional = false;

        for (int i = 0; i < contador; i++) {

            if (REGISTRO[i].getUSUARIO().equals(usuario)) {
              //si el usuario existe
                condicional = true;
                
            }else{
            condicional=false;
            }
           
        }
           
        return condicional;
    }
    
   
}
