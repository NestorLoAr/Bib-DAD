/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Eventos;

import Conectores.Actualizacion;
import Controlador.Tabla.IniciarTabla;
import Vistas.DlgAlumnos;
import Vistas.DlgLibros;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author zining
 */
public class EventoBtnBajas {

    public static void AniadirBotonBajas(JButton btnBajas, DlgAlumnos alumnos, JTable TablaAlumnos) {

        btnBajas.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnBajasActionPerformed(evt, alumnos, TablaAlumnos);
        });
    }

    private static void btnBajasActionPerformed(java.awt.event.ActionEvent evt, DlgAlumnos alumnos, JTable TablaAlumnos) {

        JTextField txtRegistro = alumnos.getTxtRegistro();

        String sql = "delete from alumnos where registro=" + txtRegistro.getText();

        Actualizacion actualiza = new Actualizacion();

        if (actualiza.Ejecutar_Sql_Actualizacion(sql) > 0) {

            IniciarTabla.IniciaTabla(TablaAlumnos, "alumnos", null);

            JOptionPane.showMessageDialog(null, "Baja Correcta");

        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }

    }
    
    public static void AniadirBotonBajas(JButton btnBajas, DlgLibros libros, JTable TablaLibros) {

        btnBajas.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnBajasActionPerformed(evt, libros, TablaLibros);
        });
    }

    private static void btnBajasActionPerformed(java.awt.event.ActionEvent evt, DlgLibros libros, JTable TablaLibros) {

        JTextField txtCodigo = libros.getTxtCodigo();

        String sql = "delete from libros where codigo=" + txtCodigo.getText();

        Actualizacion actualiza = new Actualizacion();

        if (actualiza.Ejecutar_Sql_Actualizacion(sql) > 0) {

            IniciarTabla.IniciaTabla(TablaLibros, "libros", null);

            JOptionPane.showMessageDialog(null, "Baja Correcta");

        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }

    }

}
