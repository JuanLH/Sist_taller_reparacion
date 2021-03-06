/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entities;

import database.DB;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import resouces.Utilities;

/**
 *
 * @author juanlht
 */
public class Trans {
    
    int id,id_tipo_trans,id_area,cantidad;
    Double valor,total;
    String ref_tran,id_resource;
    Timestamp fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_tipo_trans() {
        return id_tipo_trans;
    }

    public void setId_tipo_trans(int id_tipo_trans) {
        this.id_tipo_trans = id_tipo_trans;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getRef_tran() {
        return ref_tran;
    }

    public void setRef_tran(String ref_tran) {
        this.ref_tran = ref_tran;
    }

    public String getId_resource() {
        return id_resource;
    }

    public void setId_resource(String id_resource) {
        this.id_resource = id_resource;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    
    /*======================================================================*/
    
    
    public void insert(Trans t) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "INSERT INTO public.trans(id_tipo_trans, id_area, \n" +
                        "cantidad, valor, total, ref_tran,id_resource)\n" +
                        "    VALUES (?, ?, ?, ?, ?, ?, ?);";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setInt(1, t.getId_tipo_trans());
        p.setInt(2, t.getId_area());
        p.setInt(3, t.getCantidad());
        p.setDouble(4, t.getValor());
        p.setDouble(5, t.getTotal());
        p.setString(6, t.getRef_tran());
        p.setString(7, t.getId_resource());
        
        p.execute();
        p.close();
    }
    
    
    
    
    
    public void update(Empleados emp) throws SQLException {
        
           
        
    }
    
    public void delete(Empleados emp) throws SQLException{
        
    }
    
    public static ArrayList<Trans> select() 
            throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Trans> list = new ArrayList<>();
        String query = "SELECT id, id_area, fecha, total, \n" +
                "ref_tran, id_resource FROM public.trans \n" +
                "WHERE id_tipo_trans = 2;";
        
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Trans t = new Trans();
            t.setId(rs.getInt("id"));
            t.setId_area(rs.getInt("id_area"));
            t.setFecha(rs.getTimestamp("fecha"));
            t.setTotal(rs.getDouble("total"));
            t.setRef_tran(rs.getString("ref_tran"));
            t.setId_resource(rs.getString("id_resource"));
            
            list.add(t);
        }
        dbase.CerrarConexion();
        return list;
    }
    
    public static ArrayList<Trans> select(int id_orden) 
            throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Trans> list = new ArrayList<>();
        String query = "SELECT id,id_tipo_trans, id_area, \n" +
        "fecha, cantidad, valor, \n" +
        "total, ref_tran,id_resource\n" +
        "  FROM public.trans \n" +
        "  WHERE id_tipo_trans in (4,3) \n" +
        "  and id_resource = '"+id_orden+"';";
        
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Trans t = new Trans();
            t.setId(rs.getInt("id"));
            t.setId_tipo_trans(rs.getInt("id_tipo_trans"));
            t.setId_area(rs.getInt("id_area"));
            t.setFecha(rs.getTimestamp("fecha"));
            t.setCantidad(rs.getInt("cantidad"));
            t.setValor(rs.getDouble("valor"));
            t.setTotal(rs.getDouble("total"));
            t.setRef_tran(rs.getString("ref_tran"));
            t.setId_resource(rs.getString("id_resource"));
            
            list.add(t);
        }
        dbase.CerrarConexion();
        return list;
    }
    
    public static ArrayList<Trans> getGastos(Date d1,Date d2) 
            throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Trans> list = new ArrayList<>();
        String query = "SELECT id, id_tipo_trans, id_area, fecha, cantidad, "+
            "valor, total, ref_tran, \n" +
            "       id_resource\n" +
            "  FROM public.trans\n" +
            "  where id_tipo_trans in (1,2) \n" +
            "  and fecha  >= '"+d1.toString()+"' and  fecha <= '"+d2.toString()+"'";
        
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Trans t = new Trans();
            t.setId(rs.getInt("id"));
            t.setId_tipo_trans(rs.getInt("id_tipo_trans"));
            t.setId_area(rs.getInt("id_area"));
            t.setFecha(rs.getTimestamp("fecha"));
            t.setCantidad(rs.getInt("cantidad"));
            t.setValor(rs.getDouble("valor"));
            t.setTotal(rs.getDouble("total"));
            t.setRef_tran(rs.getString("ref_tran"));
            t.setId_resource(rs.getString("id_resource"));
            
            list.add(t);
        }
        dbase.CerrarConexion();
        return list;
    }
    
    public static ArrayList<Trans> getGastos() 
            throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Trans> list = new ArrayList<>();
        String query = "SELECT id, id_tipo_trans, id_area, fecha, cantidad, "+
            "valor, total, ref_tran, \n" +
            "       id_resource\n" +
            "  FROM public.trans\n" +
            "  where id_tipo_trans in (1,2) "; 
        
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Trans t = new Trans();
            t.setId(rs.getInt("id"));
            t.setId_tipo_trans(rs.getInt("id_tipo_trans"));
            t.setId_area(rs.getInt("id_area"));
            t.setFecha(rs.getTimestamp("fecha"));
            t.setCantidad(rs.getInt("cantidad"));
            t.setValor(rs.getDouble("valor"));
            t.setTotal(rs.getDouble("total"));
            t.setRef_tran(rs.getString("ref_tran"));
            t.setId_resource(rs.getString("id_resource"));
            
            list.add(t);
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
