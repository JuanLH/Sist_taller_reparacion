/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entities;

import database.DB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import resouces.Utilities;

/**
 *
 * @author juanlht
 */
public class Marca {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    /*------------------------------------------------------*/
    
    public  void insert(Marca m) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "INSERT INTO public.marca_vehiculo( name)\n" +
        "    VALUES (?);";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        
       
        p.setString(1, m.getName());
        
      
        p.execute();
        p.close();
    }
    
    public  void update(Marca m) throws SQLException{
         DB dbase = Utilities.getConection();
        String query = "UPDATE public.marca_vehiculo\n" +
            "   SET  name=?\n" +
            " WHERE id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        
        
        p.setString(1, m.getName());
        p.setInt(2, m.getId());
        
       
        p.executeUpdate();
        p.close();
    }
}
