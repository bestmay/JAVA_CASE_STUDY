/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacasestudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author syntel
 */
public class User {

    private String permission;
    private String username;
    private String password;
    private int id;

    public User() {
        while (true) {
            if (userLogin()) {
                System.out.println("Welcome " + username);
                break;
            } else {
                System.out.println("Username or Password incorrect");
            }
        }

    }

    public boolean userLogin() {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/trng", "trng1", "trng1");
            Statement stmt = con.createStatement();
            System.out.println("Connected to Oracle DB");

            Scanner sn = new Scanner(System.in);
            System.out.println("Login ID:");
            String userID = sn.nextLine();
            System.out.println("Password:");
            String userPassword = sn.nextLine();
            PreparedStatement pstmt = con.prepareStatement("select username, permission_level,employee_id,password from login_info WHERE username = ? and password = ?");

            pstmt.setString(1, userID);
            pstmt.setString(2, userPassword);
            pstmt.execute();
            ResultSet rset = pstmt.getResultSet();
            if (!rset.next()) {
                return false;
            } else {
                permission = rset.getString(2);
                username = rset.getString(1);
                id=rset.getInt(3);
                password=rset.getString(4);
                con.close();
                return true;
            }

        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public String getPassword() {
        return password;
    }

    public String getPermission() {
        return permission;
    }

    public String getUsername() {
        return username;
    }
    public int getId(){
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}