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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alfon
 */
public class SedeDAO extends Conexion {
    
    
    
    public static void insert(String name, Float presupuesto){
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

            // habría que cerrar la conexion
            Olimpiadas.miConexion.cerrarConexion();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    
    public static ArrayList<Sede> SelectAll (){
        ArrayList<Sede> datos = new ArrayList<>();
        String select="SELECT * FROM headquarter";
        try {
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt = Olimpiadas.miConexion.getConexion().prepareStatement(select);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                Sede s=new Sede(rs.getInt("id"),rs.getString("name"),rs.getFloat("budget"));
                datos.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
}