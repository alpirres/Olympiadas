/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import basededatos.PolideportivoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import olimpiadas.Polideportivo;

/**
 *
 * @author alfon
 */
public class PoliTableModel extends AbstractTableModel{
    private PolideportivoDAO polideportivos;
    private List<Polideportivo> datos= new ArrayList<>();
    
    public PoliTableModel(PolideportivoDAO polideportivos){
        this.polideportivos=polideportivos;
    }
    
    public void updateModel(){
        datos=polideportivos.SelectAll();
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Id Complejo";
            case 1: return "Informacion";
            default: return "[no]";
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Polideportivo pd =datos.get(rowIndex);
        switch(columnIndex){
            case 0: return pd.getId();
            case 1: return pd.getInfo();
            default: return "";
        }
    }
    
}
