package signupformbyshubham;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
   static final String DB_URL = "jdbc:mysql://localhost:3306/signupform";
   static final String USER = "root";
   static final String PASS = "Shubh@252525";

   public static com.sun.jdi.connect.spi.Connection dbconnect() {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         // Execute a query
         System.out.println("Inserting records into the table...");          
         
         
         	  
      } catch (SQLException e) {
         e.printStackTrace();
      }
	return null; 
   }
}