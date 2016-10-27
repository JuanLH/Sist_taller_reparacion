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
public class Articulo {
    private int id,id_suplidor,existencia,punto_reorden,id_area;
    private String name;
    private Double cost;

    public int getId() {
        return id;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_suplidor() {
        return id_suplidor;
    }

    public void setId_suplidor(int id_suplidor) {
        this.id_suplidor = id_suplidor;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getPunto_reorden() {
        return punto_reorden;
    }

    public void setPunto_reorden(int punto_reorden) {
        this.punto_reorden = punto_reorden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
    
    /*===================================================================*/
    
    public void insert(Articulo a) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "INSERT INTO public.articulos(\n" +
                        "id_suplidor, id_area, name, cost,\n" +
                        "existencia, punto_reorden)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?);";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setInt(1, a.getId_suplidor());
        p.setInt(2, a.getId_area());
        p.setString(3, a.getName());
        p.setDouble(4, a.getCost());
        p.setInt(5, a.getExistencia());
        p.setInt(6, a.getPunto_reorden());
        
        p.execute();
        p.close();
    }
    
    public void update(Articulo a) throws SQLException {
        DB dbase = Utilities.getConection();
       String query = "UPDATE public.articulos\n" +
                    "SET  id_suplidor=?, id_area=?, name=?, cost=?, \n" +
                    "existencia=?, punto_reorden=?\n" +
                    "WHERE id=?;"; 

        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setInt(1, a.getId_suplidor());
        p.setInt(2, a.getId_area());
        p.setString(3, a.getName());
        p.setDouble(4, a.getCost());
        p.setInt(5, a.getExistencia());
        p.setInt(6, a.getPunto_reorden());
        p.setInt(7, a.getId());
        
        p.executeUpdate();
        p.close();
           
        
    }
    
    public void delete(Articulo a) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "UPDATE public.articulos\n" +
                    "SET status=1\n" +
                    "WHERE id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setInt(1, a.getId());
        
        p.executeUpdate();
        p.close();
        
    }
    
    public static ArrayList<Articulo> select() 
            throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Articulo> list = new ArrayList<>();
        String query = "SELECT id, id_suplidor, id_area, name,\n" +
                    "cost, existencia, punto_reorden\n" +
                    "FROM public.articulos WHERE status = 0;";
        
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Articulo a = new Articulo();
            a.setId(rs.getInt("id"));
            a.setId_suplidor(rs.getInt("id_suplidor"));
            a.setId_area(rs.getInt("id_area"));
            a.setName(rs.getString("name"));
            a.setCost(rs.getDouble("cost"));
            a.setExistencia(rs.getInt("existencia"));
            a.setPunto_reorden(rs.getInt("punto_reorden"));
            
            
            list.add(a);
        }
        dbase.CerrarConexion();
        return list;
    }
    

    //This method can be better 
    /*public static Object get(int id,String columnName)
            throws SQLException{
        
        DB dbase = Utilities.getConection();
        Empleados emp = new Empleados();
        String query = "SELECT  "+columnName+" " +
                        " FROM public.empleados WHERE status = 0 " +
                        " and cedula = '"+cedula+"' ";
        ResultSet rs = dbase.execSelect(query);
        rs.next();
        return rs.getObject(1);
    }*/
}
