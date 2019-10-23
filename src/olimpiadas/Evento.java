/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olimpiadas;

import java.util.Date;

/**
 *
 * @author alfon
 */
public class Evento {
    
    private int id;
    private String nombre;
    private Date fecha;
    private int id_complejo;
    private int id_area;

    public Evento(String nombre, Date fecha, int id_complejo, int id_area) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.id_complejo = id_complejo;
        this.id_area = id_area;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_complejo() {
        return id_complejo;
    }

    public void setId_complejo(int id_complejo) {
        this.id_complejo = id_complejo;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }
    
    
}
