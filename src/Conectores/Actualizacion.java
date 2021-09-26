/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectores;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author zining
 */
public class Actualizacion {

    private Conexion conex;
    private Connection conn;

    public Actualizacion() {

        conex = new Conexion();

        conn = conex.getConn();

    }

    public int Ejecutar_Sql_Actualizacion(String sql) {
        int i;
        try {
            Statement stmt = conn.createStatement();
            JOptionPane.showMessageDialog(null, sql);
            i = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            
            System.err.println(ex.getMessage());
            i = 0;
        }
        return i;
    }

}
