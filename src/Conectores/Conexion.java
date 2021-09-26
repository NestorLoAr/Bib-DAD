/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectores;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author zining
 */
public class Conexion {

    private Connection conn;
    private ResultSet rs;

    public Conexion() {

        conn = null;
        rs = null;

    }

    public void ClaseDatos() {
        try {

            //Class.forName("com.mysql.jdbc.Driver"); esta es la otra opción para crear una conexión.
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String sUrl = "jdbc:mysql://localhost:3306/libros";
            conn = DriverManager.getConnection(sUrl, "root", "");
            JOptionPane.showMessageDialog(null, "Conectado!!!!");

        } catch (SQLException ex) {
            conn = null;
            throw new RuntimeException("Error con la conexión!!!");
        }
    }
    
    public Connection getConn(){
        try {

            //Class.forName("com.mysql.jdbc.Driver"); esta es la otra opción para crear una conexión.
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String sUrl = "jdbc:mysql://localhost:3306/libros";
            conn = DriverManager.getConnection(sUrl, "root", "");
            return conn;

        } catch (SQLException ex) {
            conn = null;
            throw new RuntimeException("Error con la conexión!!!");
        }
        
    }

}
