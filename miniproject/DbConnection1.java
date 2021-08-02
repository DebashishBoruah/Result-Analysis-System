/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;
import java.sql.*;
public class DbConnection1 {
 Connection conn=null;  
  
 public static Connection ConnectDb()
 {
     try
     {
         Class.forName("com.mysql.jdbc.Driver");
         String db_url="jdbc:mysql://localhost:3306/javaproject";
         Connection conn=DriverManager.getConnection(db_url,"root","");
         System.out.println(conn);
         return conn;
         
     }
     catch(ClassNotFoundException | SQLException e)
     {
         System.out.println(e);
         return null;
     }
 }
}

