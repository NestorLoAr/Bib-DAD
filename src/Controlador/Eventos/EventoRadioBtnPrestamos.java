/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Eventos;

import Controlador.Tabla.IniciarTabla;
import javax.swing.JRadioButton;
import javax.swing.JTable;

/**
 *
 * @author zining
 */
public class EventoRadioBtnPrestamos {

    public static void AniadirRadioButt(JRadioButton botonSeleccionado, JTable tabla) {

        botonSeleccionado.addActionListener((ae) -> {

            IniciarTabla.IniciaTabla(tabla, "prestamos", ae.getActionCommand());
        });
    }

}
