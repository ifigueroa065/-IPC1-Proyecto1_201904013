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
public class USUARIO {
private String USUARIO;    
private String NOMBRE;
private String CONTRASEÑA;
 public USUARIO(){
 
 }
public USUARIO(String USUARIO,String NOMBRE,String CONTRASEÑA){
this.USUARIO=USUARIO;
this.NOMBRE=NOMBRE;
this.CONTRASEÑA=CONTRASEÑA;
}
    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getCONTRASEÑA() {
        return CONTRASEÑA;
    }

    public void setCONTRASEÑA(String CONTRASEÑA) {
        this.CONTRASEÑA = CONTRASEÑA;
    }
 
 
}
