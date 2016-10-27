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
public class Suplidor {
    static Suplidor suplidor = new Suplidor();
    int id;
    String nombre,telefono,direccion;

    public static Suplidor getSuplidor() {
        return suplidor;
    }

    public static void setSuplidor(Suplidor suplidor) {
        Suplidor.suplidor = suplidor;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /*=====================================================================*/
    
    public void insert(Suplidor s) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "INSERT INTO public.suplidores(name, telefono,"
                     + "direccion)\n" +
                       " VALUES (?, ?, ?);";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setString(1, s.getNombre());
        p.setString(2, s.getTelefono());
        p.setString(3, s.getDireccion());
        
        p.execute();
        p.close();
    }
    
    public void update(Suplidor s) throws SQLException {
        DB dbase = Utilities.getConection();
       String query = "UPDATE public.suplidores\n" +
                    "   SET  name=?, telefono=?, direccion=?\n" +
                    " WHERE id=?;"; 
       
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setString(1, s.getNombre());
        p.setString(2, s.getTelefono());
        p.setString(3, s.getDireccion());
        p.setInt(4, s.getId());
        
        p.executeUpdate();
        p.close();
           
        
    }
    
    public void delete(Suplidor s) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "DELETE FROM public.suplidores\n" +
                       " WHERE id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setInt(1, s.getId());
        System.out.print(p);
        p.executeUpdate();
        p.close();
    }
    
    public static ArrayList<Suplidor> select() 
            throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Suplidor> list = new ArrayList<>();
        String query = "SELECT id, name, telefono, direccion\n" +
                       "  FROM public.suplidores;";
        
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Suplidor s = new Suplidor();
            s.setId(rs.getInt("id"));
            s.setNombre(rs.getString("name"));
            s.setTelefono(rs.getString("telefono"));
            s.setDireccion(rs.getString("direccion"));
            
            
            list.add(s);
        }
        dbase.CerrarConexion();
        return list;
    }
    

    //This method can be better 
    public static Object get(int id,String columnName)
            throws SQLException{
        
        DB dbase = Utilities.getConection();
        Empleados emp = new Empleados();
        String query = "SELECT "+columnName+"\n" +
                    "  FROM public.suplidores WHERE id = "+id+";";
        ResultSet rs = dbase.execSelect(query);
        rs.next();
        return rs.getObject(1);
    }
    
    
}
