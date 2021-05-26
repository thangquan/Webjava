/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectSQL.connectSQL;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class LoginDAO {

    Connection conn = null;
    //Chuyển câu lệnh từ netbean sang sql server
    PreparedStatement ps = null;
    ResultSet rs = null;// Nhận kết quả trả về
    
    public Account checkLogin(String user, String pass) {
        try {
            
            String query = "select * from Account where userName = ? and Password = ? ";
            conn = new connectSQL().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            System.out.println(rs);
            while(rs.next()){
                Account a  = new Account(rs.getString(2),rs.getString(3),rs.getInt(4));
                System.out.println(a);
                return a;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

    }
}
