/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject_pharmacymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ABUO BERNARD
 */
public class Database {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalyearprojectdb","root","abuo");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
