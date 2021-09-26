/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Eventos;

import Controlador.Tabla.IniciarTabla;
import javax.swing.*;

import Conectores.*;
import Vistas.DlgAlumnos;
import Vistas.DlgLibros;


/**
 *
 * @author zining
 */
public class EventoBtnModificar {

    public static void AniadirBotonModificar(JButton btnModificaciones, DlgAlumnos panel, JTable TablaAlumnos) {

        btnModificaciones.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnModificacionesActionPerformed(evt, panel, TablaAlumnos);
        });

    }

    private static void btnModificacionesActionPerformed(java.awt.event.ActionEvent evt, DlgAlumnos panel, JTable TablaAlumnos) {

        JTextField txtDni = panel.getTxtDni();
        JTextField txtRegistro = panel.getTxtRegistro();
        JTextField txtNombre = panel.getTxtNombre();
        JTextField txtApellido1 = panel.getTxtApellido1();
        JTextField txtApellido2 = panel.getTxtApellido2();

        String sql = "update alumnos set dni='" + txtDni.getText() + "', nombre='" + txtNombre.getText() + "', "
                + "apellido1='" + txtApellido1.getText() + "', apellido2='" + txtApellido2.getText() + "' "
                + "where registro=" + txtRegistro.getText();

        Actualizacion actualiza = new Actualizacion();

        if (actualiza.Ejecutar_Sql_Actualizacion(sql) > 0) {

            IniciarTabla.IniciaTabla(TablaAlumnos, "alumnos", null); 

            JOptionPane.showMessageDialog(null, "Modificación Correcta");

        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
    }
    
    public static void AniadirBotonModificar(JButton btnModificaciones, DlgLibros panel, JTable TablaLibros) {

        btnModificaciones.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnModificacionesActionPerformed(evt, panel, TablaLibros);
        });

    }
    
    private static void btnModificacionesActionPerformed(java.awt.event.ActionEvent evt, DlgLibros panel, JTable TablaLibros) {

        
        JTextField txtCodigo = panel.getTxtCodigo();
        JTextField txtTitulo = panel.getTxtTitulo();
        JTextField txtAutor = panel.getTxtAutor();
        JTextField txtEditorial = panel.getTxtEditorial();
        JTextField txtAsignatura = panel.getTxtAsignatura();
        JTextField txtEstado = panel.getTxtEstado();
        
        

        String sql = "UPDATE libros SET titulo='"+ txtTitulo.getText() +"', Autor='"+ txtAutor.getText() +"',"
                + " Editorial='"+ txtEditorial.getText() +"', Asignatura='"+ txtAsignatura.getText() +"',"
                + " estado='"+ txtEstado.getText() +"' WHERE codigo="+ txtCodigo.getText() +";";

        Actualizacion actualiza = new Actualizacion();

        if (actualiza.Ejecutar_Sql_Actualizacion(sql) > 0) {

            IniciarTabla.IniciaTabla(TablaLibros, "libros", null);

            JOptionPane.showMessageDialog(null, "Modificación Correcta");

        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
    }

}
