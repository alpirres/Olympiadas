/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import olimpiadas.Material;
import olimpiadas.Olimpiadas;

/**
 *
 * @author alfon
 */
public class MaterialDAO {
    /*public static void insert(int id, String deporte, String info){
        String insertSQL;
        //Objeto de tipo Statement
        
        //comando sql generico para la inserción
        insertSQL ="INSERT INTO sportcenter (id_sportcomplex,sport, informtion) values (?, ?, ?)";
        try {
            //conectamos el objeto preparedStmt a la base de datos
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt = Olimpiadas.miConexion.getConexion().prepareStatement(insertSQL);

            //creamos un nuevo socio
            preparedStmt.setInt(1, id);
            preparedStmt.setString(2, deporte);
            preparedStmt.setString(3, info);
            // la ejecutamos
            preparedStmt.executeUpdate();
            //obtenemos el id

            // habría que cerrar la conexion
            Olimpiadas.miConexion.cerrarConexion();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    
    public static ArrayList<Material> SelectAll (){
        ArrayList<Material> datos = new ArrayList<>();
        String select="SELECT * FROM sportcenter";
        try {
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt = Olimpiadas.miConexion.getConexion().prepareStatement(select);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                Material m=new Material(rs.getInt("id_sportcomplex"),rs.getString("sport"),rs.getString("information"));
                datos.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }*/
}
