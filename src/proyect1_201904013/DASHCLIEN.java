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

import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import static proyect1_201904013.CREARCLIEN.contadorCliente;
import static proyect1_201904013.PROYECT1_201904013.CLIENTES;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author Isai Figueroa
 */
public class DASHCLIEN extends JFrame {
         JPanel PANELITO; 
     JTextField usuario,contraseña;
  static  Object TABLA[][]=new Object[100][100];
     
public DASHCLIEN (){
 /*Se declara el tamaño y titulo de la ventana nueva */
     setSize(750, 450);
    setTitle("Dashboard de Clientes");
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
JButton volver = new JButton("VOLVER");
        volver.setBounds(425, 20, 100, 25);
        PANELITO.add(volver);
        
        JButton tablas = new JButton("Tablas");
        tablas.setBounds(20, 20, 100, 25);
        PANELITO.add(tablas);
        
        JButton graficas = new JButton("Grafica de Barras");
        graficas.setBounds(170, 20, 150, 25);
        PANELITO.add(graficas);
        JButton graficas2 = new JButton("Grafica Pie");
        graficas2.setBounds(170, 60, 150, 25);
        PANELITO.add(graficas2);
        
        Label N5 =new Label("CLIENTES EN EL SISTEMA");
   N5.setBounds(30,150,250,25);
   N5.setForeground(Color.white);
   N5.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N5); 
    
      volver.addActionListener(new ActionListener() {      
   /*PARA VOLVER AL ADMINISTRADOR DE CLIENTES*/
          
    @Override
           public void actionPerformed(ActionEvent e) {
           ADMINCLIEN volver= new ADMINCLIEN();
           volver.setVisible(true);
           volver.repaint();
           setVisible(false);
           
           }
       });
      
      tablas.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < contadorCliente; i++) {
            TABLA[i][0]=CLIENTES[i].getNOMBRE();
            TABLA[i][1]=CLIENTES[i].getEDAD();
            TABLA[i][2]=CLIENTES[i].getSEXO();
            TABLA[i][3]=CLIENTES[i].getNIT();
        }
    String []columnas={"NOMBRE","EDAD","SEXO","NIT"};
        JTable tablita=new JTable(TABLA, columnas);
        tablita.setEnabled(false);
        JScrollPane bblean=new JScrollPane(tablita);
   
       bblean.setBounds(70, 205, 500, 100);
        PANELITO.add(bblean);
      
    }
});
      
graficas.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int contador1=0;
        int contador2=0;
        int contador3=0;
        int contador4=0;
        System.out.println("me estoy ejecutando");
        int temp =0;
        for (int i = 0; i < contadorCliente; i++) {
            temp=CLIENTES[i].getEDAD();
            if (temp<20) {
                contador1++;
                
            } else if(temp<40){
                contador2++;
                
                 
            }else if(temp<60){
                contador3++;
            
            }else{
                contador4++;
                System.out.println("ixcamic");
            }
        }
        JFreeChart barras=null;
        DefaultCategoryDataset datos=new DefaultCategoryDataset();
        datos.addValue(contador1, "Grafica1", "0 A 20 AÑOS");
        datos.addValue(contador2, "Grafica1", "20 A 40 AÑOS");
        datos.addValue(contador3, "Grafica1", "40 A 60 AÑOS");
        datos.addValue(contador4, "Grafica1", "+60 AÑOS");
        barras=ChartFactory.createBarChart3D("CLIENTES POR EDADES", "EDAD", "#CLIENTES", datos, PlotOrientation.VERTICAL, true,true,false);
        
        
        ChartPanel pan=new ChartPanel(barras);
       
       
                
     JFrame informacion=new JFrame("GRAFICA DE BARRAS");
        informacion.getContentPane().add(pan);
        informacion.add(pan);
        informacion.pack();
        informacion.setVisible(true);
        
    }
});
graficas2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String temp;
        int contm=0;
        int contf=0;
        for (int i = 0; i < contadorCliente; i++) {
            temp=Character.toString(CLIENTES[i].getSEXO());
            if (temp.equals("M")) {
                contm++;
            } else {
                contf++;
            }
        }
         JFreeChart pastel=null;
        DefaultPieDataset pie=new DefaultPieDataset();
        pie.setValue("M", contm);
        pie.setValue("F", contf);
      
        pastel=ChartFactory.createPieChart3D("Grafica de sexo", pie, true, true, false);
        ChartPanel pan=new ChartPanel(pastel);
         JFrame informacion=new JFrame("GRAFICA DE PASTEL");
        informacion.getContentPane().add(pan);
        informacion.add(pan);
        informacion.pack();
        informacion.setVisible(true);
    }
});
}
}
