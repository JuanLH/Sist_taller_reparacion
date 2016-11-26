/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports.factura;
import database.entities.Articulo;
import database.entities.Servicio;
import database.entities.Trans;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
/**
 *
 * @author juanlht
 */
public class FacturaDataSource implements JRDataSource{

    ArrayList<Trans> list ;
    boolean val=false;
    int count;
    
    public FacturaDataSource(int id_orden) {
        try {
            this.list = Trans.select(id_orden);
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDataSource.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    
    
    @Override
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
            case "NOMBRE":
                if(list.get(count).getId_tipo_trans()==4)
                {
                    try {
                        valor = Articulo.get(Integer.parseInt(list.get(count).getRef_tran()), "name");
                    } catch (SQLException ex) {
                        Logger.getLogger(FacturaDataSource.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    try {
                        valor = Servicio.get(Integer.parseInt(list.get(count).getRef_tran())).getName();
                    } catch (SQLException ex) {
                        Logger.getLogger(FacturaDataSource.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            break;
            case "CANTIDAD":
                valor =  Integer.toString(list.get(count).getCantidad());
            break;
            case "VALOR":
                valor =  formateador.format(list.get(count).getValor());
            break;    
            case "TOTAL" :
                valor =  formateador.format(list.get(count).getTotal());
            break;  
              
        }
        return valor;
    }
    
}
