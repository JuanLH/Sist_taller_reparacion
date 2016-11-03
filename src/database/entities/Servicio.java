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
public class Servicio {
    int id,id_area,status;
    String name,descripcion;
    Double cost;

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

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
    
    /*==================================================================*/
    
    public void insert(Servicio ser) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "INSERT INTO public.servicios(\n" +
        "            name, id_area, descripcion, cost)\n" +
        "    VALUES (?, ?, ?, ?);";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        
        p.setString(1, ser.getName());
        p.setInt(2, ser.getId_area());
        p.setString(3, ser.getDescripcion());
        p.setDouble(4, ser.getCost());
        p.execute();
        p.close();
    }
    
    public void update(Servicio ser) throws SQLException{
         DB dbase = Utilities.getConection();
        String query = "UPDATE public.servicios\n" +
        "   SET  name=?, id_area=?, descripcion=?,\n" +
        "	cost=?, status=?\n" +
        " WHERE id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        
        p.setString(1, ser.getName());
        p.setInt(2, ser.getId_area());
        p.setString(3, ser.getDescripcion());
        p.setDouble(4, ser.getCost());
        p.setInt(5, ser.getStatus());
        p.setInt(6, ser.getId());
        p.executeUpdate();
        p.close();
    }
    
    
    public void delete(Servicio ser) 
            throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "UPDATE public.servicios\n" +
        "   SET   status=1\n" +
        " WHERE id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setInt(1, ser.getId());
        p.executeUpdate();
        p.close();
    }
    
    public static ArrayList<Servicio> select() 
            throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Servicio> list = new ArrayList<>();
        String query = "SELECT id, name, id_area, "
                + "descripcion, cost, status\n" +
                "  FROM public.servicios where status = 0;";
        
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Servicio s = new Servicio();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setId_area(rs.getInt("id_area"));
            s.setDescripcion(rs.getString("descripcion"));
            s.setCost(rs.getDouble("cost"));
            s.setStatus(rs.getInt("status"));
            
            list.add(s);
        }
        return list;
    }
}
