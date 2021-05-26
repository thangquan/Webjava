/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectSQL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author thangquan
 */
public class connectSQL {

     public static Connection getConnection()throws Exception {
        String url = "jdbc:jtds:sqlserver://THANG/WebBanHang";
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        return DriverManager.getConnection(url);
    }   
  public static void main(String[] args) {
        try {
            System.out.println("GG");
            System.out.println(new connectSQL().getConnection());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
