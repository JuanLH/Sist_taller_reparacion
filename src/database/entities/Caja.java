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
public class Caja {
    int id,id_empleado,fondo,status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }
    
    /*==============================================================*/
    
    public void insert(Caja c) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "INSERT INTO public.cajas(\n" +
                "             id_empleado, fondo)\n" +
                "    VALUES (?, ?, ?);";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setInt(1, c.getId_empleado());
        p.setInt(2, c.getFondo());
       
       
        p.execute();
        p.close();
    }
    
    public void update (Caja c) throws SQLException{
      DB dbase = Utilities.getConection();
        String query = "UPDATE public.cajas\n" +
                "   SET  id_empleado=?, fondo=?\n" +
                " WHERE id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setInt(1, c.getId_empleado());
        p.setInt(2, c.getFondo());
        p.setInt(3, c.getId());
       
       
        p.executeUpdate();
        p.close();  
    }
    
    public void delete (Caja c) throws SQLException{
      DB dbase = Utilities.getConection();
        String query = "UPDATE public.cajas\n" +
                "   SET status = 1 \n" +
                " WHERE id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        
        p.setInt(1, c.getId());
       
       
        p.executeUpdate();
        p.close();  
    }
    
    public static ArrayList<Caja> select() throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Caja> list = new ArrayList<>();
        String query = "SELECT id, id_empleado, fondo , status \n" +
                        "  FROM public.cajas;";
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Caja e = new Caja();
            e.setId(rs.getInt("id"));
            e.setId_empleado(rs.getInt("id_empleado"));
            e.setFondo(rs.getInt("fondo"));
            e.setStatus(rs.getInt("status"));
         
            list.add(e);
        }
        dbase.CerrarConexion();
        return list;
    }
    
}
