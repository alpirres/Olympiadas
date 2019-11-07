/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import basededatos.ComplejoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import olimpiadas.Complejo;

/**
 *
 * @author alfon
 */
public class ComplejoTableModel extends AbstractTableModel{
    
    private ComplejoDAO complejos;
    private List<Complejo> datos= new ArrayList<>();
    
    public ComplejoTableModel(ComplejoDAO complejos){
        this.complejos=complejos;
    }
    
    public void updateModel(){
        datos=complejos.SelectAll();
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Id";
            case 1: return "Localizacion";
            case 2: return "Jefe";
            case 3: return "ID Sede";
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
        Complejo s =datos.get(rowIndex);
        switch(columnIndex){
            case 0: return s.getId();
            case 1: return s.getLocalizacon();
            case 2: return s.getJefe();
            case 3: return s.getId_sede();
            default: return "";
        }
    }
}
