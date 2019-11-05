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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alfon
 */
public class SedeDAO extends Conexion {
    
    
    
    public static void insertSede(String name, Float presupuesto){
        int id = 0 ;
        String insertSQL;
        //Objeto de tipo Statement
        
        //comando sql generico para la inserción
        insertSQL ="INSERT INTO headquarter (name, budget) values (?, ?)";
        try {
            //conectamos el objeto preparedStmt a la base de datos
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt = Olimpiadas.miConexion.getConexion().prepareStatement(insertSQL);

            //creamos un nuevo socio
            preparedStmt.setString(1, name);
            preparedStmt.setFloat(2, presupuesto);
            // la ejecutamos
            preparedStmt.executeUpdate();
            //obtenemos el id
            id=selectLastSede();
            Sede s=new Sede(id,name,presupuesto);
            // habría que cerrar la conexion
            Olimpiadas.miConexion.cerrarConexion();

        } catch (SQLException se) {
            se.printStackTrace();
        }
        System.out.println(id);
    }
    
    public static int selectLastSede(){
        int id = 0;
        String selectSQL ="SELECT * FROM headquarter ORDER BY id DESC LIMIT 1";
        try {
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt=Olimpiadas.miConexion.getConexion().prepareStatement(selectSQL);
            ResultSet rs = preparedStmt.executeQuery();
            id=rs.getInt("id"); 
            Olimpiadas.miConexion.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(id);
        return id;
    }
}