/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Tabla;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zining
 */
public class VistaTabla extends AbstractTableModel {
    
    ResultSet _rs;
    ResultSetMetaData md; //contiene información sobre la estructura de un ResulSet,especialmente sobre sus nom campos
    int _numColumnas;
    int _numFilas;
    
    public VistaTabla(ResultSet rs){
      this._rs=rs;
      try{
          md=rs.getMetaData();
          _rs.last();
          _numFilas=_rs.getRow();
          _numColumnas=md.getColumnCount();
          
      }
      catch( SQLException ex){
      }
    }
    @Override
    public int getRowCount() {
        return _numFilas;
        
    }

    @Override
    public int getColumnCount() {
        return _numColumnas;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
          try {
            _rs.absolute(rowIndex+1);
            Object o=_rs.getObject(columnIndex +1);
            return o;
        }
        catch (SQLException ex){
            return ex.toString();
        }
        
    }

    @Override
    public String getColumnName(int column) {
        try {
            
            if(md.getColumnName(column+1).equalsIgnoreCase("dni")){
                return "DNI";
            }else if(md.getColumnName(column+1).equalsIgnoreCase("registro")){
                return "Registro";
                
            }else if(md.getColumnName(column+1).equalsIgnoreCase("nombre")){
                return "Nombre";
                
            }else if(md.getColumnName(column+1).equalsIgnoreCase("apellido1")){
                return "1º Apellido";
                
            }else if(md.getColumnName(column+1).equalsIgnoreCase("apellido2")){
                return "2º Apellido";
                
            }else if(md.getColumnName(column+1).equalsIgnoreCase("codigo")){
                return "Código";
                
            }else if(md.getColumnName(column+1).equalsIgnoreCase("titulo")){
                return "Título";
                
            }else if(md.getColumnName(column+1).equalsIgnoreCase("estado")){
                return "Estado";
                
            }else if(md.getColumnName(column+1).equalsIgnoreCase("codalumno")){
                return "Código Alumno";
                
            }else if(md.getColumnName(column+1).equalsIgnoreCase("codlibros")){
                return "Código Libro";
                
            }else if(md.getColumnName(column+1).equalsIgnoreCase("fechaprestamo")){
                return "Fecha Préstamo";
                
            }else if(md.getColumnName(column+1).equalsIgnoreCase("fechadevolucion")){
                return "Fecha Devolución";
                
            }
            return md.getColumnName(column+1); 
            
        } catch (SQLException ex) {
            Logger.getLogger(VistaTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    
}
