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
public class Modelo_Vehiculo {
    int id,id_marca_vehiculo,id_tipo_vehiculo;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_marca_vehiculo() {
        return id_marca_vehiculo;
    }

    public void setId_marca_vehiculo(int id_marca_vehiculo) {
        this.id_marca_vehiculo = id_marca_vehiculo;
    }

    public int getId_tipo_vehiculo() {
        return id_tipo_vehiculo;
    }

    public void setId_tipo_vehiculo(int id_tipo_vehiculo) {
        this.id_tipo_vehiculo = id_tipo_vehiculo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    /*==============================================================*/
    
    public void insert(Modelo_Vehiculo mod) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "INSERT INTO public.modelo_vehiculo(\n" +
        "  id_marca_vehiculo, id_tipo_vehiculo, name)\n" +
        "    VALUES (?, ?, ?);";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setInt(1, mod.getId_marca_vehiculo());
        p.setInt(2, mod.getId_tipo_vehiculo());
        p.setString(3, mod.getName());
        
       
        p.execute();
        p.close();
    }
    
    public void update(Modelo_Vehiculo mod) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "UPDATE public.modelo_vehiculo\n" +
            "   SET  id_marca_vehiculo=?, id_tipo_vehiculo=?, name=?\n" +
            " WHERE id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setInt(1, mod.getId_marca_vehiculo());
        p.setInt(2, mod.getId_tipo_vehiculo());
        p.setString(3, mod.getName());
        
       
        p.executeUpdate();
        p.close();
    }
    
    public static ArrayList<Modelo_Vehiculo> select() 
            throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Modelo_Vehiculo> list = new ArrayList<>();
        String query = "SELECT id, id_marca_vehiculo, "
                + "id_tipo_vehiculo, name\n" +
            "  FROM public.modelo_vehiculo ;";
        
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Modelo_Vehiculo mv = new Modelo_Vehiculo();
            mv.setId(rs.getInt("id"));
            mv.setId_marca_vehiculo(rs.getInt("id_marca_vehiculo"));
            mv.setId_tipo_vehiculo(rs.getInt("id_tipo_vehiculo"));
            mv.setName(rs.getString("name"));
            list.add(mv);
        }
        return list;
    }
    
    
    
    
    
}
