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
public class Comisario {
    
    public static ArrayList<Comisario> comisarios= new ArrayList<>();
    private int id;
    private String nombre;
    private String DNI;

    public Comisario(int id,String nombre, String DNI) {
        this.id=id;
        this.nombre = nombre;
        this.DNI = DNI;
        this.comisarios.add(this);
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
    
    
}
