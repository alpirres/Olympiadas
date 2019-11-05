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
import olimpiadas.Comisario;

/**
 *
 * @author alfon
 */
public class ComisarioDAO {
    
    public void insertComisario(Comisario co){
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia;

        //comando sql generico para la inserción
        lineaSQL ="INSERT INTO commissioner (dni, name) values (?, ?)";
        try {
            //conectamos el objeto preparedStmt a la base de datos
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt = Olimpiadas.miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            preparedStmt.setString(1, co.getDNI());
            preparedStmt.setString(2, co.getNombre());
            
            // la ejecutamos
            preparedStmt.execute();
            // habría que cerrar la conexion
            Olimpiadas.miConexion.cerrarConexion();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
