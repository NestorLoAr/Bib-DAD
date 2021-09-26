/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Eventos;

import Controlador.Busquedas;
import Vistas.DlgFormularioDevolucion;
import Vistas.DlgFormularioPrestamo;
import javax.swing.JButton;

/**
 *
 * @author zining
 */
public class EventoBtnBuscar {

    public static void AniadirBotonBuscar(JButton btnBuscar, DlgFormularioPrestamo formulario) {

        btnBuscar.addActionListener((ae) -> {

            Busquedas.Buscar(formulario, ae.getActionCommand());
        });

    }
    
    public static void AniadirBotonBuscar(JButton btnBuscar, DlgFormularioDevolucion formulario) {

        btnBuscar.addActionListener((ae) -> {
            

            Busquedas.Buscar(formulario);
        });

    }

}
