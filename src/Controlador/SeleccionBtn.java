/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vistas.*;
import javax.swing.JRadioButton;

/**
 *
 * @author zining
 */
public class SeleccionBtn {

    public static String Seleccion(DlgLibros libros) {

        String seleccion = null;

        JRadioButton almacen = libros.getBtnMostrarAlmacen();
        JRadioButton prestado = libros.getBtnMostrarPrestamo();

        if (almacen.isSelected()) {

            seleccion = almacen.getActionCommand();
        }

        if (prestado.isSelected()) {

            seleccion = prestado.getActionCommand();
        }

        return seleccion;
    }

    public static String Seleccion(DlgPrestamos prestamo) {

        String seleccion = null;

        JRadioButton alumnos = prestamo.getBtnAlumnos();
        JRadioButton libros = prestamo.getBtnLibros();
        JRadioButton presta = prestamo.getBtnPrestamos();

        if (presta.isSelected()) {

            seleccion = presta.getActionCommand();
        }

        if (alumnos.isSelected()) {

            seleccion = alumnos.getActionCommand();
        }

        if (libros.isSelected()) {

            seleccion = libros.getActionCommand();
        }

        return seleccion;
    }

    public static String Seleccion(DlgFormularioPrestamo formulario, int grupoBoton) {

        String seleccion = null;

        if (grupoBoton == 1) {

            JRadioButton nombre = formulario.getBtnNombre();
            JRadioButton dni = formulario.getBtnDni();
            JRadioButton registro = formulario.getBtnRegistroAlum();

            if (nombre.isSelected()) {

                seleccion = nombre.getActionCommand();
            }

            if (dni.isSelected()) {

                seleccion = dni.getActionCommand();
            }

            if (registro.isSelected()) {

                seleccion = registro.getActionCommand();
            }
        } else if (grupoBoton == 2) {

            JRadioButton titulo = formulario.getBtnTitulo();
            JRadioButton asignatura = formulario.getBtnAsignatura();
            JRadioButton codigo = formulario.getBtnCodLibro();

            if (titulo.isSelected()) {

                seleccion = titulo.getActionCommand();
            }

            if (asignatura.isSelected()) {

                seleccion = asignatura.getActionCommand();
            }

            if (codigo.isSelected()) {

                seleccion = codigo.getActionCommand();
            }

        }

        return seleccion;
    }

   
}
