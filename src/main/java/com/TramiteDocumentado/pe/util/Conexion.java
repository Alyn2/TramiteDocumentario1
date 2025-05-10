package com.TramiteDocumentado.pe.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JS02
 */
public class Conexion {

   protected java.sql.Connection connection;

    private final String base = "avance-2";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://127.0.0.1:3306/" + base;
    
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.url, this.user, this.password);

        } catch(SQLException e){
            System.err.println(e);
            System.out.println("Seconecto");
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
        return con;
    }
    
    
    
    
    /*
    
    
    
    
    private static final String URL = "jdbc:mysql://localhost:3306/avance-2";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";

    public static java.sql.Conexion getConnection() {
        try {
            return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }*/

}
