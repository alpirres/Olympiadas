/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olimpiadas;

import basededatos.Conexion;

/**
 *
 * @author alfon
 */
public class Olimpiadas {
    public static Conexion miConexion;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        miConexion = new Conexion();
        miConexion.inicializar();
        Principal gui = new Principal();
        
        if (miConexion.conectar() == false) {
            System.out.println("No se ha podido conectar a la base de datos");
        } else {
            System.out.println("Conexión satisfactoria a la base de datos");
            gui.main(args);
        }
    }
    
}
