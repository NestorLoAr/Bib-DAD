/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Vistas.*;
import javax.swing.*;
import Controlador.Tabla.IniciarTabla;


/**
 *
 * @author zining
 */
public class Controlador {

    private final Menu MENU;

    public Controlador() {

        this.MENU = new Menu();

    }

    public void Iniciar() {
        MENU.setLocationRelativeTo(null);
        this.MENU.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.MENU.setVisible(true);
        
       

        AsignandoEventos.AsignarEventos(MENU, this);

    }

    public void IniciarDlgAlumno() {

        DlgAlumnos dlgAlumno = new DlgAlumnos(MENU, true);

        JTable tabla = dlgAlumno.getTablaAlumnos();
        
        IniciarTabla.IniciaTabla(tabla, "alumnos", null);

        dlgAlumno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        dlgAlumno.setLocationRelativeTo(MENU);
        
        AsignandoEventos.AsignarEventos(dlgAlumno);

        dlgAlumno.setVisible(true);

        
    }
    
    public void IniciarDlgLibros() {

        DlgLibros dlgLibros = new DlgLibros(MENU, true);

        JTable tabla = dlgLibros.getTablaLibros();
        
        IniciarTabla.IniciaTabla(tabla, "libros", null);

        dlgLibros.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        dlgLibros.setLocationRelativeTo(MENU);
        
        AsignandoEventos.AsignarEventos(dlgLibros);

        dlgLibros.setVisible(true);

        
    }
    
    public void IniciarDlgPrestamo() {

        DlgPrestamos dlgPrestamo = new DlgPrestamos(MENU, true);

        JTable tabla = dlgPrestamo.getTablaPrestamos();
        
        IniciarTabla.IniciaTabla(tabla, "prestamos", null);

        dlgPrestamo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        dlgPrestamo.setLocationRelativeTo(MENU);
        
        AsignandoEventos.AsignarEventos(dlgPrestamo, this);

        dlgPrestamo.setVisible(true);

        
    }
    
    public void IniciarDlgFormularioPrestamo() {

        DlgFormularioPrestamo dlgFoPre = new DlgFormularioPrestamo(MENU, true);

        JTable TablaLibros = dlgFoPre.getTablaLibros();
        JTable TablaAlumnos = dlgFoPre.getTablaAlumnos();
        
        IniciarTabla.IniciaTabla(TablaLibros, "libros", null);
        IniciarTabla.IniciaTabla(TablaAlumnos, "alumnos", null);

        dlgFoPre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        dlgFoPre.setLocationRelativeTo(MENU);
        
        AsignandoEventos.AsignarEventos(dlgFoPre);

        dlgFoPre.setVisible(true);

        
    }
    
    public void IniciarDlgFormularioDevolucion() {

        DlgFormularioDevolucion dlgFoDe = new DlgFormularioDevolucion(MENU, true);

        JTable tabla = dlgFoDe.getTablaPrestamosActuales();
        
        IniciarTabla.IniciaTabla(tabla, "prestamos", "devolucion");

        dlgFoDe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        dlgFoDe.setLocationRelativeTo(MENU);
        
        AsignandoEventos.AsignarEventos(dlgFoDe);

        dlgFoDe.setVisible(true);

        
    }

}