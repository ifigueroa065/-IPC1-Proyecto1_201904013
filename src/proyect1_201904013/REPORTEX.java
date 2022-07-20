/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect1_201904013;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static proyect1_201904013.CREARCLIEN.contadorCliente;
import static proyect1_201904013.CREARPRO.contadorPro;
import static proyect1_201904013.CREARVENTA.contadorVENTA;
import static proyect1_201904013.PROYECT1_201904013.ADETALLE;
import static proyect1_201904013.PROYECT1_201904013.CLIENTES;
import static proyect1_201904013.PROYECT1_201904013.PRODUCTOS;
import static proyect1_201904013.PROYECT1_201904013.VENTA;

/**
 *
 * @author Isai Figueroa
 */
public class REPORTEX extends JFrame{
    JLabel icon1,icon2;
      JPanel PANELITO; 
     JTextField usuario,contraseña;
     
public REPORTEX (){
 /*Se declara el tamaño y titulo de la ventana nueva */
    setSize(675, 400);
    setTitle("REPORTE");
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


    Label N1 =new Label("REPORTES EN HTML");
   N1.setBounds(55,70,175,25);
   N1.setForeground(Color.white);
   N1.setFont(new Font ("Tahoma",Font.BOLD,14));
   PANELITO.add(N1);
   
    icon1=new JLabel(new ImageIcon("IMGHTML.PNG"));
icon1.setBounds(100, 115, 36, 45);
PANELITO.add(icon1);

  

Label N2 =new Label("REPORTES EN PDF");
   N2.setBounds(400,70,150,25);
   N2.setForeground(Color.white);
   N2.setFont(new Font ("Tahoma",Font.BOLD,14));
   PANELITO.add(N2);   
   
    icon1=new JLabel(new ImageIcon("IMGPDF.PNG"));
icon1.setBounds(445, 110, 45, 50);
PANELITO.add(icon1);
   
Label N3 =new Label("CLIENTES REGISTRADOS");
   N3.setBounds(20,200,150,25);
   N3.setForeground(Color.white);
   N3.setFont(new Font ("Tahoma",Font.BOLD,12));
   PANELITO.add(N3); 
   
   Label N4 =new Label("PRODUCTOS REGITRADOS");
   N4.setBounds(20,245,160,25);
   N4.setForeground(Color.white);
   N4.setFont(new Font ("Tahoma",Font.BOLD,12));
   PANELITO.add(N4); 
   
   Label N5 =new Label("VENTAS REGITRADAS");
   N5.setBounds(20,290,160,25);
   N5.setForeground(Color.white);
   N5.setFont(new Font ("Tahoma",Font.BOLD,12));
   PANELITO.add(N5); 
   
    Label N6 =new Label("FACTURA");
   N6.setBounds(335,200,160,25);
   N6.setForeground(Color.white);
   N6.setFont(new Font ("Tahoma",Font.BOLD,12));
   PANELITO.add(N6); 
   
    Label N7 =new Label("PRODUCTOS MAS VENDIDOS");
   N7.setBounds(335,245,165,25);
   N7.setForeground(Color.white);
   N7.setFont(new Font ("Tahoma",Font.BOLD,12));
   PANELITO.add(N7);
   
   Label N8 =new Label("MAYORES VENTAS");
   N8.setBounds(335,290,160,25);
   N8.setForeground(Color.white);
   N8.setFont(new Font ("Tahoma",Font.BOLD,12));
   PANELITO.add(N8);
   
        
         JButton html1 = new JButton("Generar");
        html1.setBounds(200, 200, 80, 25);
        PANELITO.add(html1);
        
        JButton html2 = new JButton("Generar");
        html2.setBounds(200, 245, 80, 25);
        PANELITO.add(html2);
        
        JButton html3 = new JButton("Generar");
        html3.setBounds(200, 290, 80, 25);
        PANELITO.add(html3);
        
        JButton PDF1 = new JButton("Generar");
        PDF1.setBounds(520, 200, 80, 25);
        PANELITO.add(PDF1);
        
         JButton PDF2 = new JButton("Generar");
        PDF2.setBounds(520, 245, 80, 25);
        PANELITO.add(PDF2);
        
          JButton PDF3 = new JButton("Generar");
        PDF3.setBounds(520, 290, 80, 25);
        PANELITO.add(PDF3);
    
    
    
    JButton volver = new JButton("VOLVER");
        volver.setBounds(540, 20, 100, 25);
        PANELITO.add(volver);
    /*creando reportes HTML*/
    /*REPORTE DE CLIENTES*/
    html1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
               String ruta="REPORTE_CLIENTES.html";
                PrintWriter writer =new PrintWriter(ruta,"UTF-8");
        writer.println("<!DOCTYPE HTML>");
        writer.println("<html>");
	writer.println("<head>");
		writer.println("<meta charset= " + " utf-8 " + " > ");
		writer.println("<title>REPORTE DE CLIENTES </title>");
		
	writer.println("</head>");

	writer.println("<body bgcolor= " + " #102030 " + "text=" + "white" + ">");

		writer.println("<h1>LOS CLIENTES REGISTRADOS SON : </h1>");
		writer.println("<div style= " + " text-align:center; " + ">");
		writer.println(" <table border= " + " 2 " + " width= " + " 50% " + " > ");
			writer.println("<thead>");
				writer.println("<tr>");
				writer.println("<th>NOMBRE</th>");
				writer.println("<th>EDAD</th>");
				writer.println("<th>SEXO</th>");
				writer.println("<th>NIT</th>");
				writer.println("</tr>");
			writer.println("</thead>");
			writer.println("<tbody>	");
            
                for (int i = 0; i < contadorCliente; i++) {
                    writer.println("<tr>");
               String nombre=CLIENTES[i].getNOMBRE();
               writer.println("<td>"+nombre+"</td>");
            int edad=CLIENTES[i].getEDAD();
            writer.println("<td>"+edad+"</td>");
            char sexo=CLIENTES[i].getSEXO();
            writer.println("<td>"+sexo+"</td>");
            int nit=CLIENTES[i].getNIT();
            writer.println("<td>"+nit+"</td>");
            writer.println("</tr>");
                }
				

			writer.println("</tbody>");
			

		writer.println("</table>");
	writer.println("</div>");
writer.println("<br>");
		writer.println("<h1>LOS CLIENTES ORDENADOS POR EDAD : </h1>");
writer.println("<div style= " + " text-align:center; " + " > ");
		writer.println(" <table border= " + "2" + " width= " + " 50% " + ">");
			writer.println("<thead>");
				writer.println("<tr>");
				writer.println("<th>NOMBRE</th>");
				writer.println("<th>EDAD</th>");
				writer.println("<th>SEXO</th>");
				writer.println("<th>NIT</th>");
				writer.println("</tr>");
			writer.println("</thead>");
		writer.println("<tbody>	");
                ORDENARCLIENTES();
                for (int i = (contadorCliente - 1); i >= 0; i--) {
                 writer.println("<tr>");
               String nombre=CLIENTES[i].getNOMBRE();
               writer.println("<td>"+nombre+"</td>");
            int edad=CLIENTES[i].getEDAD();
            writer.println("<td>"+edad+"</td>");
            char sexo=CLIENTES[i].getSEXO();
            writer.println("<td>"+sexo+"</td>");
            int nit=CLIENTES[i].getNIT();
            writer.println("<td>"+nit+"</td>");
            writer.println("</tr>");
                }
           
			

		writer.println("</table>");
	writer.println("</div>");

writer.println("<br>");
	writer.println("</body>");
	writer.println("</html>");
writer.close();
JOptionPane.showMessageDialog(null, "Se creó correctamente");
            } catch (Exception e2) {
                e2.getStackTrace();
            }
   
            
        }
    });
    
    /*REPORTE DE PRODUCTOS*/
    html2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String ruta="REPORTE_PRODUCTOS.html";
                PrintWriter writer =new PrintWriter(ruta,"UTF-8");
                
                        writer.println("<!DOCTYPE HTML>");
        writer.println("<html>");
	writer.println("<head>");
		writer.println("<meta charset= " + " utf-8 " + " > ");
		writer.println("<title>REPORTE DE CLIENTES </title>");
		
	writer.println("</head>");

	writer.println("<body bgcolor= " + " #102030 " + "text=" + "white" + ">");

		writer.println("<h1>LOS PRODUCTOS REGISTRADOS SON : </h1>");
		writer.println("<div style= " + " text-align:center; " + ">");
		writer.println(" <table border= " + " 2 " + " width= " + " 50% " + " > ");
			writer.println("<thead>");
				writer.println("<tr>");
				writer.println("<th>NOMBRE</th>");
				writer.println("<th>PRECIO</th>");
				writer.println("<th>CANTIDAD</th>");
				writer.println("</tr>");
			writer.println("</thead>");
			writer.println("<tbody>	");
            
                for (int i = 0; i < contadorPro; i++) {
                    writer.println("<tr>");
               String nombre=PRODUCTOS[i].getNOMBRE();
               writer.println("<td>"+nombre+"</td>");
               
            float precio=PRODUCTOS[i].getPRECIO();
            writer.println("<td>"+precio+"</td>");

            
            int cantidad=PRODUCTOS[i].getCANTIDAD();
            writer.println("<td>"+cantidad+"</td>");
            writer.println("</tr>");
                }
				

			
			writer.println("</tbody>");
			

		writer.println("</table>");
	writer.println("</div>");
