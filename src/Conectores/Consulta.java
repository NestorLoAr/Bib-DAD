/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectores;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author zining
 */
public class Consulta {
    
    private Conexion conex;
    private Connection conn;
    private ResultSet rs;
    
    public Consulta(){
        
        conex = new Conexion();
        
        conn = conex.getConn();
    }
    
    public ResultSet Ejecutar_consulta(String sql) {

        try {

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            return rs;

        } catch (SQLException ex) {
            rs = null;
            
            JOptionPane.showMessageDialog(null, "Error de conexión", "Error", JOptionPane.ERROR_MESSAGE);
            
            return rs;
            
            
        }
    }
    
}
