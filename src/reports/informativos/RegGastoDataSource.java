/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports.informativos;

import database.entities.Articulo;
import database.entities.Servicio;
import database.entities.Trans;
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
public class RegGastoDataSource implements JRDataSource {
    ArrayList<Trans> list ;
    boolean val=false;
    int count;
    Double acum=0.0;
    
    public RegGastoDataSource() {
        try {
            this.list = Trans.getGastos();
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDataSource.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    public RegGastoDataSource(Date d1,Date d2) {
       
        try {
            this.list =  Trans.getGastos(d1, d2);
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
            case "cod_trans":
               valor = Integer.toString(list.get(count).getId());
            break;
            case "fecha":
                valor = list.get(count).getFecha().toString();
            break;
            case "descripcion":
                if(list.get(count).getId_tipo_trans()==2){
                    valor = "PAGO DE EMPLEADO "+list.get(count).getRef_tran();
                }
                else{
                    try {
                        valor = "COMPRA DE ARTICULO "+(String)Articulo.get
                        ((Integer.parseInt(list.get(count).getId_resource()))
                                , "name");
                    } catch (SQLException ex) {
                        Logger.getLogger(RegGastoDataSource.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }

                }
            break;    
            case "cantidad" :
                valor = Integer.toString(list.get(count).getCantidad());
            break;  
            case "valor":
                valor = Double.toString(list.get(count).getValor());
            break;
            case "total":
                valor = Double.toString(list.get(count).getTotal());
            break;
            case "acumulado":
                acum = acum + list.get(count).getValor();
                valor = Double.toString(acum);
            break;
              
        }
        return valor;
    }
}
