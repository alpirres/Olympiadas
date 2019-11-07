/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import basededatos.SedeDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import olimpiadas.Sede;

/**
 *
 * @author alfon
 */
public class SedeTableModel extends AbstractTableModel{
    
    private SedeDAO sedes;
    private List<Sede> datos= new ArrayList<>();
    
    public SedeTableModel(SedeDAO sedes){
        this.sedes=sedes;
    }
    
    public void updateModel(){
        datos=sedes.SelectAll();
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Id";
            case 1: return "Nombre";
            case 2: return "Presupuesto";
            default: return "[no]";
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sede s =datos.get(rowIndex);
        switch(columnIndex){
            case 0: return s.getId();
            case 1: return s.getNombre();
            case 2: return s.getPresupuesto();
            default: return "";
        }
    }
    
}
