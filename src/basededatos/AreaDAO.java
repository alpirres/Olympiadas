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
import olimpiadas.Area;
import olimpiadas.Olimpiadas;

/**
 *
 * @author alfon
 */
public class AreaDAO {
    public static void insert(int id, String loc, String sport){
        String insertSQL;
        //Objeto de tipo Statement
        
        //comando sql generico para la inserción
        insertSQL ="INSERT INTO area (id_multisportcenter,location, sport) values (?, ?, ?)";
        try {
            //conectamos el objeto preparedStmt a la base de datos
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt = Olimpiadas.miConexion.getConexion().prepareStatement(insertSQL);

            //creamos un nuevo socio
            preparedStmt.setInt(1, id);
            preparedStmt.setString(2, loc);
            preparedStmt.setString(3, sport);
            // la ejecutamos
            preparedStmt.executeUpdate();
            //obtenemos el id

            // habría que cerrar la conexion
            Olimpiadas.miConexion.cerrarConexion();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    
    public static ArrayList<Area> SelectAll (){
        ArrayList<Area> datos = new ArrayList<>();
        String select="SELECT * FROM area";
        try {
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt = Olimpiadas.miConexion.getConexion().prepareStatement(select);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                Area a=new Area(rs.getInt("id"),rs.getString("location"),rs.getString("sport"),rs.getInt("id_multisportcenter"));
                datos.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
}
