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
public class Cliente {
    int id;
    String name,telefono,address,email;
    static Cliente cliente = new Cliente();

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        Cliente.cliente = cliente;
    }
    
    
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    /*=======================================================================*/
    
    public void insert(Cliente cli) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "INSERT INTO public.clientes(\n" +
        "             name, telefono, address, email)\n" +
        "    VALUES (?, ?, ?, ?);";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setString(1, cli.getName());
        p.setString(2, cli.getTelefono());
        p.setString(3, cli.getAddress());
        p.setString(4, cli.getEmail());
        p.execute();
        p.close();
    }
    
    
    public void update(Cliente cli)throws SQLException{
        DB dbase= Utilities.getConection();
        String query = "UPDATE public.clientes\n" +
        "   SET name=?, telefono=?, address=?, email=?\n" +
        " WHERE id=? ;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setString(1, cli.getName());
        p.setString(2, cli.getTelefono());
        p.setString(3, cli.getAddress());
        p.setString(4, cli.getEmail());
        p.setInt(5, cli.getId());
        p.executeUpdate();
        p.close();
        
        
    }
    
    public void delete(Cliente cli)throws SQLException{
        DB dbase= Utilities.getConection();
        String query = "UPDATE public.clientes\n" +
                    "   SET status=1\n" +
                    " WHERE id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setInt(1, cli.getId());
        p.executeUpdate();
        p.close();
        
        
    }
    
    public static ArrayList<Cliente> select() throws SQLException{
        DB dbase= Utilities.getConection();
        ArrayList<Cliente> list = new ArrayList<>();
        String query = "SELECT id, name, telefono, address, email\n" +
                        "  FROM public.clientes WHERE status = 0;";
        
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Cliente c = new Cliente();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setTelefono(rs.getString("telefono"));
            c.setAddress(rs.getString("address"));
            c.setEmail(rs.getString("email"));
            
            list.add(c);
        }
        dbase.CerrarConexion();
        return list;
    }
    
    public static ArrayList<Cliente> select(String condition) throws SQLException{
        DB dbase= Utilities.getConection();
        ArrayList<Cliente> list = new ArrayList<>();
        String query = "SELECT id, name, telefono, address, email\n" +
                        "  FROM public.clientes WHERE status = 0"
                        + " AND "+condition+" ;";
        
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Cliente c = new Cliente();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setTelefono(rs.getString("telefono"));
            c.setAddress(rs.getString("address"));
            c.setEmail(rs.getString("email"));
            
            list.add(c);
        }
        dbase.CerrarConexion();
        return list;
    }
    
    public static Object get(String columnName,int id)
            throws SQLException{
        
        DB dbase = Utilities.getConection();
        Cliente emp = new Cliente();
        String query = "SELECT  "+columnName+" " +
                        " FROM public.clientes WHERE status = 0 " +
                        " and id = "+id+" ";
        ResultSet rs = dbase.execSelect(query);
        rs.next();
        return rs.getObject(1);
    }
}
