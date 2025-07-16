/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalyearproject_pharmacymanagementsystem;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ABUO BERNARD
 */
public class DatabaseBackup {
    public static void backupDatabase(String dbName,String dbUserName,String dbPassword,String path){
        try {
           // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, dbUserName, dbPassword);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SHOW TABLES");
            
            FileWriter writer = new FileWriter(path);
            
            while(rs.next()){
                String tableName = rs.getString(1);
                ResultSet tableData = stmt.executeQuery("SELECT * FROM "+tableName);
                writer.write("CREATE TABLE " + tableName + "(\n");
                ResultSet tableStructure = stmt.executeQuery("DESCRIBE " +tableName);
                while(tableStructure.next()){
                    writer.write(tableStructure.getString(1)+ " " + tableStructure.getString(2) + ",\n");
                }
                writer.write(");\n");
                while(tableData.next()){
                    writer.write("INSERT INTO " + tableName + "VALUES (");
                    for(int i = 1; i <= tableData.getMetaData().getColumnCount(); i++){
                        writer.write("'" + tableData.getString(i) + "',");
                    }
                    writer.write(");\n");
                }
            }
            System.out.println("Backup created successfully");
            
        } catch (SQLException |IOException e) {
            System.out.println("Error creating backup " + e.getMessage());
        } 
    }
    public static void main(String[] args){
        backupDatabase("finalyearprojectdb", "root", "abuo", "C:/Users/ABUO BERNARD/Desktop/MySQL Backup/backup.sql");
    }
}
