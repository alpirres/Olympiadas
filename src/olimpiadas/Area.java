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
public class Area {
    
    private int id;
    private String localizacion;
    private String Deporte;
    private int id_poli;

    public Area(String localizacion, String Deporte, int id_poli) {
        this.localizacion = localizacion;
        this.Deporte = Deporte;
        this.id_poli = id_poli;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getDeporte() {
        return Deporte;
    }

    public void setDeporte(String Deporte) {
        this.Deporte = Deporte;
    }

    public int getId_poli() {
        return id_poli;
    }

    public void setId_poli(int id_poli) {
        this.id_poli = id_poli;
    }

    
    
}