writer.println("<br>");
		writer.println("<h1>LOS PRODUCTOS ORDENADOS POR PRECIO : </h1>");
writer.println("<div style= " + " text-align:center; " + " > ");
		writer.println(" <table border= " + "2" + " width= " + " 50% " + ">");
			writer.println("<thead>");
				writer.println("<tr>");
				writer.println("<th>NOMBRE</th>");
				writer.println("<th>PRECIO</th>");
				writer.println("<th>CANTIDAD</th>");
				
				writer.println("</tr>");
			writer.println("</thead>");
		writer.println("<tbody>	");
                ORDENARPRO();
                for (int i = (contadorCliente - 1); i >= 0; i--) {
                 writer.println("<tr>");
               String nombre=PRODUCTOS[i].getNOMBRE();
               writer.println("<td>"+nombre+"</td>");
               
            float precio=PRODUCTOS[i].getPRECIO();
            writer.println("<td>"+precio+"</td>");

            
            int cantidad=PRODUCTOS[i].getCANTIDAD();
            writer.println("<td>"+cantidad+"</td>");
            writer.println("</tr>");
                }
           
			

		writer.println("</table>");
	writer.println("</div>");

writer.println("<br>");
	writer.println("</body>");
	writer.println("</html>");
writer.close();
JOptionPane.showMessageDialog(null, "Se creó correctamente");
            } catch (Exception e3) {
            }
            
        }
    });
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
     html3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
              try {
                String ruta="REPORTE_VENTAS.html";
                PrintWriter writer =new PrintWriter(ruta,"UTF-8");
                
                        writer.println("<!DOCTYPE HTML>");
        writer.println("<html>");
	writer.println("<head>");
		writer.println("<meta charset= " + " utf-8 " + " > ");
		writer.println("<title>REPORTE DE VENTAS </title>");
		
	writer.println("</head>");

	writer.println("<body bgcolor= " + " #102030 " + "text=" + "white" + ">");

		writer.println("<h1>LAS VENTAS REGISTRADAS SON : </h1>");
		writer.println("<div style= " + " text-align:center; " + ">");
		writer.println(" <table border= " + " 2 " + " width= " + " 50% " + " > ");
			writer.println("<thead>");
				writer.println("<tr>");
				writer.println("<th>CODIGO DE VENTA</th>");
				writer.println("<th>NIT DE CLIENTE</th>");
				writer.println("<th>TOTAL</th>");
				writer.println("</tr>");
			writer.println("</thead>");
			writer.println("<tbody>	");
            
                for (int i = 0; i < contadorVENTA; i++) {
                    writer.println("<tr>");
               String CODIX=VENTA[i].getCODIXVENTA();
               writer.println("<td>"+CODIX+"</td>");
               
            int nit=VENTA[i].getNIT();
            writer.println("<td>"+nit+"</td>");

            
            float total=VENTA[i].getTOTAL();
            writer.println("<td>"+total+"</td>");
            writer.println("</tr>");
                }
				

			
			writer.println("</tbody>");
			

		writer.println("</table>");
	writer.println("</div>");
writer.println("<br>");
		writer.println("<h1>LAS VENTAS ORDENADAS POR TOTAL : </h1>");
writer.println("<div style= " + " text-align:center; " + " > ");
		writer.println(" <table border= " + "2" + " width= " + " 50% " + ">");
			writer.println("<thead>");
				writer.println("<tr>");
				writer.println("<th>CODIGO DE VENTA</th>");
				writer.println("<th>NIT DE CLIENTE</th>");
				writer.println("<th>TOTAL</th>");
				
				writer.println("</tr>");
			writer.println("</thead>");
		writer.println("<tbody>	");
                
                /*ORDENANDO LA VENTA DE MAYOR A MENOR SEGUN EL TOTAL*/
                ORDENARVENTA();
                for (int i = (contadorVENTA - 1); i >= 0; i--) {
                 writer.println("<tr>");
               String CODIX=VENTA[i].getCODIXVENTA();
               writer.println("<td>"+CODIX+"</td>");
               
            int nit=VENTA[i].getNIT();
            writer.println("<td>"+nit+"</td>");

            
            float total=VENTA[i].getTOTAL();
            writer.println("<td>"+total+"</td>");
            writer.println("</tr>");
                }
           
			

		writer.println("</table>");
	writer.println("</div>");

writer.println("<br>");
	writer.println("</body>");
	writer.println("</html>");
writer.close();
JOptionPane.showMessageDialog(null, "Se creó correctamente");
            } catch (Exception e3) {
            }
        }
    });
     
    /*GENERANDO LOS PDF*/
 PDF1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                /*CREO EL PDF*/
