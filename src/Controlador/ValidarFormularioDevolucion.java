/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conectores.Actualizacion;
import Vistas.DlgFormularioDevolucion;
import java.sql.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.jdatepicker.JDatePicker;

/**
 *
 * @author zining
 */
public class ValidarFormularioDevolucion {

    private JDatePicker fechaSeleccion;
    private Date fechaSql;
    private DlgFormularioDevolucion formulario;
    private JComboBox<String> combo;
    private String seleccion;

    private String id;

    public ValidarFormularioDevolucion(DlgFormularioDevolucion formulario) {

        this.formulario = formulario;
        fechaSeleccion = formulario.getBtnFecha();

        combo = formulario.getComboEstado();

        id = formulario.getTxtId().getText();

        seleccion = (String) combo.getSelectedItem();

        int dia = fechaSeleccion.getModel().getDay();
        int mes = fechaSeleccion.getModel().getMonth();
        int agno = fechaSeleccion.getModel().getYear();

        fechaSql = new Date(agno - 1900, mes, dia);
    }

    public void Validar() {

        if (seleccion == null) {

            JOptionPane.showMessageDialog(null, "Elija un estado del menú desplegable,por favor", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (id.equals("")) {

            JOptionPane.showMessageDialog(null, "Elija un préstamo de la lista, por favor", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            Devolucion();
        }

    }

    private void Devolucion() {

        String sql = "UPDATE prestamos SET FechaDevolucion = '" + fechaSql.toString() + "', estado = '" + seleccion + "' WHERE id  = '" + id + "';";

        Actualizacion actualiza = new Actualizacion();

        if (actualiza.Ejecutar_Sql_Actualizacion(sql) > 0) {

            JOptionPane.showMessageDialog(null, "Devolución actualizada correctamente");

            formulario.dispose();

        } else {

            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
    }

}
