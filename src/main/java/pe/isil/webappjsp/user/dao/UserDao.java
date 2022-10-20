/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.isil.webappjsp.user.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.isil.webappjsp.user.dao.mysql.MysqlConnection;
import pe.isil.webappjsp.user.model.User;

/**
 *
 * @author Guillermo Hurtado
 */
public class UserDao {
    //Aca va ir todo el codigo de acceso a datos
    
    public int registerUser(User user) throws Exception {
            
            MysqlConnection mysqConn = new MysqlConnection();
            Connection conn = mysqConn.getConnection();
            int rowsAffected=0;
            
            
            String queryInsert = "INSERT INTO USERS (name,lastname,username,pass,tipDoc,nroDoc,enable,email) "
                    + "VALUES (?,?,?,?,?,?,?,?)";
            
            
            PreparedStatement ps = conn.prepareStatement(queryInsert);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPass());
            ps.setString(5, user.getTipDoc());
            ps.setString(6, user.getNroDoc());
            ps.setInt(7, user.getEnable());
            ps.setString(8, user.getEmail());
            
            rowsAffected = ps.executeUpdate();
            return rowsAffected;
        
    }
    
    public String updateUser(User user) throws Exception{
        
        String message = "";
        MysqlConnection mysqConn = new MysqlConnection();
        Connection conn = mysqConn.getConnection();
        int rowsAffected=0;
        int count=0;
        
        //Primero evaluamos si el usuario existe
        
        PreparedStatement ps = conn.prepareStatement("select * from users where nroDoc = ?");
        ps.setString(1, user.getNroDoc());
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            count++;
        }
        if (count > 0){
            
            String queryUpdate = "update users set name=?, lastname=?, username=?, pass=?, enable=?, email=? where nroDoc=?";
            
            PreparedStatement psUpdate = conn.prepareStatement(queryUpdate);
            psUpdate.setString(1, user.getName());
            psUpdate.setString(2, user.getLastname());
            psUpdate.setString(3, user.getUsername());
            psUpdate.setString(4, user.getPass());
            psUpdate.setInt(5, user.getEnable());
            psUpdate.setString(6, user.getEmail());
            psUpdate.setString(7, user.getNroDoc());
            rowsAffected = psUpdate.executeUpdate();
            
            if(rowsAffected>0){
                message = "Se actualizo el usuario satisfactoriamente";
                
            }else{
                message = "Ocurrio un error";
            }
            
        }else{
            message = "User no existe";
        }
        
        return message;
            
            
    }
    
    public String deleteUser(User user) throws Exception{
        
        
        String message = "";
        MysqlConnection mysqConn = new MysqlConnection();
        Connection conn = mysqConn.getConnection();
        int rowsAffected=0;
        int count=0;
        
        //Primero evaluamos si el usuario existe
        
        PreparedStatement ps = conn.prepareStatement("select * from users where nroDoc = ?");
        ps.setString(1, user.getNroDoc());
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            count++;
        }
        if (count > 0){
            
            CallableStatement cb = conn.prepareCall("{call deleteusers(?)}");
            cb.setString(1, user.getNroDoc());
            rowsAffected = cb.executeUpdate();

            
            if(rowsAffected>0){
                message = "Se elimino el usuario satisfactoriamente";
                
            }else{
                message = "Ocurrio un error";
            }
            
        }else{
            message = "El usuario no existe";
        }
        
        return message;
        
        
            
            
    }
}
