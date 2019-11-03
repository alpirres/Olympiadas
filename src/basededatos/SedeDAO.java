/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import Conexion.Conexion;
import olimpiadas.Olimpiadas;
import olimpiadas.Sede;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alfon
 */
public class SedeDAO extends Conexion {
    
    
    
    public boolean insertSede(Sede s){
        boolean insert=false;
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia;

        //comando sql generico para la inserción
        lineaSQL ="INSERT INTO headquarter (name, budget) values (?, ?)";
        try {
            //conectamos el objeto preparedStmt a la base de datos
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt = Olimpiadas.miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            preparedStmt.setString(1, s.getNombre());
            preparedStmt.setFloat(2, s.getPresupuesto());
            
            // la ejecutamos
            preparedStmt.execute();
            // habría que cerrar la conexion
            Olimpiadas.miConexion.cerrarConexion();

        } catch (SQLException se) {
            se.printStackTrace();
        }
        
        return insert;
    }
    
    //pulic boolean selectSede
}