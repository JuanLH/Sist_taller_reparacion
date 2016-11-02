/*
 * To change this license header, choose License Headers in Project
    Properties.
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
public class Vehiculo {
    String chapa;
    int id_modelo,year,id_color,id_combustible,id_cliente;
    boolean maintenance;
    
    public String getChapa() {
        return chapa;
    }
    public void setChapa(String chapa) {
        this.chapa = chapa;
    }
    public int getId_modelo() {
        return id_modelo;
    }
    public void setId_modelo(int id_modelo) {
        this.id_modelo = id_modelo;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getId_color() {
        return id_color;
    }
    public void setId_color(int id_color) {
        this.id_color = id_color;
    }
    public int getId_combustible() {
        return id_combustible;
    }
    public void setId_combustible(int id_combustible) {
        this.id_combustible = id_combustible;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public boolean isMaintenance() {
        return maintenance;
    }
    public void setMaintenance(boolean maintenance) {
        this.maintenance = maintenance;
    }
    /*================================================================*/
    
    public void insert(Vehiculo v) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "INSERT INTO public.vehiculos(\n" +
        "            chapa, id_modelo, year, color, id_combustible,\n" +
        "	    id_cliente, maintenance)\n" +
        "    VALUES (?, ?, ?, ?, ?, ?, ?);";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setString(1, v.getChapa());
        p.setInt(2, v.getId_modelo());
        p.setInt(3, v.getYear());
        p.setInt(4, v.getId_color());
        p.setInt(5, v.getId_combustible());
        p.setInt(6, v.getId_cliente());
        p.setBoolean(7, v.isMaintenance());
        p.execute();
        p.close();
    }
    public void update(Vehiculo v)throws SQLException{
        DB dbase= Utilities.getConection();
        String query = "UPDATE public.vehiculos\n" +
        "SET  id_modelo=?, year=?, color=?, id_combustible=?, \n" +
        "id_cliente=?, maintenance=? WHERE chapa=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setInt(1, v.getId_modelo());
        p.setInt(2, v.getYear());
        p.setInt(3, v.getId_color());
        p.setInt(4, v.getId_combustible());
        p.setInt(5, v.getId_cliente());
        p.setBoolean(6, v.isMaintenance());
        p.setString(7, v.getChapa());
        p.execute();
        p.close();
    }
    public static ArrayList<Vehiculo> select () throws SQLException{
        DB dbase= Utilities.getConection();
        ArrayList<Vehiculo> list = new ArrayList<>();
        String query = "SELECT v.chapa, v.id_modelo, v.year, v.color,\n" +
        "v.id_combustible, v.id_cliente, v.maintenance\n" +
        "FROM public.vehiculos v \n" +
        "INNER JOIN public.clientes c \n" +
        "ON c.id = v.id_cliente AND c.status=0;";
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Vehiculo v = new Vehiculo();
            v.setChapa(rs.getString("v.chapa"));
            v.setId_modelo(rs.getInt("v.id_modelo"));
            v.setYear(rs.getInt("v.year"));
            v.setId_color(rs.getInt("v.color"));
            v.setId_combustible(rs.getInt("v.id_combustible"));
            v.setId_cliente(rs.getInt("v.id_cliente"));
            v.setMaintenance(rs.getBoolean("v.maintenance"));
            list.add(v);
        }
        dbase.CerrarConexion();
        return list;
    }
    
    
    
    
    
    
    
}
