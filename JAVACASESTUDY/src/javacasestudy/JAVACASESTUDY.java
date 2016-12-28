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
public class JAVACASESTUDY {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        userLogin();
    }

    public static void userLogin() {
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
            PreparedStatement pstmt = con.prepareStatement("select username from login_info WHERE username = ? and password = ?");
            
            pstmt.setString(1,userID);
            pstmt.setString(2,userPassword);
            pstmt.execute();
            ResultSet rset = pstmt.getResultSet();
            if (!rset.next()) {
                System.out.println("User Not Found");
                userLogin();
            }
            else
            {
                System.out.println(rset.getString(1));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
