/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaseStudy;

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
public class Employees {
    private String firstName;
    private String lastName;
    private double empId;
    private String band;
    private String grade;
    private String vertical;
    private String project;
    private String skills;
    private String org;

    public Employees() {
    }

    
    public Employees(String firstName, String lastName, double empId, String band, String grade, 
            String vertical, String project, String skills, String org) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.empId = empId;
        this.band = band;
        this.grade = grade;
        this.vertical = vertical;
        this.project = project;
        this.skills = skills;
        this.org = org;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
        
    public double getEmpId() {
        return empId;
    }

    public void setEmpId(double EmpId) {
        this.empId = EmpId;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }   
    
    public static void GenerateReport() throws SQLException{
        
        System.out.println("Input employee id to view:");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/CaseStudy", "altimarimj", "case");
        double id;
        Scanner kb = new Scanner(System.in);
        //Re-prompt user for valid id while an invalid id is entered.
        while(!kb.hasNextDouble()){
            System.out.println("Please input a valid id to view:");
        }
        id=kb.nextDouble();
        //Create a statemement connect and prepared statement for execution 
        Statement stmt=con.createStatement();
        PreparedStatement pstmt = con.prepareStatement("Select * From Employees E Where E.EmpId=?;");
        pstmt.setDouble(1,id);
        pstmt.execute();
        ResultSet rset = pstmt.getResultSet();
        
        id=rset.getDouble("Employee_id");
        String name = rset.getString("First_Name");
        name += rset.getString("Last_Name");
        String band = rset.getString("Band");
        String grade = rset.getString("Grade");
        String vertical = rset.getString("Verticle");
        String project = rset.getString("Project");
        String skills = rset.getString("Skills"); 
        String org = rset.getString("Org");
        
        System.out.println("Name: " + name + "\n" +
                "Emp ID: " + id + "\n" +
                "Band: " + band + "\n" +
                "Grade: " + grade + "\n" +
                "Vertical: " + vertical + "\n" +
                "Project: " + project + "\n" +
                "Skills: " + skills + "\n" +
                "Organization: " + org);
        
       Employees e = new Employees();
       e.setFirstName(rset.getString("First_Name"));
       e.setLastName(rset.getString("Last_Name"));
       e.setEmpId(id);
       e.setBand(band);
       e.setGrade(grade);
       e.setVertical(vertical);
       e.setProject(project);
       e.setSkills(skills);
       e.setOrg(org);
        
//        Connection con;
//        Statement stmt;
//        PreparedStatement ps;
//        
//        try {
//            // Step 1: Register the driver with the proper path name
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Exception with driver: " + ex.getMessage());
//        }
//        
//        try{
//            // Step 2: Establish the connection to the database
//            con = DriverManager.getConnection("jdbc:derby://localhost:1527/CaseStudy","altimarimj","case");
//            // Step 3: Get the statement
//            stmt = con.createStatement();
//            
//            // Step 4: Compare the results
//            ps = con.prepareStatement("select * from emloyees where employee_id = ?");
//            ps.setInt(1, 5037066);                      
//            ps.execute();
//            
//            ps.close();
//            stmt.close();
//            con.close();
//        }catch(SQLException ex){
//            System.out.println("SQL Exception: " + ex.getMessage());
//            ex.printStackTrace();
//        }
    }
   
    public static void main(String[] args) {                 
        try{
            GenerateReport();
        }catch(Exception e){
            System.out.println(e);
        }                           
    }
}
