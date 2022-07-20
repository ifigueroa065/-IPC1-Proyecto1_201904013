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
public class VENTAS {
private String CODIXVENTA;    
private int NIT;
private float TOTAL;
private float IVA;
private int contpro;

    public VENTAS(String CODIXVENTA, int NIT, float TOTAL, float IVA, int contpro) {
        this.CODIXVENTA = CODIXVENTA;
        this.NIT = NIT;
        this.TOTAL = TOTAL;
        this.IVA = IVA;
        this.contpro = contpro;
    }

    public String getCODIXVENTA() {
        return CODIXVENTA;
    }

    public void setCODIXVENTA(String CODIXVENTA) {
        this.CODIXVENTA = CODIXVENTA;
    }

    public int getNIT() {
        return NIT;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
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

    public int getContpro() {
        return contpro;
    }

    public void setContpro(int contpro) {
        this.contpro = contpro;
    }

 


}
