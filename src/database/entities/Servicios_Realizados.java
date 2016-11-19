/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entities;

import database.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import resouces.Utilities;

/**
 *
 * @author juanlht
 */
public class Servicios_Realizados {
    
    int  id_orden,id_servicio; 

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }
    
    /*-------------------------------------------*/
    
    public static void insert(Servicios_Realizados sr) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "INSERT INTO public.servicios_realizados(\n" +
                        "            id_orden, id_servicio)\n" +
                        "    VALUES (?, ?);";
        PreparedStatement p = DB.conexion.prepareStatement(query);

        p.setInt(1, sr.getId_orden());
        p.setInt(2, sr.getId_servicio());
        
        p.execute();  
        p.close();
    }
    
    public static void delete(Servicios_Realizados sr) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "DELETE FROM public.servicios_realizados\n" +
                " WHERE id_orden = ?  and  id_servicio = ?;";
        PreparedStatement p = DB.conexion.prepareStatement(query);

        p.setInt(1, sr.getId_orden());
        p.setInt(2, sr.getId_servicio());
        
        p.execute();  
        p.close();
    }
    
    public static ArrayList<Servicio> select(int id_orden)throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Servicio> list = new ArrayList<>();
        String query = "SELECT id_servicio,s.name,s.cost \n" +
        "  FROM public.servicios_realizados as sr inner join servicios as s "
                        + "on sr.id_servicio = s.id\n" +
        "  where sr.id_orden = "+id_orden+";";
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Servicio e = new Servicio();
            e.setId(rs.getInt(1));
            e.setName(rs.getString(2));
            e.setCost(rs.getDouble(3));
            
         
            list.add(e);
        }
        dbase.CerrarConexion();
        return list;
    }
    
    
}
