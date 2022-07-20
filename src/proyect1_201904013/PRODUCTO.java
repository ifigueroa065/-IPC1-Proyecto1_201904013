/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect1_201904013;

/**
 *
 * @author Isai Figueroa
 */
public class PRODUCTO {
private String NOMBRE;
private float PRECIO;
private int CANTIDAD;
private String IMAGEN;

    public PRODUCTO(String NOMBRE, float PRECIO, int CANTIDAD, String IMAGEN) {
        this.NOMBRE = NOMBRE;
        this.PRECIO = PRECIO;
        this.CANTIDAD = CANTIDAD;
        this.IMAGEN = IMAGEN;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public float getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(float PRECIO) {
        this.PRECIO = PRECIO;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public String getIMAGEN() {
        return IMAGEN;
    }

    public void setIMAGEN(String IMAGEN) {
        this.IMAGEN = IMAGEN;
    }

   

}
