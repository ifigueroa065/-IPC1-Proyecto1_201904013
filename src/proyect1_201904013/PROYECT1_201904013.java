
package proyect1_201904013;

import java.util.Scanner;
import static proyect1_201904013.INTERFAZ.contador;
import org.jfree.chart.*;


/**
 *
 * @author Isai Figueroa
 */
public class PROYECT1_201904013 {
static Scanner entrada = new Scanner(System.in);
static Scanner datos = new Scanner(System.in);
static String USUARIOS[]=new String[3];
static USUARIO REGISTRO[] = new USUARIO[10];
static CLIENTE CLIENTES[]=new CLIENTE[100];
static PRODUCTO PRODUCTOS[]=new PRODUCTO[100];
static AGREGAR ADETALLE[]=new AGREGAR[500];
static AGREGAR AUXDETALLE[]=new AGREGAR[5];
static VENTAS VENTA[]=new VENTAS[100];

   
    public static void main(String[] args) {
         REGISTRO[0] = new USUARIO("admin","Admin","123");
       INTERFAZ Login = new INTERFAZ();
       Login.setVisible(true);
    }
    
}
