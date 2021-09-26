/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Eventos;

import Conectores.Actualizacion;
import Controlador.Tabla.IniciarTabla;
import javax.swing.*;
import Vistas.DlgAlumnos;
import Vistas.DlgLibros;

/**
 *
 * @author zining
 */
public class EventoBtnAltas {

    public static void AniadirBotonAltas(JButton btnAltas, DlgAlumnos panel, JTable TablaAlumnos) {

        btnAltas.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnAltasBotonesClick(evt, panel, TablaAlumnos);
        });
    }

    private static void btnAltasBotonesClick(java.awt.event.ActionEvent evt, DlgAlumnos panel, JTable TablaAlumnos) {

        JTextField txtDni = panel.getTxtDni();
        JTextField txtNombre = panel.getTxtNombre();
        JTextField txtApellido1 = panel.getTxtApellido1();
        JTextField txtApellido2 = panel.getTxtApellido2();

        String sql = "INSERT INTO alumnos (dni,nombre,apellido1,apellido2) VALUES ('" + txtDni.getText() + "',"
                + "'" + txtNombre.getText() + "','" + txtApellido1.getText() + "','" + txtApellido2.getText() + "');";

        Actualizacion actualiza = new Actualizacion();

        if (actualiza.Ejecutar_Sql_Actualizacion(sql) > 0) {

            IniciarTabla.IniciaTabla(TablaAlumnos, "alumnos", null); 

            JOptionPane.showMessageDialog(null, "Alta Correcta");

        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
    }
    
    public static void AniadirBotonAltas(JButton btnAltas, DlgLibros panel, JTable TablaLibros) {

        btnAltas.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnAltasBotonesClick(evt, panel, TablaLibros);
        });
    }

    private static void btnAltasBotonesClick(java.awt.event.ActionEvent evt, DlgLibros panel, JTable TablaAlumnos) {

        JTextField txtCodigo = panel.getTxtCodigo();
        JTextField txtTitulo = panel.getTxtTitulo();
        JTextField txtAutor = panel.getTxtAutor();
        JTextField txtEditorial = panel.getTxtEditorial();
        JTextField txtAsignatura = panel.getTxtAsignatura();
        JTextField txtEstado = panel.getTxtEstado();
        
        

        String sql = "INSERT INTO libros (codigo, titulo, Autor, Editorial, Asignatura, estado) VALUES("+ txtCodigo.getText() +", '"+ txtTitulo.getText() +"', '"+ txtAutor.getText() +"', '"+ txtEditorial.getText() +"', '"+ txtAsignatura.getText() +"', '"+ txtEstado.getText() +"');";

        Actualizacion actualiza = new Actualizacion();

        if (actualiza.Ejecutar_Sql_Actualizacion(sql) > 0) {

            IniciarTabla.IniciaTabla(TablaAlumnos, "libros", null); 

            JOptionPane.showMessageDialog(null, "Alta Correcta");

        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
    }

}
