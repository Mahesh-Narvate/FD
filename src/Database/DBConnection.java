/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author prashant
 */
public class DBConnection {
     public Connection dbConnection() 
    {
       
        Connection con = null ;

        try 
        {
            Class.forName("com.mysql.jdbc.Driver");//loading driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud1","root", "root");//establishing connection
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return con;
        
    }
    
     
     public static void main(String[] args) {
         System.out.println("main ");
    }
}
