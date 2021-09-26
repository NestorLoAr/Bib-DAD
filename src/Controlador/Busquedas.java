/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Tabla.IniciarTabla;
import Vistas.DlgFormularioDevolucion;
import Vistas.DlgFormularioPrestamo;
import javax.swing.*;

/**
 *
 * @author zining
 */
public class Busquedas {

    public static void Buscar(DlgFormularioPrestamo formulario, String nomBoton) {

        String txtBuscarAlumno = formulario.getTxtBuscarAlumno().getText();
        String txtBuscarLibro = formulario.getTxtBuscarLibro().getText();
        JTable TablaAlumnos = formulario.getTablaAlumnos();
        JTable Tablalibros = formulario.getTablaLibros();

        

        if (nomBoton.toLowerCase().contains("alumno")) {

            String seleccion = SeleccionBtn.Seleccion(formulario, 1);

            if (txtBuscarAlumno.equals("") || seleccion == null) {

                IniciarTabla.IniciaTabla(TablaAlumnos, "alumnos", null);

            } else if (seleccion.toLowerCase().contains("nombre")) {

                IniciarTabla.IniciaTabla(TablaAlumnos, "alumnos", "nombre", txtBuscarAlumno.toUpperCase());

            } else if (seleccion.toLowerCase().contains("dni")) {

                IniciarTabla.IniciaTabla(TablaAlumnos, "alumnos", "dni", txtBuscarAlumno.toLowerCase());
                
            } else if (seleccion.toLowerCase().contains("registro")) {
                
                int clave = Integer.parseInt(txtBuscarAlumno);

                IniciarTabla.IniciaTabla(TablaAlumnos, "alumnos", "registro", clave);
            }

        } else if (nomBoton.toLowerCase().contains("libro")) {

            String seleccion = SeleccionBtn.Seleccion(formulario, 2);
            
            if(txtBuscarLibro.equals("") || seleccion == null){
                
                IniciarTabla.IniciaTabla(Tablalibros, "libros", null);
                
            } else if(seleccion.toLowerCase().contains("título")){
                
                IniciarTabla.IniciaTabla(Tablalibros, "libros", "titulo", txtBuscarLibro);
                
            } else if(seleccion.toLowerCase().contains("asignatura")){
                
                IniciarTabla.IniciaTabla(Tablalibros, "libros", "Asignatura", txtBuscarLibro);
                
            } else if(seleccion.toLowerCase().contains("código")){
                
                int clave = Integer.parseInt(txtBuscarLibro);
                
                IniciarTabla.IniciaTabla(Tablalibros, "libros", "codigo", clave);
                
                
            }
        } else if(nomBoton.toLowerCase().contains("préstamos")){
            
            
        }

    }
    
    public static void Buscar(DlgFormularioDevolucion formulario){
        
        JTextField txtBuscar = formulario.getTxtBuscar();
        JTable tabla = formulario.getTablaPrestamosActuales();
        
        IniciarTabla.IniciarTabla(tabla, txtBuscar.getText());
        
    }

}
