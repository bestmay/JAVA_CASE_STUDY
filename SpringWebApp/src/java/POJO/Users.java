/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author syntel
 */
public class Users {
    String username;
    String password;
    String permission_level;
    double empId;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPermission_level() {
        return permission_level;
    }

    public double getEmpId() {
        return empId;
    }
    
    

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermission_level(String permission_level) {
        this.permission_level = permission_level;
    }

    public void setEmpId(double empId) {
        this.empId = empId;
    }
    
    
}
