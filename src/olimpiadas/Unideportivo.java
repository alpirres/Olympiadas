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
public class Unideportivo {
    
    public static ArrayList<Unideportivo> unideps = new ArrayList<>();
    private int id;
    private String deporte;
    private String info;
    
    
    public Unideportivo(int id,String deporte, String info) {
        this.id=id;
        this.deporte = deporte;
        this.info=info;
        this.unideps.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
