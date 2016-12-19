/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports.informativos;


import database.entities.Orden;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import reports.factura.FacturaDataSource;

/**
 *
 * @author juanlht
 */
public class RepOrdenCotizada implements JRDataSource {
    ArrayList<Orden> list ;
    boolean val=false;
    int count;
    Double acum=0.0;
    
    public RepOrdenCotizada() {
        try {
            this.list = Orden.getCotizado();
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDataSource.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    public RepOrdenCotizada(Date d1,Date d2) {
       
        try {
            this.list =  Orden.getCotizado(d1, d2);
        } catch (SQLException ex) {
            Logger.getLogger(RegGastoDataSource.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
       
    }

    
    
    public boolean next() throws JRException {
        while(count<list.size()-1){
            if(!val){
                val = true;
                return true;
            }
            else
            {
                count++;
                return true;
            }
            
        }
        return false;
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        DecimalFormat formateador = new DecimalFormat("###,###,###.##");
        Object valor = null;
        switch  (jrf.getName()){
            case "cod_orden":
               valor = Integer.toString(list.get(count).getId());
            break;
            case "fecha":
               valor = list.get(count).getEntry_date().toString();
            break;case "descripcion":
               valor = list.get(count).getDescripcion();
            break;             
        }
        return valor;
    }
}
