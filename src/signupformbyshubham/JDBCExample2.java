package signupformbyshubham;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample2 {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/signupform";
	   static final String USER = "root";
	   static final String PASS = "Shubh@252525";

 //  static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
  // static final String USER = "guest";
   //static final String PASS = "guest123";
   static final String QUERY = "SELECT firstname, lastname FROM signup";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);
    		 
      ) {		      
         while(rs.next()){
            //Display values
           // System.out.print("ID: " + rs.getInt("id"));
           // System.out.print(", Age: " + rs.getInt("age"));
            System.out.print(" First: " + rs.getString("firstname"));
            System.out.println(" Last: " + rs.getString("lastname"));
         }
         String query = "UPDATE signup " + "SET firstname=\"harsh\" WHERE id=5";
         stmt.executeUpdate(query);
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}
