package signupformbyshubham;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
   static final String DB_URL = "jdbc:mysql://localhost:3306/signupform";
   static final String USER = "root";
   static final String PASS = "Shubh@252525";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         // Execute a query
         System.out.println("Inserting records into the table...");          
         String sql = "INSERT INTO registration VALUES (100, 'Zara', 'Ali', 18)";
         stmt.executeUpdate(sql);
         sql = "INSERT INTO registration VALUES (101, 'Mahnaz', 'Fatma', 25)";
         stmt.executeUpdate(sql);
         int num1=72;
         sql = "INSERT INTO registration VALUES ('"+num1+"', 'Zaid', 'Khan', 30)";
         stmt.executeUpdate(sql);
         sql = "INSERT INTO registration VALUES(103, 'Sumit', 'Mittal', 28)";
         stmt.executeUpdate(sql);
         System.out.println("Inserted records into the table...");   	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}