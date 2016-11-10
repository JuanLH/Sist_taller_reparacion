/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entities;

import database.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import resouces.Utilities;

/**
 *
 * @author juanlht
 */
public class Articulos_Utilizados {
    int id_orden,id_articulo,cant;
    String nombre_articulo;

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
    
    /*=======================================================*/
    
    public static ArrayList<Articulos_Utilizados> select(int id_orden) 
            throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Articulos_Utilizados> list = new ArrayList<>();
        String query = "select au.id_orden,au.id_articulo,a.name,"+ 
        "au.cant from articulos_utilizados au\n" +
        "inner join ordenes o on au.id_orden = o.id\n" +
        "inner join articulos a on a.id = au.id_articulo\n" +
        "where o.id = "+id_orden+" ;";
        
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Articulos_Utilizados au = new Articulos_Utilizados();
            au.setId_orden(rs.getInt("au.id_orden"));
            au.setId_articulo(rs.getInt("au.id_articulo"));
            au.setNombre_articulo(rs.getString("a.name"));
            au.setId_cant(rs.getInt("au.cant"));
            
            
            list.add(au);
        }
        return list;
    }
    
}
