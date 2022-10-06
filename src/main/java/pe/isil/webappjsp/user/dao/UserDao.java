/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.isil.webappjsp.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import pe.isil.webappjsp.user.dao.mysql.MysqlConnection;
import pe.isil.webappjsp.user.model.User;

/**
 *
 * @author Guillermo Hurtado
 */
public class UserDao {
    //Aca va ir todo el codigo de acceso a datos
    
    public int registerUser(User user){
        try{
            
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
        
        }catch(Exception e){
           
            e.printStackTrace();
            return 0;
        }
    }
    
    
    
    
}
