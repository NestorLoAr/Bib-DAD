/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Tabla;


import Controlador.Instanciador;
import Controlador.SeleccionBtn;
import javax.swing.*;

import Vistas.*;

import Modelos.*;


/**
 *
 * @author zining
 */
public class MuestraDatosTabla {

    public static void MostrarDatos(int fila, JTable TablaAlumnos, DlgAlumnos alumnos) {

        JTextField txtDni = alumnos.getTxtDni();
        JTextField txtRegistro = alumnos.getTxtRegistro();
        JTextField txtNombre = alumnos.getTxtNombre();
        JTextField txtApellido1 = alumnos.getTxtApellido1();
        JTextField txtApellido2 = alumnos.getTxtApellido2();

        txtDni.setText(String.valueOf(TablaAlumnos.getValueAt(fila, 1)));
        txtRegistro.setText(String.valueOf(TablaAlumnos.getValueAt(fila, 0)));
        txtNombre.setText(String.valueOf(TablaAlumnos.getValueAt(fila, 2)));
        txtApellido1.setText(String.valueOf(TablaAlumnos.getValueAt(fila, 3)));
        txtApellido2.setText(String.valueOf(TablaAlumnos.getValueAt(fila, 4)));

    }

    public static void MostrarDatos(int fila, JTable TablaLibros, DlgLibros libros) {

        JTextField txtCodigo = libros.getTxtCodigo();
        JTextField txtTitulo = libros.getTxtTitulo();
        JTextField txtAutor = libros.getTxtAutor();
        JTextField txtEditorial = libros.getTxtEditorial();
        JTextField txtAsignatura = libros.getTxtAsignatura();
        JTextField txtEstado = libros.getTxtEstado();

        txtCodigo.setText(String.valueOf(TablaLibros.getValueAt(fila, 0)));
        txtTitulo.setText(String.valueOf(TablaLibros.getValueAt(fila, 1)));
        txtAutor.setText(String.valueOf(TablaLibros.getValueAt(fila, 2)));
        txtEditorial.setText(String.valueOf(TablaLibros.getValueAt(fila, 3)));
        txtAsignatura.setText(String.valueOf(TablaLibros.getValueAt(fila, 4)));
        txtEstado.setText(String.valueOf(TablaLibros.getValueAt(fila, 5)));

    }

    public static void MostrarDatos(int fila, JTable TablaPrestamos, DlgPrestamos prestamo) {

        Libro libro;
        Alumno alumno;

        String tipoTabla = SeleccionBtn.Seleccion(prestamo).toLowerCase();

        Instanciador con = new Instanciador(TablaPrestamos, tipoTabla, fila);

        
        
        alumno = con.getAlumno();
        
        libro = con.getLibro();

        JTextField txtDni = prestamo.getTxtDni();
        JTextField txtRegistro = prestamo.getTxtRegistro();
        JTextField txtNombre = prestamo.getTxtNombre();
        JTextField txtApellido1 = prestamo.getTxtApellido1();
        JTextField txtApellido2 = prestamo.getTxtApellido2();
        
        txtDni.setText(String.valueOf(alumno.getDni()));
        txtRegistro.setText(String.valueOf(alumno.getRegistro()));
        txtNombre.setText(String.valueOf(alumno.getNombre()));
        txtApellido1.setText(String.valueOf(alumno.getApellido1()));
        txtApellido2.setText(String.valueOf(alumno.getApellido2()));
        
        
        JTextField txtCodigo = prestamo.getTxtCodigo();
        JTextField txtTitulo = prestamo.getTxtTitulo();
        JTextField txtAutor = prestamo.getTxtAutor();
        JTextField txtEditorial = prestamo.getTxtEditorial();
        JTextField txtAsignatura = prestamo.getTxtAsignatura();
        JTextField txtEstado = prestamo.getTxtEstado();

        txtCodigo.setText(String.valueOf(libro.getCodigo()));
        txtTitulo.setText(String.valueOf(libro.getTitulo()));
        txtAutor.setText(String.valueOf(libro.getAutor()));
        txtEditorial.setText(String.valueOf(libro.getEditorial()));
        txtAsignatura.setText(String.valueOf(libro.getAsignatura()));
        txtEstado.setText(String.valueOf(libro.getEstado()));

    }
    
    public static void MostrarDatos(int fila, JTable tabla, DlgFormularioPrestamo formulario){
        
        Instanciador con = null;
        Alumno alumno = null;
        Libro libro = null;
        JTextField txtRegistroAlumno = formulario.getTxtRegistroAlumno();
        JTextField txtCodigoLibro = formulario.getTxtCodLibro();
                
        String nombrePriCol = tabla.getColumnName(0);
        
        
        
        if(nombrePriCol.toLowerCase().equals("registro")){
            con = new Instanciador(tabla, fila);
            
            alumno = con.getAlumno();
            
            txtRegistroAlumno.setText(alumno.getRegistro() + "");
            
        }else if(nombrePriCol.toLowerCase().equals("código")){
            con = new Instanciador(tabla, fila);
            
            libro = con.getLibro();
            
            txtCodigoLibro.setText(libro.getCodigo() + "");
        }
        
    }
    
    public static void MostrarDatos(int fila, JTable tabla, DlgFormularioDevolucion formulario){
        
        
        
        JTextField txtRegistroAlumno = formulario.getTxtId();
        
                
        txtRegistroAlumno.setText(String.valueOf(tabla.getValueAt(fila, 0)));
        
    }

}
