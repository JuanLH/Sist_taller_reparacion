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
public class Usuario {
    static Usuario user = new Usuario();
    int id_tipo;
    String id,usuario,pass;

    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario user) {
        Usuario.user = user;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public boolean isType(int type)throws SQLException{
        return true;
    }
    
    public void insert(Usuario u)throws SQLException{
        DB dbase = Utilities.getConection();
        String query ="INSERT INTO public.usuarios(\n" +
                    "    id, usuario, pass, id_tipo)\n" +
                    "    VALUES (?, ?, ?, ?);";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setString(1, u.getId());
        p.setString(2, u.getUsuario());
        p.setString(3, u.getPass());
        p.setInt(4, u.getId_tipo());
        p.execute();
        p.close();
    }
    
    public void update(Usuario u)throws SQLException{
        DB dbase = Utilities.getConection();
        String query = "UPDATE public.usuarios\n" +
                "   SET  usuario=?, pass=?, id_tipo=?\n" +
                " WHERE id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setString(1, u.getUsuario());
        p.setString(2, u.getPass());
        p.setInt(3, u.getId_tipo());
        p.setString(4, u.getId()); 
        p.executeUpdate();
        p.close();
    }
    
    public  void delete(Usuario u)throws SQLException{
        String query = "UPDATE public.usuarios\n" +
            "   SET  status=1 \n" +
            "   WHERE id=?;";
        
        PreparedStatement p = DB.conexion.prepareStatement(query);
        p.setString(1, u.getId());
        p.executeUpdate();
        p.close();
    }
    
    public static ArrayList<Usuario> select() throws SQLException{
        DB dbase = Utilities.getConection();
        ArrayList list = new ArrayList<Usuario>();
        String query = "SELECT id, usuario, pass, id_tipo\n" +
            "  FROM public.usuarios WHERE status = 0;";
        ResultSet rs = dbase.execSelect(query);
        while(rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getString("id"));
            u.setUsuario(rs.getString("usuario"));
            u.setPass(rs.getString("pass"));
            u.setId_tipo(rs.getInt("id_tipo"));
            list.add(u);
        }
        dbase.CerrarConexion();
        return list;
    }
    
    
    
}
