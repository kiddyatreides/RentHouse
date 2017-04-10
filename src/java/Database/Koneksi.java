/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kid
 */
public class Koneksi {
 public static void main(String[] args){
         try
        {
            
                    
            
            System.out.println("Object is registered.");
            System.out.println("Now server is waiting for client request...");
        }
        catch(Exception e)
        {
            System.out.println("FileServer: " + e);
        }
    }
    
    public Connection getConnection()
    {
        Connection con;
        try
        {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url = "jdbc:sqlserver://localhost\\DHANA;databaseName=RentHouse";
           con = DriverManager.getConnection(url, "sa", "123456");
           System.out.println("Server is Connected");
           return con;
           
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println(e);
            return null;
        }
                
    }   
}
