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
import org.jfree.data.general.DefaultPieDataset;
import static proyect1_201904013.CREARPRO.contadorPro;
import static proyect1_201904013.CREARVENTA.contadorDET;
import static proyect1_201904013.PROYECT1_201904013.ADETALLE;
import static proyect1_201904013.PROYECT1_201904013.PRODUCTOS;
import static proyect1_201904013.PROYECT1_201904013.VENTA;

/**
 *
 * @author Isai Figueroa
 */
public class DASHPRO extends JFrame{
       JPanel PANELITO; 
     JTextField usuario,contraseña;
     static  Object TABLA[][]=new Object[100][100];
     
public DASHPRO (){
 /*Se declara el tamaño y titulo de la ventana nueva */
     setSize(750, 450);
    setTitle("Dashboard de Productos");
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
        
        JButton grafbarras = new JButton("Grafica de Barras");
        grafbarras.setBounds(170, 20, 150, 25);
        PANELITO.add(grafbarras);
        
        JButton grafpie = new JButton("Grafica Pie");
        grafpie.setBounds(170, 60, 150, 25);
        PANELITO.add(grafpie);
        
    Label N5 =new Label("PRODUCTOS EN EL SISTEMA");
   N5.setBounds(30,150,250,25);
   N5.setForeground(Color.white);
   N5.setFont(new Font ("Tahoma",Font.BOLD,16));
   PANELITO.add(N5); 

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
      
      /*CREAR LA TABLA INFORMATIVA*/
     tablas.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < contadorPro; i++) {
            TABLA[i][0]=PRODUCTOS[i].getNOMBRE();
            TABLA[i][1]=PRODUCTOS[i].getPRECIO();
            TABLA[i][2]=PRODUCTOS[i].getCANTIDAD();
           
        }
    String []columnas={"NOMBRE","PRECIO","CANTIDAD"};
        JTable tablita=new JTable(TABLA, columnas);
        tablita.setEnabled(false);
        JScrollPane bblean=new JScrollPane(tablita);
   
      bblean.setBounds(70, 205, 500, 100);
        PANELITO.add(bblean);   

    }
});
     
     /*CREAR GRAFICA DE BARRAS*/
     grafbarras.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
         int contador1=0;
        int contador2=0;
        int contador3=0;
        int contador4=0;
        System.out.println("me estoy ejecutando");
        float temp =0;
        for (int i = 0; i < contadorPro; i++) {
            temp=PRODUCTOS[i].getPRECIO();
            if (temp<100) {
                contador1++;
                
            } else if(temp<200){
                contador2++;
                
                 
            }else if(temp<300){
                contador3++;
            
            }else{
               contador4++;
                System.out.println("ixcamic");
            }
        }
        JFreeChart barras=null;
        DefaultCategoryDataset datos=new DefaultCategoryDataset();
        datos.addValue(contador1, "Grafica1", "0 A Q100 ");
        datos.addValue(contador2, "Grafica1", "Q100 A Q200 ");
        datos.addValue(contador3, "Grafica1", "Q200 A Q300 ");
         datos.addValue(contador4, "Grafica1", "+Q300 ");
        barras=ChartFactory.createBarChart3D("PRODUCTOS  POR RANGO DE PRECIO", "PRECIO",
                "#PRODUCTOS", datos, PlotOrientation.VERTICAL, true,true,false);
        
        
        ChartPanel pan=new ChartPanel(barras);
       
       
                
     JFrame informacion=new JFrame("GRAFICA DE BARRAS");
        informacion.getContentPane().add(pan);
        informacion.add(pan);
        informacion.pack();
        informacion.setVisible(true);
        
        
            }
});
     
     /*CREAR GRAFICA DE PIE*/
     grafpie.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       String temp;
       int cantidad;
        int contm=0;
        int contf=0;
        JFreeChart pastel=null;
        DefaultPieDataset pie=new DefaultPieDataset();
        for (int i = 0; i < contadorDET; i++) {
            temp=ADETALLE[i].getNOMBREPRO();
            cantidad=ADETALLE[i].getCANTCOMPRADA();
            pie.setValue(temp, cantidad);
        }
         
      
        pastel=ChartFactory.createPieChart3D("GRAFICA DE PRODUCTOS MAS VENDIDOS", pie, true, true, false);
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
