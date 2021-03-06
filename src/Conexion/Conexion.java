/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author LN710Q
 */
public class Conexion {
    private String Usuario;
    private String contraseña;
    private String driver;
    private String url;
    
    private Connection cnx;
    
    public static Conexion instance;
    
    public synchronized static Conexion conectar(){
        if(instance == null){
            return new Conexion();
        }
        return instance;
    }
    
    private Conexion() {
        cargarCredenciales();
        
        try {
            Class.forName(this.driver);
            cnx = (Connection) DriverManager.getConnection(this.url, this.Usuario,this.contraseña);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarCredenciales() {
        Usuario = "root";
        contraseña = "";
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://127.0.0.1/SQL";
    }
    
    public Connection getCnx(){
        return cnx;
    }
    
    public void cerrarConexion(){
        instance = null;
    }


}
