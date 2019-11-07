/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import basededatos.AreaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import olimpiadas.Area;

/**
 *
 * @author alfon
 */
public class AreaTableModel extends AbstractTableModel{
    private AreaDAO areas;
    private List<Area> datos= new ArrayList<>();
    
    public AreaTableModel(AreaDAO areas){
        this.areas=areas;
    }
    
    public void updateModel(){
        datos=areas.SelectAll();
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Id";
            case 1: return "Id Polideportivo";
            case 2: return "Localicacion";
            case 3: return "Deporte";
            default: return "[no]";
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Area a =datos.get(rowIndex);
        switch(columnIndex){
            case 0: return a.getId();
            case 1: return a.getId_poli();
            case 2: return a.getLocalizacion();
            case 3: return a.getDeporte();
            default: return "";
        }
    }
}
