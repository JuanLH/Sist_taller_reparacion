/*
    Date: 20-10-2016
*/
package database.entities;

import database.DB;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import resouces.Utilities;

/**
 *
 * @author juanlht
 */
public class Empleados {
    static Empleados emp = new Empleados();
    private String cedula,name,lastname,address,phone;
    private Date entry_date;
    private int id_area,status;
    private float sueldo;

    public static Empleados getEmp() {
        return emp;
    }

    public static void setEmp(Empleados emp) {
        Empleados.emp = emp;
    }
  
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
 
    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    /*=======================================================================*/
    
    public void insert(Empleados emp) throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "INSERT INTO public.empleados(cedula, name, lastname,"
                + "id_area, sueldo, address, phone, entry_date,status)\n" 
                +" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setString(1, emp.getCedula());
        p.setString(2, emp.getName());
        p.setString(3, emp.getLastname());
        p.setInt(4, emp.getId_area());
        p.setFloat(5, emp.getSueldo());
        p.setString(6, emp.getAddress());
        p.setString(7, emp.getPhone());
        p.setDate(8, emp.getEntry_date());
        p.setInt(9, emp.getStatus());
        p.execute();
        p.close();
    }
    
    public void update(Empleados emp) throws SQLException {
        
            DB dbase = Utilities.getConection();
            String query= "UPDATE public.empleados\n" +
                    "   SET name=?, lastname=?, id_area=?,\n" +
                    "       sueldo=?, address=?, \n" +
                    "       phone=?, entry_date=?\n" +
                    "       WHERE cedula = ?";
            
            PreparedStatement p = DB.conexion.prepareStatement(query);
            p.setString(1, emp.getName());
            p.setString(2, emp.getLastname());
            p.setInt(3, emp.getId_area());
            p.setFloat(4, emp.getSueldo());
            p.setString(5, emp.getAddress());
            p.setString(6, emp.getPhone());
            p.setDate(7, emp.getEntry_date());
            p.setString(8, emp.getCedula());
            p.executeUpdate(); 
            //System.out.println(p);
            p.close();
        
    }
    
    public void delete(Empleados emp) throws SQLException{
        DB dbase = Utilities.getConection();
        String query= "UPDATE public.empleados SET  status=?\n" +
        " WHERE cedula = ?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setInt(1,1);//Status 0 = Available Status 1 = Disabled
        p.setString(2, emp.getCedula());
        p.executeUpdate(); 
        p.close();
    }
    
    public static ArrayList<Empleados> select(String condition) 
            throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Empleados> list = new ArrayList<>();
        String query = "SELECT cedula, name, lastname,\n" +
                        " id_area, sueldo, address,\n" +
                        " phone, entry_date, status\n" +
                        " FROM public.empleados \n" +
                        " WHERE status = 0 AND "+condition+";";
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Empleados e = new Empleados();
            e.setCedula(rs.getString("cedula"));
            e.setName(rs.getString("name"));
            e.setLastname(rs.getString("lastname"));
            e.setId_area(rs.getInt("id_area"));
            e.setSueldo(rs.getFloat("sueldo"));
            e.setAddress(rs.getString("address"));
            e.setPhone(rs.getString("phone"));
            e.setEntry_date(rs.getDate("entry_date"));
            e.setStatus(rs.getInt("status"));
            list.add(e);
        }
        dbase.CerrarConexion();
        return list;
    }
    
    public static ArrayList<Empleados> select() throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList<Empleados> list = new ArrayList<>();
        String query = "SELECT cedula, name, lastname,\n" +
                        " id_area, sueldo, address,\n" +
                        " phone, entry_date, status\n" +
                        " FROM public.empleados WHERE status = 0";
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Empleados e = new Empleados();
            e.setCedula(rs.getString("cedula"));
            e.setName(rs.getString("name"));
            e.setLastname(rs.getString("lastname"));
            e.setId_area(rs.getInt("id_area"));
            e.setSueldo(rs.getFloat("sueldo"));
            e.setAddress(rs.getString("address"));
            e.setPhone(rs.getString("phone"));
            e.setEntry_date(rs.getDate("entry_date"));
            e.setStatus(rs.getInt("status"));
            list.add(e);
        }
        dbase.CerrarConexion();
        return list;
    }
    
    public static Object get(String cedula,String columnName)
            throws SQLException{
        
        DB dbase = Utilities.getConection();
        Empleados emp = new Empleados();
        String query = "SELECT  "+columnName+" " +
                        " FROM public.empleados WHERE status = 0 " +
                        " and cedula = '"+cedula+"' ";
        ResultSet rs = dbase.execSelect(query);
        rs.next();
        return rs.getObject(1);
    }
    
  
}
