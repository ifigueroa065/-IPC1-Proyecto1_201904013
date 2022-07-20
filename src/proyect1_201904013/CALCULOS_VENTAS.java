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
public class CALCULOS_VENTAS {
private int NIT;
private String PRODUCTOS;
private int CANTIDAD;
private float TOTAL;
private float IVA;

    public CALCULOS_VENTAS(int NIT, String PRODUCTOS, int CANTIDAD, float TOTAL, float IVA) {
        this.NIT = NIT;
        this.PRODUCTOS = PRODUCTOS;
        this.CANTIDAD = CANTIDAD;
        this.TOTAL = TOTAL;
        this.IVA = IVA;
    }

    public int getNIT() {
        return NIT;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    public String getPRODUCTOS() {
        return PRODUCTOS;
    }

    public void setPRODUCTOS(String PRODUCTOS) {
        this.PRODUCTOS = PRODUCTOS;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public float getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(float TOTAL) {
        this.TOTAL = TOTAL;
    }

    public float getIVA() {
        return IVA;
    }

    public void setIVA(float IVA) {
        this.IVA = IVA;
    }

   
}
