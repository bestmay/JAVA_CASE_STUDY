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
        User user1 = new User();
        boolean cont = true;

        while (cont) {
            if (user1.getPermission().equals("user")) {
                System.out.println("Type what would you like to do:");
                System.out.println("VIEW | EDIT | QUIT");
            } else {
                System.out.println("Type what would you like to do:");
                System.out.println("ADD | VIEW | REMOVE | EDIT | REPORT | QUIT");
            }
            Scanner sn = new Scanner(System.in);
            String ans = sn.nextLine();
            try {
                switch (ans.toUpperCase()) {
                    case "ADD":
                        Query.addEmployee();
                        break;
                    case "VIEW":
                        Query.viewEmployee(user1);
                        break;
                    case "EDIT":
                        Query.editEmployee(user1);
                        break;
                    case "REMOVE":
                        Query.removeEmployee();
                        break;
                    case "REPORT":
                        Query.generateReport();
                        break;
                    case "QUIT":
                        cont = false;
                        break;
                    default:
                        System.out.println("Command" + ans.toUpperCase() + " not found.");
                        break;

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
