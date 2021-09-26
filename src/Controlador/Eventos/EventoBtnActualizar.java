/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Eventos;

import Conectores.Actualizacion;
import Controlador.Tabla.IniciarTabla;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author zining
 */
public class EventoBtnActualizar {

    public static void AniadirBotonBajas(JButton btnBajas, JTable TablaLibros) {

        btnBajas.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnBajasActionPerformed(TablaLibros);
        });
    }

    private static void btnBajasActionPerformed(JTable TablaLibros) {

        String sql = "UPDATE libros, prestamos SET libros.estado = prestamos.estado WHERE libros.codigo = prestamos.codLibros;";

        Actualizacion actualiza = new Actualizacion();

        if (actualiza.Ejecutar_Sql_Actualizacion(sql) > 0) {

            IniciarTabla.IniciaTabla(TablaLibros, "libros", null);

            JOptionPane.showMessageDialog(null, "Actualización realizada con éxito");

        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }

    }

}
