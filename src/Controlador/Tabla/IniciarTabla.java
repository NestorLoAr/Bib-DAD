/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Tabla;

import Conectores.Consulta;
import javax.swing.*;

/**
 *
 * @author zining
 */
public class IniciarTabla {

    public static void IniciaTabla(JTable tabla, String nombreBBDD, String tipoConsulta) {

        String sql = null;

        if (tipoConsulta == null || tipoConsulta.toLowerCase().contains("todo") || tipoConsulta.toLowerCase().contains("listado")) {

            sql = "select * from " + nombreBBDD;

        } else if (tipoConsulta.toLowerCase().contains("almacén")) {

            sql = "SELECT * FROM libros.libros WHERE libros.libros.codigo NOT IN (SELECT libros.prestamos.codLibros FROM libros.prestamos);";

        } else if (tipoConsulta.toLowerCase().contains("préstamo")) {

            sql = "SELECT libros.libros.* FROM libros.prestamos INNER JOIN libros.libros ON codLibros = libros.libros.codigo;";

        } else if (tipoConsulta.toLowerCase().contains("alumnos")) {

            sql = "SELECT  libros.prestamos.id, libros.alumnos.registro, libros.alumnos.nombre, "
                    + "libros.alumnos.apellido1, libros.prestamos.codLibros FROM libros.prestamos "
                    + "INNER JOIN libros.alumnos ON libros.prestamos.codAlumno = libros.alumnos.registro;";

        } else if (tipoConsulta.toLowerCase().contains("libros")) {

            sql = "SELECT libros.prestamos.id, libros.libros.codigo, libros.libros.Titulo,"
                    + " libros.libros.Asignatura, libros.libros.estado, libros.prestamos.codAlumno"
                    + " FROM libros.prestamos INNER JOIN libros.libros ON codLibros = libros.libros.codigo;";

        } else if (tipoConsulta.toLowerCase().contains("devolucion")) {

            sql = "SELECT * FROM libros.prestamos p WHERE FechaDevolucion IS NULL;";

        }

        Consulta consulta = new Consulta();

        VistaTabla vtabla = new VistaTabla(consulta.Ejecutar_consulta(sql));

        tabla.setModel(vtabla);
    }

    public static void IniciarTabla(JTable tabla, String idPrestamo) {

        String sql;

        if (idPrestamo.equals("")) {

            sql = "SELECT * FROM libros.prestamos p WHERE FechaDevolucion IS NULL;";

        } else {

            int id = Integer.parseInt(idPrestamo);

            sql = "SELECT * FROM libros.prestamos p WHERE FechaDevolucion IS NULL AND  id = '" + id + "';";
        }

        Consulta consulta = new Consulta();

        VistaTabla vtabla = new VistaTabla(consulta.Ejecutar_consulta(sql));

        tabla.setModel(vtabla);
    }

    public static void IniciaTabla(JTable tabla, String nombreBBDD, String nombreCol, String clave) {

        String sql;

        sql = "SELECT * FROM " + nombreBBDD + " WHERE " + nombreCol + " = '" + clave + "';";

        Consulta consulta = new Consulta();

        VistaTabla vtabla = new VistaTabla(consulta.Ejecutar_consulta(sql));

        tabla.setModel(vtabla);

    }

    public static void IniciaTabla(JTable tabla, String nombreBBDD, String nombreCol, int clave) {

        String sql;

        sql = "SELECT * FROM " + nombreBBDD + " WHERE " + nombreCol + " = '" + clave + "';";

        Consulta consulta = new Consulta();

        VistaTabla vtabla = new VistaTabla(consulta.Ejecutar_consulta(sql));

        tabla.setModel(vtabla);

    }

}
