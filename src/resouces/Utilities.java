/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resouces;

import database.DB;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author juanlht
 */
public class Utilities {
    
    
    public static DB getConection(){
        DB dbase = new DB("tallerAutoDB","postgres","JuanLH@20");
        return dbase;
    }
    
    public static Dimension getScreenSize(){
       return Toolkit.getDefaultToolkit().getScreenSize();
    }
    
    public static Coordinates getCenterLocation(javax.swing.JDialog frm){
        // Determine the new location of the window
        int w = frm.getSize().width;
        int h = frm.getSize().height;
        int x = (getScreenSize().width-w)/2;
        int y = (getScreenSize().height-h)/2;
        
        // Move the window
        return new Coordinates(x,y);
        
    }
    
    public static Date getCurrentDate(){
        DB dbase = Utilities.getConection();
        Date date=null;
        String sql = "select * from current_date ";
        try{
            ResultSet rs = dbase.execSelect(sql);
            rs.next();
            date = rs.getDate(1);
            return date;
        }
        catch(SQLException e){
            System.out.println("Error de la base de datos -> "+e.getMessage());
            return date;
        }
    }
    
    public static void txtClean(Container container){
        for(int x=0;x<container.getComponentCount();x++){
            
            
            if(container.getComponent(x) instanceof JTextField){
                JTextField textField = (JTextField) container.getComponent(x);
                textField.setText("");
            }
            else if(container.getComponent(x) instanceof JTextArea){
                System.out.println("Entro----");
                JTextArea textArea = (JTextArea) container.getComponent(x);
                textArea.setText("");
            }
            
            
        }
    }
    
    public static boolean txtVoid(Container  container){
        for(int x=0;x<container.getComponentCount();x++){
            if(container.getComponent(x) instanceof JTextField){
                JTextField textField = (JTextField) container.getComponent(x);
                if(textField.getText().equals("")){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static Date getJxDate(JXDatePicker jx){
        return new Date((jx.getDate().getYear()),
                jx.getDate().getMonth(),
                jx.getDate().getDate());
    }
    
    
}
