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
public class Sede {
    private int id;
    private String nombre;
    private Float presupuesto;
    public static ArrayList<Sede> sedes = new ArrayList<>();
    
    public Sede(int id, String nombre, Float presupuesto) {
        this.id=id;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.sedes.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Float presupuesto) {
        this.presupuesto = presupuesto;
    }
    
    
}
