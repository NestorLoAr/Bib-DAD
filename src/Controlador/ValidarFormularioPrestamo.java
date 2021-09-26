/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conectores.Actualizacion;
import Vistas.DlgFormularioPrestamo;
import java.sql.Date;
import javax.swing.JOptionPane;
import org.jdatepicker.JDatePicker;

/**
 *
 * @author zining
 */
public class ValidarFormularioPrestamo {

    private String codAlumno;
    private String codLibro;
    private JDatePicker fechaSeleccion;
    private Date fechaSql;
    private DlgFormularioPrestamo formulario;

    public ValidarFormularioPrestamo(DlgFormularioPrestamo formulario) {

        this.formulario = formulario;

        codAlumno = formulario.getTxtRegistroAlumno().getText();
        codLibro = formulario.getTxtCodLibro().getText();
        fechaSeleccion = formulario.getBtnFecha();

        int dia = fechaSeleccion.getModel().getDay();
        int mes = fechaSeleccion.getModel().getMonth();
        int agno = fechaSeleccion.getModel().getYear();

        fechaSql = new Date(agno - 1900, mes, dia);

    }

    public void Validar() {

        if (codAlumno.equals("")) {

            JOptionPane.showMessageDialog(null, "Elija un alumno de la tabla, por favor", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (codLibro.equals("")) {

            JOptionPane.showMessageDialog(null, "Elija un libro de la tabla, por favor", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            AltaPrestamo();
        }
    }

    private void AltaPrestamo() {

        String sql = "INSERT INTO prestamos (codAlumno,codLibros, FechaPrestamo) VALUES ('" + codAlumno + "',"
                + "'" + codLibro + "','" + fechaSql.toString() + "');";

        Actualizacion actualiza = new Actualizacion();

        if (actualiza.Ejecutar_Sql_Actualizacion(sql) > 0) {

            JOptionPane.showMessageDialog(null, "Préstamo realizado correctamente");

            formulario.dispose();

        } else {

            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
    }

}
