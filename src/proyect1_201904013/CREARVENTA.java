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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static proyect1_201904013.ADMINPRO.OPCIONESCOMBO;
import static proyect1_201904013.CREARCLIEN.contadorCliente;
import static proyect1_201904013.CREARPRO.contadorPro;
import static proyect1_201904013.PROYECT1_201904013.ADETALLE;
import static proyect1_201904013.PROYECT1_201904013.AUXDETALLE;
import static proyect1_201904013.PROYECT1_201904013.CLIENTES;
import static proyect1_201904013.PROYECT1_201904013.PRODUCTOS;
import static proyect1_201904013.PROYECT1_201904013.VENTA;


/**
 *
 * @author Isai Figueroa
 */
public class CREARVENTA extends JFrame{
    static int contadorDET = 0;
    static int contadorCodigo = 1;
    static int contadorVENTA = 0;
    static int contadorAgrega = 0;
    static int contadorAUXDET = 0;
    static int contadorPRODUCTOSINGRE = 0;
    JPanel PANELITO;
    JTextField NIT, CANTIDAD, CV;
    JComboBox PRODUCTO;
    static Object TABLA[][] = new Object[10][10];

    public CREARVENTA() {
        /*Se declara el tamaño y titulo de la ventana nueva */
        setSize(600, 600);
        setTitle("Crear Venta");
        setLocationRelativeTo(null);
        /*llamamos al metodo que agrega botones al panel */
        iniciar();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciar() {

        crearpanel();
        VENTANA();
    }

    private void crearpanel() {
        /*se crea el panel y se le da color*/
        this.PANELITO = new JPanel();
        this.PANELITO.setBackground(new Color(50, 50, 80));
        this.PANELITO.setLayout(null);
        this.add(PANELITO);

    }

    public void VENTANA() {
        Label N1 = new Label("Nueva Venta");
        N1.setBounds(30, 30, 150, 30);
        N1.setForeground(Color.white);
        N1.setFont(new Font("Tahoma", Font.BOLD, 18));
        PANELITO.add(N1);

        Label N2 = new Label("NIT del Cliente");
        N2.setBounds(30, 90, 115, 30);
        N2.setForeground(Color.white);
        N2.setFont(new Font("Tahoma", Font.BOLD, 16));
        PANELITO.add(N2);

        Label N3 = new Label("Agregar Producto");
        N3.setBounds(30, 140, 160, 30);
        N3.setForeground(Color.white);
        N3.setFont(new Font("Tahoma", Font.BOLD, 16));
        PANELITO.add(N3);

        Label N4 = new Label("Producto:");
        N4.setBounds(30, 190, 100, 30);
        N4.setForeground(Color.white);
        N4.setFont(new Font("Tahoma", Font.BOLD, 16));
        PANELITO.add(N4);

        Label N5 = new Label("Cantidad");
        N5.setBounds(30, 240, 80, 30);
        N5.setForeground(Color.white);
        N5.setFont(new Font("Tahoma", Font.BOLD, 16));
        PANELITO.add(N5);

        Label N6 = new Label("Ingresados en la venta");
        N6.setBounds(30, 340, 175, 25);
        N6.setForeground(Color.white);
        N6.setFont(new Font("Tahoma", Font.BOLD, 16));
        PANELITO.add(N6);

        Label N7 = new Label("Codigo de Venta");
        N7.setBounds(30, 370, 100, 30);
        N7.setForeground(Color.white);
        N7.setFont(new Font("Tahoma", Font.BOLD, 12));
        PANELITO.add(N7);

        CV = new JTextField();
        CV.setBounds(150, 370, 50, 30);
        CV.setEditable(false);
        PANELITO.add(CV);

        NIT = new JTextField();
        NIT.setBounds(170, 90, 175, 30);
        PANELITO.add(NIT);

        PRODUCTO = new JComboBox(OPCIONESCOMBO);
        PRODUCTO.setBounds(150, 190, 175, 30);
        PANELITO.add(PRODUCTO);

        CANTIDAD = new JTextField();
        CANTIDAD.setBounds(150, 240, 175, 30);
        PANELITO.add(CANTIDAD);

        JButton agregar = new JButton("AGREGAR");
        agregar.setBounds(225, 290, 100, 25);
        PANELITO.add(agregar);

        JButton guardar = new JButton("GUARDAR");
        guardar.setBounds(450, 340, 100, 25);
        PANELITO.add(guardar);

        JButton volver = new JButton("VOLVER");
        volver.setBounds(450, 20, 100, 25);
        PANELITO.add(volver);

        volver.addActionListener(new ActionListener() {
            /*PARA VOLVER AL LOGIN*/
            @Override
            public void actionPerformed(ActionEvent e) {
                NIT.setEditable(true);
                ADMINVEN volver = new ADMINVEN();
                volver.setVisible(true);
                volver.repaint();
                setVisible(false);

            }
        });
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String codigov = String.valueOf(contadorCodigo);
                NIT.setEditable(false);
                CV.setText(codigov);

                int CNIT = Integer.parseInt(NIT.getText().trim());
                float auxprecio = 0;
                int auxcantidad = 0;
                if (contadorDET < ADETALLE.length) {
                    if (COMPROBAR(CNIT) == true) {
                        if (contadorAgrega < AUXDETALLE.length) {
                            String RPRO = PRODUCTO.getSelectedItem().toString();
                            int RCANTIDAD = Integer.parseInt(CANTIDAD.getText());
                            for (int j = 0; j < contadorPro; j++) {
                                /*Recorro arreglo de productos para obtener el precio*/
                                if (PRODUCTOS[j].getNOMBRE().equals(RPRO)) {
                                    auxprecio = PRODUCTOS[j].getPRECIO();
                                    auxcantidad = PRODUCTOS[j].getCANTIDAD();
                                    if (auxcantidad <= PRODUCTOS[j].getCANTIDAD() && PRODUCTOS[j].getCANTIDAD() > 0) {
                                        PRODUCTOS[j].setCANTIDAD(auxcantidad - RCANTIDAD);
                                        ADETALLE[contadorDET] = new AGREGAR(codigov, RPRO, RCANTIDAD, auxprecio);
                                        AUXDETALLE[contadorAUXDET] = new AGREGAR(codigov, RPRO, RCANTIDAD, auxprecio);
                                        contadorDET++;
                                        contadorPRODUCTOSINGRE++;
                                        //poner limite de productos por venta
                                        contadorAUXDET++;
                                        contadorAgrega++;

                                        CREARTABLA(codigov);
                                        System.out.println("contador de agregados: " + contadorDET);
                                        for (int i = 0; i < contadorDET; i++) {
                                            System.out.println("el codigo de venta es");
                                            System.out.println(ADETALLE[i].getCODIGOVENTA());
                                        }
                                        JOptionPane.showMessageDialog(null, "SE AGREGÓ CORRECTAMENTE");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No hay en inventario la cantidad solicitada");
                                    }

                                    break;
                                } else {
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "SE ALCANZÓ EL MAXIMO DE PRODUCTOS");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "EL NIT " + CNIT + " NO EXISTE");
                        NIT.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "SE ALCANZÓ EL LIMITE DE VENTAS");
                }

            }
        });

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NIT.setEditable(true);
                int codix;
                int auxcant;
                int auxnit;
                String auxpro, codigov;
                float auxprecio = 0;
                float auxtotal = 0;
                float auxiva = 0;
                float TOTALIVA = 0;
                float TOTALPRO = 0;
                int cantdispo;
                if (contadorVENTA < VENTA.length) {
                    codigov = String.valueOf(contadorCodigo);
                    auxnit = Integer.parseInt(NIT.getText());
                    for (int i = 0; i < contadorAUXDET; i++) {
                        codix = contadorCodigo;

                        if (contadorCodigo == codix) {
                            auxpro = AUXDETALLE[i].getNOMBREPRO();
                            auxcant = AUXDETALLE[i].getCANTCOMPRADA();
                            auxprecio = AUXDETALLE[i].getPRECIOPRO();

                            /*Determinando iva y subtotal*/
                            auxiva = (float) (auxiva + ((auxprecio * auxcant * 0.12)));
                            TOTALIVA = TOTALIVA + auxiva;

                            auxtotal = (float) (auxtotal + ((auxprecio * auxcant)));
                            TOTALPRO = TOTALPRO + auxtotal;

                        } else {
                        }
                        System.out.println("*******************");
                        System.out.println("iva es =" + auxiva);
                        System.out.println("total es=" + auxtotal);
                    }
                    System.out.println("**********************************");
                    System.out.println("IVA TOTAL  ES =" + auxiva);
                    System.out.println("TOTAL ES=" + auxtotal);
                    System.out.println("el codigo de venta es " + codigov);
                    int contpro = contadorPRODUCTOSINGRE;
                    VENTA[contadorVENTA] = new VENTAS(codigov, auxnit, auxtotal, auxiva, contpro);
                    for (int i = 0; i < AUXDETALLE.length; i++) {
                        AUXDETALLE[i] = new AGREGAR("", "", 0, 0);
                    }
                    System.out.println("se  vacio el vector aux");
                    contadorCodigo++;
                    contadorVENTA++;
                    contadorAUXDET = 0;
                    contadorPRODUCTOSINGRE = 0;
                    contadorAgrega=0;
                    NIT.setText("");
                    CANTIDAD.setText("");
                    CV.setText("");
                    JOptionPane.showMessageDialog(null, "SE REGISTRÓ VENTA EXITOSA");
                } else {
                    JOptionPane.showMessageDialog(null, "SE ALCANZÓ EL LIMITE DE VENTAS");
                }

            }
        });

    }

    public boolean COMPROBAR(int cnit) {
        boolean condicional = false;

        for (int i = 0; i < contadorCliente; i++) {
            if (CLIENTES[i].getNIT() == cnit) {
                //si el usuario existe
                condicional = true;
                break;
            } else {
                condicional = false;
            }

        }

        return condicional;
    }

    public void CREARTABLA(String codigo) {

        for (int i = 0; i < contadorAUXDET; i++) {
            if (codigo.equals(AUXDETALLE[i].getCODIGOVENTA())) {
                TABLA[i][0] = AUXDETALLE[i].getNOMBREPRO();
                TABLA[i][1] = AUXDETALLE[i].getCANTCOMPRADA();
            } else {
            }

        }
        String[] columnas = {"PRODUCTO", "CANTIDAD"};
        JTable tablita = new JTable(TABLA, columnas);
        tablita.setEnabled(false);
        JScrollPane bblean = new JScrollPane(tablita);

        bblean.setBounds(50, 420, 400, 120);
        PANELITO.add(bblean);

    }

    public boolean COMPROBAR_PRODUCTO(String pro, int cantidad) {
        boolean condicional = false;
        int EPRODU;
        float precio;
        float iva;
        float total;
        for (int i = 0; i < contadorPro; i++) {
            if (PRODUCTOS[i].getNOMBRE().equals(pro)) {
                //si el usuario existe
                precio = PRODUCTOS[i].getPRECIO();
                EPRODU = PRODUCTOS[i].getCANTIDAD();
                iva = (float) (cantidad * precio * 0.12);
                total = (cantidad * precio) - iva;

                condicional = true;
                break;
            } else {
                condicional = false;
            }

        }

        return condicional;
    }

    public boolean COMPROBAR_AGREGA(String codigoventa) {
        boolean condicional = false;
        String f = String.valueOf(contadorCodigo);
        for (int i = 0; i < contadorDET; i++) {
            if (codigoventa.equals(f)) {
                //si el usuario existe
                TABLA[i][0] = ADETALLE[i].getNOMBREPRO();
                TABLA[i][1] = ADETALLE[i].getCANTCOMPRADA();

                String[] columnas = {"PRODUCTO", "CANTIDAD"};
                JTable tablita = new JTable(TABLA, columnas);
                tablita.setEnabled(false);
                JScrollPane bblean = new JScrollPane(tablita);

                bblean.setBounds(50, 390, 400, 120);
                PANELITO.add(bblean);
                condicional = true;
                break;
            } else {
                condicional = false;
            }

        }

        return condicional;
    }
}
