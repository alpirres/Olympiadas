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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import olimpiadas.Olimpiadas;
import olimpiadas.Complejo;
import olimpiadas.Sede;

/**
 *
 * @author alfon
 */
public class ComplejoDAO {
    
    public static void insert(String locl, String jefe, int id_sede){
        String lineaSQL;
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
    

    public static ArrayList<Complejo> SelectAll() {
        ArrayList<Complejo> datos = new ArrayList<>();
        String select="SELECT * FROM sportcomplex";
        try {
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt = Olimpiadas.miConexion.getConexion().prepareStatement(select);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                Complejo c=new Complejo(rs.getInt("id"),rs.getString("location"),rs.getString("boss"), rs.getInt("id_headquarter"));
                datos.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
}
