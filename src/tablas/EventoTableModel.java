/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import basededatos.EventoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import olimpiadas.Evento;

/**
 *
 * @author alfon
 */
public class EventoTableModel extends AbstractTableModel{
    private EventoDAO eventos;
    private List<Evento> datos= new ArrayList<>();
    
    public EventoTableModel(EventoDAO eventos){
        this.eventos=eventos;
    }
    
    public void updateModel(){
        datos=eventos.SelectAll();
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Id";
            case 1: return "Nombre";
            case 2: return "Fecha";
            case 3: return "Id Complejo";
            case 4: return "Id Area";
            default: return "[no]";
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Evento e =datos.get(rowIndex);
        switch(columnIndex){
            case 0: return e.getId();
            case 1: return e.getNombre();
            case 2: return e.getFecha();
            case 3: return e.getId_complejo();
            case 4: return e.getId_area();
            default: return "";
        }
    }
}
