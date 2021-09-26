/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Eventos;

import javax.swing.*;

/**
 *
 * @author zining
 */
public class EventoBtnSalir {

    public static void AniadirBotonSalir(JButton btnSalir) {

        btnSalir.addActionListener((ae) -> {

            System.exit(0);

        });

    }
    
    public static void AniadirBotonDispose(JButton dispose, JDialog panel) {

        dispose.addActionListener((ae) -> {

            panel.dispose();

        });

    }

}
