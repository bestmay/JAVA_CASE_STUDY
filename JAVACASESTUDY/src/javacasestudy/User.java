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

    String permission;
    String username;
    
    public User() {
        while(true)
        {
            if(userLogin())
            {
                System.out.println("Welcome "+ username);
                break;
            }
            else{
                System.out.println("Username or Password incorrect");
            }
        }
      
    }

    public boolean userLogin() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/trng", "trng1", "trng1");
            Statement stmt = con.createStatement();
            System.out.println("Connected to Oracle DB");

            Scanner sn = new Scanner(System.in);
            System.out.println("Login ID:");
            String userID = sn.nextLine();
            System.out.println("Password:");
            String userPassword = sn.nextLine();
            PreparedStatement pstmt = con.prepareStatement("select username, permission_level from login_info WHERE username = ? and password = ?");

            pstmt.setString(1, userID);
            pstmt.setString(2, userPassword);
            pstmt.execute();
            ResultSet rset = pstmt.getResultSet();
            if (!rset.next()) {
                return false;
            } else {
                permission = rset.getString(2);
                username = rset.getString(1);
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
        
    }
}