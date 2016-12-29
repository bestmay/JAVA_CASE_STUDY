package javacasestudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    public static void addEmployee() {
        Employees e = new Employees();
        Scanner kb = new Scanner(System.in);
        System.out.println("Please input new employee's first name:");
        e.setFirstName(kb.nextLine());
        System.out.println("Please input new employee's last name:");
        e.setLastName(kb.nextLine());
        System.out.println("Please input new employee's id:");
        e.setEmpId(Double.parseDouble(kb.nextLine()));
        System.out.println("Please input new employee's band:");
        e.setBand(kb.nextLine());
        System.out.println("Please input new employee's grade:");
        e.setGrade(kb.nextLine());
        System.out.println("Please input new employee's vertical:");
        e.setVertical(kb.nextLine());
        System.out.println("Please input new employee's project:");
        e.setProject(kb.nextLine());
        System.out.println("Please input new employee's skills:");
        e.setSkills(kb.nextLine());
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/trng", "trng1", "trng1");
            Statement stmt = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Employees VALUES(?,?,?,?,?,?,?,?)");
            pstmt.setDouble(1, e.getEmpId());
            pstmt.setString(2, e.getFirstName());
            pstmt.setString(3, e.getLastName());
            pstmt.setString(4, e.getVertical());
            pstmt.setString(5, e.getProject());
            pstmt.setString(6, e.getSkills());
            pstmt.setString(7, e.getGrade());
            pstmt.setString(8, e.getBand());
            pstmt.execute();
            ResultSet rset = pstmt.getResultSet();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void editEmployee() {
        System.out.println("Enter Employee ID to be Edited:");
        Scanner sn = new Scanner(System.in);
        double empID = sn.nextDouble();

        try {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void removeEmployee() throws SQLException {
        Scanner kb = new Scanner(System.in);
        double id;
        System.out.println("Please enter employee id to remove:");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/trng", "trng1", "trng1");
        Statement stmt = con.createStatement();
        id = kb.nextDouble();
        PreparedStatement pstmt = con.prepareStatement("DELETE From Employees Where Employee_Id=?");
        pstmt.setDouble(1, id);
        pstmt.execute();
        System.out.println("Employee " + id + " Deleted");
    }

    public static void generateReport() throws SQLException {
        ArrayList<Employees> emps = new ArrayList();
        System.out.println("Input orgnization name to view:");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/trng", "trng1", "trng1");
        String org;
        Scanner kb = new Scanner(System.in);
        //Re-prompt user for valid id while an invalid id is entered.        
        org = kb.nextLine();
        //Create a statemement connect and prepared statement for execution 
        Statement stmt = con.createStatement();
        PreparedStatement pstmt = con.prepareStatement("Select * From Employees Where organization=?");
        pstmt.setString(1, org);
        pstmt.execute();
        ResultSet rset = pstmt.getResultSet();

        while (rset.next()) {
            Employees emp = new Employees(rset);
            System.out.println(emp);
            emps.add(emp);
        }
        
       
    }

}
