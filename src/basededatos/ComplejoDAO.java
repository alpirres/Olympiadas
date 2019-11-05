/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import olimpiadas.Olimpiadas;
import olimpiadas.Complejo;

/**
 *
 * @author alfon
 */
public class ComplejoDAO {
    
    public static void insertComplejo(String locl, String jefe, int id_sede){
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia;

        //comando sql generico para la inserción
        lineaSQL ="INSERT INTO sportcomplex (location, boss, id_headquarter) values (?, ?, ?)";
        try {
            //conectamos el objeto preparedStmt a la base de datos
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt = Olimpiadas.miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            preparedStmt.setString(1, locl);
            preparedStmt.setString(2, jefe);
            preparedStmt.setInt(3, id_sede);
            
            // la ejecutamos
            preparedStmt.execute();
            // habría que cerrar la conexion
            Olimpiadas.miConexion.cerrarConexion();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
