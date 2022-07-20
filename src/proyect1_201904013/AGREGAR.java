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
public class AGREGAR {
 private String CODIGOVENTA;
    private String NOMBREPRO;
 private int CANTCOMPRADA;
 private float PRECIOPRO;

    public AGREGAR(String CODIGOVENTA, String NOMBREPRO, int CANTCOMPRADA, float PRECIOPRO) {
        this.CODIGOVENTA = CODIGOVENTA;
        this.NOMBREPRO = NOMBREPRO;
        this.CANTCOMPRADA = CANTCOMPRADA;
        this.PRECIOPRO = PRECIOPRO;
    }

    public String getCODIGOVENTA() {
        return CODIGOVENTA;
    }

    public void setCODIGOVENTA(String CODIGOVENTA) {
        this.CODIGOVENTA = CODIGOVENTA;
    }

    public String getNOMBREPRO() {
        return NOMBREPRO;
    }

    public void setNOMBREPRO(String NOMBREPRO) {
        this.NOMBREPRO = NOMBREPRO;
    }

    public int getCANTCOMPRADA() {
        return CANTCOMPRADA;
    }

    public void setCANTCOMPRADA(int CANTCOMPRADA) {
        this.CANTCOMPRADA = CANTCOMPRADA;
    }

    public float getPRECIOPRO() {
        return PRECIOPRO;
    }

    public void setPRECIOPRO(float PRECIOPRO) {
        this.PRECIOPRO = PRECIOPRO;
    }

   
 
}
