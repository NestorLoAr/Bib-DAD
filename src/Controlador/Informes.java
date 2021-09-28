/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conectores.Conexion;
import Vistas.Menu;
import java.sql.Connection;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.save.JRPdfSaveContributor.*;
import net.sf.jasperreports.view.JRViewer.*;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor.*;

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

        String rutaJasper = "/home/zining/Proyectos Java/Netbeans/Biblioteca_0_3_1/src/Informes/Informes.jrxml";

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
