/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author alfon
 */
public class Conexion {

    //Atributo que gestiona la conexión con la BBDD 
    private Connection miConexion;
    private String host; //Host que contiene la BBDD private 
    String bbdd; //Nombre de la BBDD private 
    String login; //Login private 
    String password; //Password 
    private boolean estado = false;//Estado de la conexión

    public Conexion() {
        

        try {
            File file = new File("Conextobd.xml");
            DocumentBuilder dBuilder;
            dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            if (doc.hasChildNodes()) {
                NodeList nodeList = doc
                        .getDocumentElement()
                        .getChildNodes();
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        switch (node.getNodeName()) {
                            case "host":
                                this.host = node.getTextContent();
                                break;
                            case "basededatos":
                                this.bbdd = node.getTextContent();
                                break;
                            case "usuario":
                                this.login = node.getTextContent();
                                break;
                            case "contraseña":
                                this.password = node.getTextContent();
                                break;
                        }
                    }
                }
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Método: conectar() 
        Tipo: boolean 
        Parámetros: ninguno 
        Devuelve: booleano que indica el estado de la conexión 
        Funcionalidad: Realiza la conexión a la base de datos y pone el indicador de estado a true en el caso de que la conexión se haya realizado de manera correcta 
     */
    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            // Setup the connection with the DB         
            miConexion = DriverManager.getConnection("jdbc:mysql://" + this.host + "/" + this.bbdd + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useServerPrepStmts=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=" + this.login + "&password=" + this.password);
            this.estado = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.estado;
    }

    public void inicializar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            // Setup the connection with the DB         
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=" + this.login + "&password=" + this.password);
            String s = new String();
            StringBuffer sb = new StringBuffer();
            } catch (Exception e) {
            System.out.println("*** Error : " + e.toString());
            e.printStackTrace();
        }

       /*
            FileReader fr = new FileReader(new File("olympics.sql"));
            // be sure to not have line starting with "--" or "/*" or any other non aplhabetical character

            BufferedReader br = new BufferedReader(fr);

            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            br.close();

            // here is our splitter ! We use ";" as a delimiter for each request
            // then we are sure to have well formed statements
            String[] inst = sb.toString().split(";");
            Statement st = miConexion.createStatement();

            for (int i = 0; i < inst.length; i++) {
                if (!inst[i].trim().equals("")) {
                    st.executeUpdate(inst[i]);
                }
            }
            cerrarConexion();
        } catch (Exception e) {
            System.out.println("*** Error : " + e.toString());
            e.printStackTrace();
        }
*/
    }

    /*Método: getConexion() 
    Tipo: Connection 
    Parámetros: ninguno 
    Devuelve: Connection 
    Funcionalidad: Devuelve la conexión a la base de datos para poder realizar sentencias contra la misma 
     */
    public Connection getConexion() {
        return miConexion;
    }

    /*Método: getEstado() 
    Tipo: boolean 
    Parámetros: ninguno 
    Devuelve: boolean 
    Funcionalidad: Devuelve si la conexión está establecida o no
     */
    public boolean getEstado() {
        return estado;
    }

    /*Método: cerrarConexion() 
    Tipo: boolean 
    Parámetros: ninguno 
    Devuelve: boolean 
    Funcionalidad: Devuelve true si ha cerrado la conexión a la BBDD y false en caso de que este cierre no se haya podido llevar a cabo
     */
    public void cerrarConexion() throws Exception {
        try {
            this.miConexion.close();
        } catch (Exception e) {
            throw e;
        }
    }

}
