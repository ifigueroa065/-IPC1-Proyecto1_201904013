
package proyect1_201904013;

/**
 *
 * @author Isai Figueroa
 */
public class CLIENTE {
private String NOMBRE;    
private int EDAD;
private char SEXO;
private int NIT;
private String AVATAR;

    public CLIENTE(String NOMBRE, int EDAD, char SEXO, int NIT, String AVATAR) {
        this.NOMBRE = NOMBRE;
        this.EDAD = EDAD;
        this.SEXO = SEXO;
        this.NIT = NIT;
        this.AVATAR = AVATAR;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getEDAD() {
        return EDAD;
    }

    public void setEDAD(int EDAD) {
        this.EDAD = EDAD;
    }

    public char getSEXO() {
        return SEXO;
    }

    public void setSEXO(char SEXO) {
        this.SEXO = SEXO;
    }

    public int getNIT() {
        return NIT;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    public String getAVATAR() {
        return AVATAR;
    }

    public void setAVATAR(String AVATAR) {
        this.AVATAR = AVATAR;
    }

}
