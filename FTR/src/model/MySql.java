/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author cnn
 */
public class MySql {
    
    private static Connection connection;
    
    public static void createConnection() throws Exception{
    
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasttrack_logistics","root","Jester890@#");
        }                          
    }
    
    
     public static ResultSet executeSearch(String query) throws Exception{
        
         createConnection();
         return connection.createStatement().executeQuery(query);
         
        }
     public static Integer executeIUD(String query) throws Exception{
        
         createConnection();
         return connection.createStatement().executeUpdate(query);
         
        }
    
}