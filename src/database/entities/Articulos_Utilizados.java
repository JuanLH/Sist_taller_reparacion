/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entities;

import database.DB;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import resouces.Mensajes;
import resouces.Utilities;

/**
 *
 * @author juanlht
 */
public class Articulos_Utilizados {
    int id_orden,id_articulo,cant;
    String nombre_articulo;
    Double cost;
    Double total;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
    
    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public int getCant() {
        return cant;
    }

    public void setId_cant(int cant) {
        this.cant = cant;
    }

    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }
    
    @Override
    public boolean equals(Object obj){
        Articulos_Utilizados au = null;
        if(obj instanceof Articulos_Utilizados){
            au = (Articulos_Utilizados)obj;
            if(this.getId_articulo() == au.getId_articulo()
                && this.getId_orden() == au.getId_orden())
            return true;
        }
        
        return false;
            
        
        
    }
    
    /*=======================================================*/
    
    public void insert(Articulos_Utilizados au)throws SQLException{
        int existencia  = (int)Articulo.get(au.getId_articulo(), "existencia");
        
        Articulo art = new Articulo();
        
        if(existencia>au.getCant()){
            art.update(au.getId_articulo(), existencia-au.getCant());
            DB dbase = Utilities.getConection();
            String query = "INSERT INTO public.articulos_utilizados(\n" +
                        "            id_orden, id_articulo, cant)\n" +
                        "    VALUES (?, ?, ?);";
            PreparedStatement p = DB.conexion.prepareStatement(query);

            p.setInt(1, au.getId_orden());
            p.setInt(2, au.getId_articulo());
            p.setInt(3, au.getCant());

            p.execute();  
            p.close();
        }
        else{
            Mensajes.mensajeInfo(new ActionEvent
            (this, 1, "cantidad no es suficiente"), 
                    "LA CANTIDAD DE EXISTENCIA NO ES SUFICIENTE");
        }
        
    }
    
    public static void update(Articulos_Utilizados au)throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "UPDATE public.articulos_utilizados\n" +
                        "   SET  cant=?\n" +
                        " WHERE id_orden=? and id_articulo=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        
        p.setInt(1, au.getId_orden());
        p.setInt(2, au.getId_articulo());
        p.setInt(3, au.getCant());
        
      
        p.executeUpdate();
        p.close();
    }
    
    public static void delete(Articulos_Utilizados au)throws SQLException{
        DB dbase = Utilities.getConection();
        
        int existencia  = (int)Articulo.get(au.getId_articulo(), "existencia");
        
        Articulo art = new Articulo();
        System.out.println(existencia+"   --   "+au.getCant());
        art.update(au.getId_articulo(), (existencia + au.getCant()));
        
        String query = "DELETE FROM public.articulos_utilizados\n" +
                            " WHERE id_orden=? and id_articulo=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        
        p.setInt(1, au.getId_orden());
        p.setInt(2, au.getId_articulo());
      
        p.executeUpdate();
        p.close();
    }
    
    
    public static ArrayList<Articulos_Utilizados> select(int id_orden) 
            throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Articulos_Utilizados> list = new ArrayList<>();
        String query = "select au.id_orden,au.id_articulo,a.name,"+ 
        "au.cant,a.cost from articulos_utilizados au\n" +
        "inner join ordenes o on au.id_orden = o.id\n" +
        "inner join articulos a on a.id = au.id_articulo\n" +
        "where o.id = "+id_orden+" ;";
        
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Articulos_Utilizados au = new Articulos_Utilizados();
            au.setId_orden(rs.getInt("id_orden"));
            au.setId_articulo(rs.getInt("id_articulo"));
            au.setNombre_articulo(rs.getString("name"));
            au.setId_cant(rs.getInt("cant"));
            au.setCost(rs.getDouble("cost"));
            
            
            list.add(au);
        }
        return list;
    }
    
}
