/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Eventos;

import javax.swing.JButton;
import Controlador.Controlador;
/**
 *
 * @author zining
 */
public class EventoBtnIniciarDlg {

    public static void AniadirBotonDlgAlumnos(JButton btnDlgAlumnos, Controlador controlador) {

        btnDlgAlumnos.addActionListener((ae) -> {

            controlador.IniciarDlgAlumno();
        });
    }

    public static void AniadirBotonDlgLibros(JButton btnDlgLibros, Controlador controlador) {

        btnDlgLibros.addActionListener((ae) -> {

            controlador.IniciarDlgLibros();
        });
    }

    public static void AniadirBotonDlgPrestamos(JButton btnDlgLibros, Controlador controlador) {

        btnDlgLibros.addActionListener((ae) -> {

            controlador.IniciarDlgPrestamo();
        });
    }

    public static void AniadirBotonDlgFoPre(JButton btnDlgLibros, Controlador controlador) {

        btnDlgLibros.addActionListener((ae) -> {

            controlador.IniciarDlgFormularioPrestamo();
        });
    }

    public static void AniadirBotonDlgFoDe(JButton btnDlgLibros, Controlador controlador) {

        btnDlgLibros.addActionListener((ae) -> {

            controlador.IniciarDlgFormularioDevolucion();
        });
    }
    
    public static void AniadirBotonDlgInformes(JButton btnInformes, Controlador controlador) {

        btnInformes.addActionListener((ae) -> {

            controlador.IniciarDlgInformes();
        });
    }
    
    public static void AniadirBotonDlgPresentacion(JButton btnPresentacion, Controlador controlador) {

        btnPresentacion.addActionListener((ae) -> {

            controlador.IniciarDlgPresentacion(ae);
        });
    }
}
