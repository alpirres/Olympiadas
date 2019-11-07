/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import olimpiadas.Evento;
import olimpiadas.Olimpiadas;
/**
 *
 * @author alfon
 */
public class EventoDAO {
    public static void insert(String name, Time fecha, int id_sportcomplex, int id_area){
        String insertSQL;
        //Objeto de tipo Statement
        
        //comando sql generico para la inserción
        insertSQL ="INSERT INTO event (name,date,id_sportcomplex,id_area) values (?, ?, ?, ?)";
        try {
            //conectamos el objeto preparedStmt a la base de datos
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt = Olimpiadas.miConexion.getConexion().prepareStatement(insertSQL);

            //creamos un nuevo socio
            preparedStmt.setString(1, name);
            preparedStmt.setTime(2, fecha);
            preparedStmt.setInt(3, id_sportcomplex);
            preparedStmt.setInt(4, id_sportcomplex);
            // la ejecutamos
            preparedStmt.executeUpdate();
            //obtenemos el id

            // habría que cerrar la conexion
            Olimpiadas.miConexion.cerrarConexion();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    
    public static ArrayList<Evento> SelectAll (){
        ArrayList<Evento> datos = new ArrayList<>();
        String select="SELECT * FROM event";
        try {
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt = Olimpiadas.miConexion.getConexion().prepareStatement(select);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                Evento e=new Evento(rs.getInt("id"),rs.getString("name"),rs.getTime("date"),rs.getInt("id_sportcomplex"),rs.getInt("id_area"));
                datos.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
}
