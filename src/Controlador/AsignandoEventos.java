/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Eventos.EventoBtnAltas;
import Controlador.Eventos.EventoBtnModificar;
import Controlador.Eventos.EventoBtnBuscar;
import Controlador.Eventos.EventoBtnBajas;
import Controlador.Eventos.EventoRadioBtnLibros;
import Controlador.Eventos.EventoRadioBtnPrestamos;
import Controlador.Eventos.EventoBtnActualizar;
import Controlador.Eventos.EventoBtnIniciarDlg;
import Controlador.Eventos.EventoMouseClick;
import Controlador.Eventos.EventoBtnSalir;
import Controlador.Eventos.EventoBtnAceptar;
import Vistas.*;
import javax.swing.*;

/**
 *
 * @author zining
 */
public class AsignandoEventos {

    public static void AsignarEventos(DlgAlumnos alumnos) {

        JButton btnSalir = alumnos.getBtnSalir();
        JButton btnBajas = alumnos.getBtnBajas();
        JButton btnModificaciones = alumnos.getBtnModificaciones();
        JButton btnAltas = alumnos.getBtnAltas();
        JTable tablaAlumnos = alumnos.getTablaAlumnos();

        EventoBtnSalir.AniadirBotonDispose(btnSalir, alumnos);
        EventoBtnAltas.AniadirBotonAltas(btnAltas, alumnos, tablaAlumnos);
        EventoBtnBajas.AniadirBotonBajas(btnBajas, alumnos, tablaAlumnos);
        EventoBtnModificar.AniadirBotonModificar(btnModificaciones, alumnos, tablaAlumnos);
        EventoMouseClick.AniadirEventoRaton(tablaAlumnos, alumnos);

    }

    public static void AsignarEventos(Menu menu, Controlador controlador) {

        JButton btnSalir = menu.getBtnSalir();
        JButton btnAlumnos = menu.getBtnAlumnos();
        JButton btnLibro = menu.getBtnLibros();
        JButton btnPrestamos = menu.getBtnPrestamos();

        EventoBtnSalir.AniadirBotonSalir(btnSalir);
        
        EventoBtnIniciarDlg.AniadirBotonDlgPrestamos(btnPrestamos, controlador);
        EventoBtnIniciarDlg.AniadirBotonDlgAlumnos(btnAlumnos, controlador);
        EventoBtnIniciarDlg.AniadirBotonDlgLibros(btnLibro, controlador);
        

    }

    public static void AsignarEventos(DlgLibros libros) {

        JTable tablaLibros = libros.getTablaLibros();
        JButton btnSalir = libros.getBtnSalir();
        JRadioButton todo = libros.getBtnMostrarTodo();
        JRadioButton almacen = libros.getBtnMostrarAlmacen();
        JRadioButton prestamo = libros.getBtnMostrarPrestamo();
        JButton btnAniadir = libros.getBtnAniadir();
        JButton btnModificar = libros.getBtnModificar();
        JButton btnEliminar = libros.getBtnEliminar();
        JButton btnActualizarEstado = libros.getBtnActualizarEstado();

        EventoMouseClick.AniadirEventoRaton(tablaLibros, libros);
        EventoBtnSalir.AniadirBotonDispose(btnSalir, libros);

        EventoRadioBtnLibros.AniadirRadioButt(todo, tablaLibros);
        EventoRadioBtnLibros.AniadirRadioButt(almacen, tablaLibros);
        EventoRadioBtnLibros.AniadirRadioButt(prestamo, tablaLibros);
        
        EventoBtnModificar.AniadirBotonModificar(btnModificar, libros, tablaLibros);
        EventoBtnAltas.AniadirBotonAltas(btnAniadir, libros, tablaLibros);
        EventoBtnBajas.AniadirBotonBajas(btnEliminar, libros, tablaLibros);
        EventoBtnActualizar.AniadirBotonBajas(btnActualizarEstado, tablaLibros);

    }
    
    public static void AsignarEventos(DlgPrestamos prestamos, Controlador controlador){
        
        JRadioButton btnPrestamos = prestamos.getBtnPrestamos();
        JRadioButton btnAlumnos = prestamos.getBtnAlumnos();
        JRadioButton btnLibros = prestamos.getBtnLibros();
        JTable TablaPrestamos = prestamos.getTablaPrestamos();
        JButton btnPrestamo = prestamos.getBtnPrestamo();
        JButton btnSalir = prestamos.getBtnSalir();
        JButton btnDevolucion = prestamos.getBtnDevolucion();
        
        EventoRadioBtnPrestamos.AniadirRadioButt(btnLibros, TablaPrestamos);
        EventoRadioBtnPrestamos.AniadirRadioButt(btnPrestamos, TablaPrestamos);
        EventoRadioBtnPrestamos.AniadirRadioButt(btnAlumnos, TablaPrestamos);
        
        EventoMouseClick.AniadirEventoRaton(TablaPrestamos, prestamos);
        
        EventoBtnIniciarDlg.AniadirBotonDlgFoPre(btnPrestamo, controlador);
        EventoBtnSalir.AniadirBotonDispose(btnSalir, prestamos);
        EventoBtnIniciarDlg.AniadirBotonDlgFoDe(btnDevolucion, controlador);
        
    }
    
    public static void AsignarEventos(DlgFormularioPrestamo formulario){
        
        JButton btnBuscarAlumno = formulario.getBtnBuscarAlumnos();
        JButton btnBuscarLibros = formulario.getBtnBuscarLibro();
        JTable TablaAlumnos = formulario.getTablaAlumnos();
        JTable TablaLibros = formulario.getTablaLibros();
        JButton btnSalir = formulario.getBtnCancelar();
        JButton aceptar = formulario.getBtnRealizar();
        
        
        
        EventoBtnBuscar.AniadirBotonBuscar(btnBuscarLibros, formulario);
        EventoBtnBuscar.AniadirBotonBuscar(btnBuscarAlumno, formulario);
        
        EventoMouseClick.AniadirEventoRaton(TablaAlumnos, formulario);
        EventoMouseClick.AniadirEventoRaton(TablaLibros, formulario);
        
        EventoBtnSalir.AniadirBotonDispose(btnSalir, formulario);
        EventoBtnAceptar.AniadirBotonAceptar(aceptar, formulario);
    }
    
    public static void AsignarEventos(DlgFormularioDevolucion formulario){
        
        JButton btnBuscar = formulario.getBtnBuscarPrestamo();
        JButton btnAceptar = formulario.getBtnRealizar();
        JButton btnSalir = formulario.getBtnCancelar();
        JTable TablaPrestamosActuales = formulario.getTablaPrestamosActuales();
        
        
        EventoBtnBuscar.AniadirBotonBuscar(btnBuscar, formulario);
        EventoBtnAceptar.AniadirBotonAceptar(btnAceptar, formulario);
        EventoBtnSalir.AniadirBotonDispose(btnSalir, formulario);
        
        EventoMouseClick.AniadirEventoRaton(TablaPrestamosActuales, formulario);
    }

}
