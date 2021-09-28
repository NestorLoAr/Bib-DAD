/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conectores.Conexion;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author zining
 */
public class Informes {

    private Conexion conector;
    private static Connection CON;

    public Informes() {

        conector = new Conexion();
        CON = conector.getConn();
    }

    public JasperViewer getVista(int opcion) {

        String rutaJasper;

        if (opcion == 1) {

            rutaJasper = "src/Informes/AlumnosPrestamos.jrxml";

        } else {

            rutaJasper = "src/Informes/LibrosEstropeados.jrxml";

        }

        Map parametros = new HashMap();

        parametros.put("titulo", "Primer informe");

        System.err.println(opcion);

        try {

            JasperReport informe = JasperCompileManager.compileReport(rutaJasper);

            JasperPrint print = JasperFillManager.fillReport(informe, parametros, CON);

            JasperViewer visorJasper = new JasperViewer(print, false);

            return visorJasper;

        } catch (JRException ex) {
            Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

}
