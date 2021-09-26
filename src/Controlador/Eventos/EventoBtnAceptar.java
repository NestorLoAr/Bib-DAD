/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Eventos;

import Controlador.ValidarFormularioDevolucion;
import Controlador.ValidarFormularioPrestamo;
import Vistas.DlgFormularioDevolucion;
import Vistas.DlgFormularioPrestamo;
import javax.swing.JButton;

/**
 *
 * @author zining
 */
public class EventoBtnAceptar {

    public static void AniadirBotonAceptar(JButton btnAceptar, DlgFormularioPrestamo formulario) {

        btnAceptar.addActionListener((ae) -> {

            ValidarFormularioPrestamo validar = new ValidarFormularioPrestamo(formulario);

            validar.Validar();
        });
    }

    public static void AniadirBotonAceptar(JButton btnAceptar, DlgFormularioDevolucion formulario) {

        btnAceptar.addActionListener((ae) -> {

            ValidarFormularioDevolucion validar = new ValidarFormularioDevolucion(formulario);

            validar.Validar();
        });
    }

}