Document documento = new Document() {};

FileOutputStream ficheroPdf = new FileOutputStream("FACTURA DE VENTA ESPECÍFICA.pdf");

PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);

documento.open();
documento.add(new Paragraph("FACTURA",
        FontFactory.getFont("arial",   // fuente
				22,                            // tamaño
				Font.ITALIC                   // estilo

)));
documento.close();
JOptionPane.showMessageDialog(null, "Se creó correctamente");
            } catch (Exception e4) {
            }
                  }
    });
 PDF2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                  try {
                /*CREO EL PDF*/
Document documento = new Document() {};

FileOutputStream ficheroPdf = new FileOutputStream("PRODUCTOS MAS VENDIDOS.pdf");

PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);

documento.open();
documento.add(new Paragraph("10 PRODUCTOS MAS VENDIDOS",
        FontFactory.getFont("arial",   // fuente
				22,                            // tamaño
				Font.ITALIC                   // estilo

)));

documento.close();
JOptionPane.showMessageDialog(null, "Se creó correctamente");
            } catch (Exception e4) {
            }
        }
    });
 PDF3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                   try {
                /*CREO EL PDF*/
Document documento = new Document() {};

FileOutputStream ficheroPdf = new FileOutputStream("VENTAS CON MAYOR TOTAL.pdf");

PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);

