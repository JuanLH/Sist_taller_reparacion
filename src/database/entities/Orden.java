/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entities;

import database.DB;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import resouces.Utilities;

/**
 *
 * @author juanlht
 */
public class Orden {
    int id,id_servicio,id_estado_orden;
    String id_vehiculo,descripcion;
    Date entry_date,departure_date;

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_servicio() {
        return id_servicio;
    }
    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }
    public int getId_estado_orden() {
        return id_estado_orden;
    }
    public void setId_estado_orden(int id_estado_orden) {
        this.id_estado_orden = id_estado_orden;
    }
    public String getId_vehiculo() {
        return id_vehiculo;
    }
    public void setId_vehiculo(String id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }
    public Date getEntry_date() {
        return entry_date;
    }
    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }
    public Date getDeparture_date() {
        return departure_date;
    }
    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }
    /*=================================================================*/
    public void insert(Orden or) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "INSERT INTO public.ordenes(\n" +
            "  id_servicio, id_vehiculo,descripcion, id_estado_orden)\n" +
            "    VALUES (?, ?, ?,?);";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        
        p.setInt(1, or.getId_servicio());
        p.setString(2, or.getId_vehiculo());
        p.setString(3, or.getDescripcion());
        p.setInt(4, or.getId_estado_orden());
      
        p.execute();
        p.close();
    }
    /*this query will be execute when you need to change principal data*/
    public void update(Orden or) throws SQLException{
         DB dbase = Utilities.getConection();
        String query = "UPDATE public.ordenes\n" +
                "   SET id_servicio=?, id_vehiculo=?,descripcion = ?,"
                + "id_estado_orden = ? \n" +
                " WHERE id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        
        p.setInt(1, or.getId_servicio());
        p.setString(2, or.getId_vehiculo());
        p.setString(3, or.getDescripcion());
        p.setInt(4, or.getId_estado_orden());
        p.setInt(5,or.getId());
       
        p.executeUpdate();
        p.close();
    }
    /*this query will be execute when the orden change her status*/
    public void updateStatus(Orden or) throws SQLException{
         DB dbase = Utilities.getConection();
        String query = "UPDATE public.ordenes\n" +
            "   SET id_estado_orden=?\n" +
            " WHERE id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        
        p.setInt(1, or.getId_estado_orden()+1);
        p.setInt(2,or.getId());
       
        p.executeUpdate();
        p.close();
    }
   /*This query will be execute when the order ends*/
    public void updateDepDate(Orden or) throws SQLException{
         DB dbase = Utilities.getConection();
        String query = "UPDATE public.ordenes\n" +
            "   SET  departure_date=?, \n" +
            "       id_estado_orden=?\n" +
            " WHERE id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        
        p.setInt(1, or.getId_estado_orden()+1);
        p.setInt(2,or.getId());
       
        p.executeUpdate();
        p.close();
    }
    public void delete(Orden or) 
            throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "DELETE FROM public.ordenes\n" +
                " WHERE where id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setInt(1, or.getId());
        p.executeUpdate();
        p.close();
    }
    
    public static ArrayList<Orden> select() 
            throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Orden> list = new ArrayList<>();
        String query = "SELECT id, id_servicio, id_vehiculo,descripcion, "
                + "entry_date, departure_date, id_estado_orden\n" +
                "  FROM public.ordenes;";
        
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Orden s = new Orden();
            s.setId(rs.getInt("id"));
            s.setId_servicio(rs.getInt("id_servicio"));
            s.setId_vehiculo(rs.getString("id_vehiculo"));
            s.setDescripcion(rs.getString("descripcion"));
            s.setEntry_date(rs.getDate("entry_date"));
            s.setDeparture_date(rs.getDate("departure_date"));
            s.setId_estado_orden(rs.getInt("id_estado_orden"));
            
            list.add(s);
        }
        return list;
    }
    
    public static ArrayList<Orden> select(int id_estado) 
            throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Orden> list = new ArrayList<>();
        String query = "SELECT id, id_servicio, id_vehiculo,descripcion, "
                + "entry_date, departure_date, id_estado_orden\n" +
                "  FROM public.ordenes where id_estado_orden = "+id_estado+";";
        
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Orden s = new Orden();
            s.setId(rs.getInt("id"));
            s.setId_servicio(rs.getInt("id_servicio"));
            s.setId_vehiculo(rs.getString("id_vehiculo"));
            s.setDescripcion(rs.getString("descripcion"));
            s.setEntry_date(rs.getDate("entry_date"));
            s.setDeparture_date(rs.getDate("departure_date"));
            s.setId_estado_orden(rs.getInt("id_estado_orden"));
            
            list.add(s);
        }
        return list;
    }
    
}
