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
public class Polideportivo {
    
    private int id_complejo;
    private String info;
    public static ArrayList<Polideportivo> polis = new ArrayList<>();

    public Polideportivo(int id,String info) {
        this.id_complejo=id;
        this.info = info;
        this.polis.add(this);
    }

    public int getId() {
        return id_complejo;
    }

    public void setId(int id) {
        this.id_complejo = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
}
