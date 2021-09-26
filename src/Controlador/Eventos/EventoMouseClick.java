/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Eventos;

import Controlador.Tabla.MuestraDatosTabla;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import Vistas.*;

/**
 *
 * @author zining
 */
public class EventoMouseClick {

    public static void AniadirEventoRaton(JTable Tabla, DlgAlumnos panel) {

        Tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MuestraDatosTabla.MostrarDatos(Tabla.getSelectedRow(), Tabla, panel);
            }
        });

    }

    public static void AniadirEventoRaton(JTable Tabla, DlgLibros libros) {

        Tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MuestraDatosTabla.MostrarDatos(Tabla.getSelectedRow(), Tabla, libros);
            }
        });

    }

    public static void AniadirEventoRaton(JTable Tabla, DlgPrestamos prestamos) {

        Tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MuestraDatosTabla.MostrarDatos(Tabla.getSelectedRow(), Tabla, prestamos);
            }
        });

    }
    
    public static void AniadirEventoRaton(JTable Tabla, DlgFormularioPrestamo formulario) {

        Tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                
                MuestraDatosTabla.MostrarDatos(Tabla.getSelectedRow(), Tabla, formulario);
            }
        });

    }
    
    public static void AniadirEventoRaton(JTable Tabla, DlgFormularioDevolucion formulario) {

        Tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                
                MuestraDatosTabla.MostrarDatos(Tabla.getSelectedRow(), Tabla, formulario);
            }
        });

    }

}
