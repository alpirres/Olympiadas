/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olimpiadas;

import java.util.ArrayList;

/**
 *
 * @author alfon
 */
public class Complejo {
    
    public static ArrayList<Complejo> complejos= new ArrayList<>();
    private int id;
    private String localizacon;
    private String jefe;
    private int id_sede;

    public Complejo(int id, String localizacon, String jefe, int id_sede) {
        this.id=id;
        this.localizacon = localizacon;
        this.jefe = jefe;
        this.id_sede = id_sede;
        this.complejos.add(this);
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

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }
    
    
}
