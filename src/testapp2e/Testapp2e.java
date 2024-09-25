
package testapp2e;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Testapp2e {


public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); 
            con = DriverManager.getConnection("jdbc:sqlite:sample.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }

    public static void main(String[] args) {
        connectDB();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("First Name: ");
        String fname = sc.nextLine();
        System.out.println("Last Name: ");
        String lname = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Status");
        String status = sc.next();
        
        String sql = "INSERT INTO Students (s_fname, s_lname, s_email, s_status) VALUES (?, ?, ?, ?)";
        
        try{
            Connection con = connectDB();
            PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, fname);
                pst.setString(2, lname);
                pst.setString(3, email);
                pst.setString(4, status);
                pst.executeUpdate();
            System.out.println("Successfully Inserted");
            
        }catch(SQLException ex){
            System.out.println("Connection Error: "+ex.getMessage());
            
        };
   
    }
    
}
