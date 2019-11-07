/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import basededatos.UnideportivoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import olimpiadas.Unideportivo;

/**
 *
 * @author alfon
 */
public class UniTableModel extends AbstractTableModel{
    private UnideportivoDAO unideportivos;
    private List<Unideportivo> datos= new ArrayList<>();
    
    public UniTableModel(UnideportivoDAO unideportivos){
        this.unideportivos=unideportivos;
    }
    
    public void updateModel(){
        datos=unideportivos.SelectAll();
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Id Complejo";
            case 1: return "Deporte";
            case 2: return "Informacion";
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
        Unideportivo ud =datos.get(rowIndex);
        switch(columnIndex){
            case 0: return ud.getId();
            case 1: return ud.getDeporte();
            case 2: return ud.getInfo();
            default: return "";
        }
    }
}
