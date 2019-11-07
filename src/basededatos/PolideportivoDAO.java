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
import olimpiadas.Olimpiadas;
import olimpiadas.Polideportivo;

/**
 *
 * @author alfon
 */
public class PolideportivoDAO {
    
    public static void insert(int id, String info){
        String insertSQL;
        //Objeto de tipo Statement
        
        //comando sql generico para la inserción
        insertSQL ="INSERT INTO multisportcenter (id_sportcomplex,informtion) values (?, ?)";
        try {
            //conectamos el objeto preparedStmt a la base de datos
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt = Olimpiadas.miConexion.getConexion().prepareStatement(insertSQL);

            //creamos un nuevo socio
            preparedStmt.setInt(1, id);
            preparedStmt.setString(2, info);
            // la ejecutamos
            preparedStmt.executeUpdate();
            //obtenemos el id

            // habría que cerrar la conexion
            Olimpiadas.miConexion.cerrarConexion();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    
    public static ArrayList<Polideportivo> SelectAll (){
        ArrayList<Polideportivo> datos = new ArrayList<>();
        String select="SELECT * FROM multisportcenter";
        try {
            Olimpiadas.miConexion.conectar();
            PreparedStatement preparedStmt = Olimpiadas.miConexion.getConexion().prepareStatement(select);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                Polideportivo pd=new Polideportivo(rs.getInt("id_sportcomplex"),rs.getString("information"));
                datos.add(pd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
}
