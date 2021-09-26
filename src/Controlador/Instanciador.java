/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conectores.Consulta;
import Modelos.Alumno;
import Modelos.Libro;
import Controlador.Tabla.MuestraDatosTabla;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author zining
 */
public class Instanciador {

    private Libro libro = new Libro();
    private Alumno alumno = new Alumno();
    private String codLibro = "";
    private String codAlumno = "";
    private ResultSet rs;

    public Instanciador(JTable tabla, int fila) {

        libro = new Libro();
        alumno = new Alumno();

        codLibro = String.valueOf(tabla.getValueAt(fila, 0));
        codAlumno = String.valueOf(tabla.getValueAt(fila, 0));
    }

    public Instanciador(JTable tabla, String tipoTabla, int fila) {

        libro = new Libro();
        alumno = new Alumno();

        if (tipoTabla.contains("listado")) {

            codAlumno = String.valueOf(tabla.getValueAt(fila, 1));

            codLibro = String.valueOf(tabla.getValueAt(fila, 2));

        } else if (tipoTabla.contains("alumnos")) {

            codAlumno = String.valueOf(tabla.getValueAt(fila, 1));

            codLibro = String.valueOf(tabla.getValueAt(fila, 4));

        } else if (tipoTabla.contains("libros")) {

            codAlumno = String.valueOf(tabla.getValueAt(fila, 5));

            codLibro = String.valueOf(tabla.getValueAt(fila, 1));

        }

    }

    public Alumno getAlumno() {

        Consulta consulta = new Consulta();

        rs = consulta.Ejecutar_consulta("SELECT * FROM libros.alumnos WHERE registro = " + codAlumno + ";");

        try {
            while (rs.next()) {

                alumno.setRegistro(rs.getInt(1));
                alumno.setDni(rs.getString(2));
                alumno.setNombre(rs.getString(3));
                alumno.setApellido1(rs.getString(4));
                alumno.setApellido2(rs.getString(5));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MuestraDatosTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

        return alumno;
    }

    public Libro getLibro() {

        Consulta consulta = new Consulta();

        rs = consulta.Ejecutar_consulta("SELECT * FROM libros.libros WHERE codigo = " + codLibro + ";");

        try {
            while (rs.next()) {

                libro.setCodigo(rs.getInt(1));
                libro.setTitulo(rs.getString(2));
                libro.setAutor(rs.getString(3));
                libro.setEditorial(rs.getString(4));
                libro.setAsignatura(rs.getString(5));
                libro.setEstado(rs.getString(6));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MuestraDatosTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

        return libro;
    }

}
