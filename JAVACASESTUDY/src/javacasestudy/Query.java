package javacasestudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author syntel
 */
public class Query {

    public static void viewEmployee() throws SQLException {
        
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/trng", "trng1", "trng1");
        System.out.println("Input employee id to view:");
        double id;
        Scanner kb = new Scanner(System.in);
        //Re-prompt user for valid id while an invalid id is entered.
        id = kb.nextDouble();
        //Create a statemement connect and prepared statement for execution 
        Statement stmt = con.createStatement();
        PreparedStatement pstmt = con.prepareStatement("Select * From Employees Where Employee_Id=?");
        pstmt.setDouble(1, id);
        pstmt.execute();
        ResultSet rset = pstmt.getResultSet();
        if (!rset.next()) {
            System.out.println("Query Failed");
        } else {
            Employees emp = new Employees(rset);
            System.out.println(emp);
        }
    }

    private static void addEmployee() {

    }
}
