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
import resouces.Utilities;

/**
 *
 * @author juanlht
 */
public class Modelo {
    int id,id_marca,id_tipo_vehiculo;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
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
    
    /*==========================================================*/
    
    public  void insert(Modelo m) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "INSERT INTO public.modelo_vehiculo(\n" +
            "            id_marca_vehiculo, id_tipo_vehiculo, name)\n" +
            "    VALUES ( ?, ?, ?);";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        
       
        p.setInt(1, m.getId_marca());
        p.setInt(2,m.getId_tipo_vehiculo());
        p.setString(3, m.getName());
        
      
        p.execute();
        p.close();
    }
    
    public  void update(Modelo m) throws SQLException{
         DB dbase = Utilities.getConection();
        String query = "UPDATE public.modelo_vehiculo\n" +
            "   SET  id_marca_vehiculo=?, id_tipo_vehiculo=?, name=?\n" +
            " WHERE id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        
        
        p.setInt(1, m.getId_marca());
        p.setInt(2,m.getId_tipo_vehiculo());
        p.setString(3, m.getName());
        p.setInt(4, m.getId());
        
       
        p.executeUpdate();
        p.close();
    }
    
    public static Modelo get(String id_vehiculo) throws SQLException{
        DB dbase= Utilities.getConection();
        Modelo m = null;
        String query ="SELECT id, id_marca_vehiculo, id_tipo_vehiculo, name\n" +
           "  FROM public.modelo_vehiculo m inner join public.vehiculos v \n" +
           "  on m.id = v.id_modelo and v.chapa = '"+id_vehiculo+"';";
       
        ResultSet rs = dbase.execSelect(query);
        
        while(rs.next()){
            m = new Modelo();
            m.setId(rs.getInt("id"));
            m.setId_marca(rs.getInt("id_marca_vehiculo"));
            m.setId_tipo_vehiculo(rs.getInt("id_tipo_vehiculo"));
            m.setName(rs.getString("name"));
               
        }
        dbase.CerrarConexion();
            
        return m;
    }
    
    
}