documento.open();
documento.add(new Paragraph("10 VENTAS CON MAYOR TOTAL",
        FontFactory.getFont("arial",   // fuente
				22,                            // tamaño
				Font.ITALIC                   // estilo

)));

documento.close();
                       JOptionPane.showMessageDialog(null, "Se creó correctamente");
            } catch (Exception e4) {
            }
                    }
    });
    
}   

public void ORDENARCLIENTES(){
int auxedad;
String auxnombre;
int auxnit;
char auxsex;
       
        //APLICANDO EL ORDENAMIENTO BURBUJA
        for (int i = 0; i < (contadorCliente - 1); i++) {
            for (int j = 0; j < (contadorCliente - 1); j++) {
                if (CLIENTES[j].getEDAD() > CLIENTES[j + 1].getEDAD()) {
                    //OBTENIENDO VALORES Y GUARDANDOLOS
                    auxedad = CLIENTES[j].getEDAD();
                    auxnombre = CLIENTES[j].getNOMBRE();
                    auxsex = CLIENTES[j].getSEXO();
                    auxnit=CLIENTES[i].getNIT();
                    
                    //SETEANDO LA POSICION ACTUAL EL VALOR  DE LA POSICION SIGUIENTE
                    
                    CLIENTES[j].setEDAD(CLIENTES[j + 1].getEDAD());
                    CLIENTES[j].setNOMBRE(CLIENTES[j + 1].getNOMBRE());
                    CLIENTES[j].setSEXO(CLIENTES[j + 1].getSEXO());
                    CLIENTES[j].setNIT(CLIENTES[j + 1].getNIT());
                    
                    //SETEANDO LA POSICION SIGUIENTE CON LA POSICION ACTUAL
                    CLIENTES[j + 1].setEDAD(auxedad);
                    CLIENTES[j + 1].setNOMBRE(auxnombre);
                    CLIENTES[j + 1].setSEXO(auxsex);
                    CLIENTES[j + 1].setNIT(auxnit);

                }
            }
        }
}
public void ORDENARPRO(){
float auxprecio;
String auxnombre;
int auxcant;
       
        //APLICANDO EL ORDENAMIENTO BURBUJA
        for (int i = 0; i < (contadorPro - 1); i++) {
            for (int j = 0; j < (contadorCliente - 1); j++) {
                if (PRODUCTOS[j].getPRECIO()> PRODUCTOS[j + 1].getPRECIO()) {
                    //OBTENIENDO VALORES Y GUARDANDOLOS
                    auxprecio = PRODUCTOS[j].getPRECIO();
                    auxnombre = PRODUCTOS[j].getNOMBRE();
                    auxcant = PRODUCTOS[j].getCANTIDAD();
                  
                    
                    //SETEANDO LA POSICION ACTUAL EL VALOR  DE LA POSICION SIGUIENTE
                    
                    PRODUCTOS[j].setPRECIO(PRODUCTOS[j + 1].getPRECIO());
                    PRODUCTOS[j].setNOMBRE(PRODUCTOS[j + 1].getNOMBRE());
                    PRODUCTOS[j].setCANTIDAD(PRODUCTOS[j + 1].getCANTIDAD());
                    
                    
                    //SETEANDO LA POSICION SIGUIENTE CON LA POSICION ACTUAL
                    PRODUCTOS[j + 1].setPRECIO(auxprecio);
                    PRODUCTOS[j + 1].setNOMBRE(auxnombre);
                    PRODUCTOS[j + 1].setCANTIDAD(auxcant);

                }
            }
        }

}

