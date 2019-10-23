/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olimpiadas;

/**
 *
 * @author alfon
 */
public class Complejo {
    
    private int id;
    private String localizacon;
    private String jefe;
    private String id_sede;

    public Complejo(String localizacon, String jefe, String id_sede) {
        this.localizacon = localizacon;
        this.jefe = jefe;
        this.id_sede = id_sede;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalizacon() {
        return localizacon;
    }

    public void setLocalizacon(String localizacon) {
        this.localizacon = localizacon;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    public String getId_sede() {
        return id_sede;
    }

    public void setId_sede(String id_sede) {
        this.id_sede = id_sede;
    }
    
    
}
