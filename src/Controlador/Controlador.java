/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Vistas.*;
import javax.swing.*;
import Controlador.Tabla.IniciarTabla;
import java.awt.event.ActionEvent;
import net.sf.jasperreports.view.JasperViewer;
import org.jdatepicker.JDatePicker;


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
        
        JDatePicker btnFecha = dlgFoPre.getBtnFecha();
        
        btnFecha.getModel().setSelected(true);

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
        
        JDatePicker btnFecha = dlgFoDe.getBtnFecha();
        
        btnFecha.getModel().setSelected(true);

        JTable tabla = dlgFoDe.getTablaPrestamosActuales();
        
        IniciarTabla.IniciaTabla(tabla, "prestamos", "devolucion");
        
        

        dlgFoDe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        dlgFoDe.setLocationRelativeTo(MENU);
        
        AsignandoEventos.AsignarEventos(dlgFoDe);

        dlgFoDe.setVisible(true);

        
    }
    
    public void IniciarDlgInformes(){
        
        DlgInformes dlgInformes = new DlgInformes(MENU, true);
        
        dlgInformes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        AsignandoEventos.AsignarEventos(dlgInformes, this);
        dlgInformes.setVisible(true);
        
        
    }
    
    public void IniciarDlgPresentacion(ActionEvent evt){
        
        String opcion = evt.getActionCommand();
        
        JasperViewer viewer;
        
        Informes informes = new Informes();
        
        if(opcion.contains("libros")){
            
            viewer = informes.getVista(1);
            
        }else{
            
            viewer = informes.getVista(2);
            
        }
        
        
        
        DlgPresentacionInformes presentacion = new DlgPresentacionInformes(MENU, true);
        
        System.err.println(evt.getActionCommand());
        
        presentacion.add(viewer.getContentPane());
        
        presentacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        presentacion.setVisible(true);
    }

}