public void ORDENARVENTA(){
float auxtotal;
String auxcodix;
int auxnit;
       
        //APLICANDO EL ORDENAMIENTO BURBUJA
        for (int i = 0; i < (contadorVENTA - 1); i++) {
            for (int j = 0; j < (contadorVENTA - 1); j++) {
                if (VENTA[j].getTOTAL()> VENTA[j + 1].getTOTAL()) {
                    //OBTENIENDO VALORES Y GUARDANDOLOS
                    auxtotal = VENTA[j].getTOTAL();
                    auxcodix = VENTA[j].getCODIXVENTA();
                    auxnit = VENTA[j].getNIT();
                  
                    
                    //SETEANDO LA POSICION ACTUAL EL VALOR  DE LA POSICION SIGUIENTE
                    
                    VENTA[j].setTOTAL(VENTA[j + 1].getTOTAL());
                    VENTA[j].setCODIXVENTA(VENTA[j + 1].getCODIXVENTA());
                    VENTA[j].setNIT(VENTA[j + 1].getNIT());
                    
                    
                    //SETEANDO LA POSICION SIGUIENTE CON LA POSICION ACTUAL
                    VENTA[j + 1].setTOTAL(auxtotal);
                    VENTA[j + 1].setCODIXVENTA(auxcodix);
                    VENTA[j + 1].setNIT(auxnit);

                }
            }
        }
}
}
