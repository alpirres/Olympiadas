/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import olimpiadas.Olimpiadas;
import olimpiadas.Sede;

/**
 *
 * @author alfon
 */
public class UnideportivoDAO {
    
    public int insertUnideportivo(Sede s){
        int id = 0;
        String insertSQL;
        String selectSQL;
        //Objeto de tipo Statement
        Statement sentencia;

        //comando sql generico para la inserción
        insertSQL ="INSERT INTO headquarter (name, budget) values (?, ?)";
        selectSQL ="SELECT * FROM headquarter ORDER BY id DESC LIMIT 1";
        try {
            //conectamos el objeto preparedStmt a la base de datos
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt = Olimpiadas.miConexion.getConexion().prepareStatement(insertSQL);

            //creamos un nuevo socio
            preparedStmt.setString(1, s.getNombre());
            preparedStmt.setFloat(2, s.getPresupuesto());
            // la ejecutamos
            preparedStmt.execute();
            //obtenemos el id
            preparedStmt=Olimpiadas.miConexion.getConexion().prepareStatement(selectSQL);
            ResultSet rs = preparedStmt.executeQuery();
            id=rs.getInt("id");
            
            // habría que cerrar la conexion
            Olimpiadas.miConexion.cerrarConexion();

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return id;
    }
}
