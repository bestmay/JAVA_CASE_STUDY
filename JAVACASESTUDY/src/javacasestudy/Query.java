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

    public static void editEmployee(User user1) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/trng", "trng1", "trng1");
        PreparedStatement pstmt = con.prepareStatement("Select * From Employees Where pending_approval=true");
        Scanner sn = new Scanner(System.in);
        pstmt.execute();
        ResultSet rset = pstmt.getResultSet();
        if (user1.getPermission().equals("admn")) {
            System.out.println("The following changes require approval");
            while (rset.next()) {
                Employees emp = new Employees(rset);
                System.out.println(emp);
                System.out.println("Keep Changes? (y/n)");
                if(sn.nextLine().equals("y")){
                    pstmt = con.prepareStatement("update Employees set pending_approval=false where employee_id=?");
                    pstmt.setDouble(1, emp.getEmpId());
                }
                
            }
            System.out.println("No pending approvals.");
        }
        System.out.println("Enter Employee ID to be Edited:");
        
        double empID = Double.parseDouble(sn.nextLine());

        pstmt = con.prepareStatement("Select * From Employees Where Employee_Id=?");
        pstmt.setDouble(1, empID);
        pstmt.execute();
        rset = pstmt.getResultSet();

        if (!rset.next()) {
            System.out.println("Query Failed");
        } else {
            Employees e = new Employees(rset);
            System.out.println("Current first name: " + e.getFirstName());
            System.out.print("New first name: ");
            e.setFirstName(sn.nextLine());
            System.out.println("Current last name: " + e.getLastName());
            System.out.print("New last name: ");
            e.setLastName(sn.nextLine());
            System.out.println("Current band: " + e.getBand());
            System.out.print("New band: ");
            e.setBand(sn.nextLine());
            System.out.println("Current grade: " + e.getGrade());
            System.out.print("New grade: ");
            e.setGrade(sn.nextLine());
            System.out.println("Current vertical: " + e.getVertical());
            System.out.print("New vertical: ");
            e.setVertical(sn.nextLine());
            System.out.println("Current project: " + e.getProject());
            System.out.print("New project: ");
            e.setProject(sn.nextLine());
            System.out.println("Current skills: " + e.getSkills());
            System.out.print("New skills: ");
            e.setSkills(sn.nextLine());
            System.out.println("Current organization: " + e.getOrg());
            System.out.print("New organization: ");
            e.setOrg(sn.nextLine());

            if(user1.getPermission().equals("admn"))
            {
            pstmt = con.prepareStatement("update Employees set first_name=?,last_name=?,"
                    + "verticle=?,project=?,skills=?,grade=?,band=?, organization=?"
                    + "Where employee_id=?");
            }
            else{
                pstmt = con.prepareStatement("update Employees set first_name=?,last_name=?,"
                    + "verticle=?,project=?,skills=?,grade=?,band=?,pending_approval=true, organization=?"
                    + "Where employee_id = ?");
            }
            pstmt.setString(1, e.getFirstName());
            pstmt.setString(2, e.getLastName());
            pstmt.setString(3, e.getVertical());
            pstmt.setString(4, e.getProject());
            pstmt.setString(5, e.getSkills());
            pstmt.setString(6, e.getGrade());
            pstmt.setString(7, e.getBand());
            pstmt.setString(8, e.getOrg());
            pstmt.setDouble(9, empID);
            pstmt.execute();
            rset = pstmt.getResultSet();

            System.out.println("Employee Edited!");
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
        Scanner sn = new Scanner(System.in);
        //Re-prompt user for valid id while an invalid id is entered.        
        org = sn.nextLine();
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

        System.out.println("Would you like to download the report as a pdf? (y/n)");

        String ans = sn.nextLine();
        if (ans.toLowerCase().equals("y")) {
            try {
                Documents.printPDF(emps);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("returning to menu...");
        }

    }

}
