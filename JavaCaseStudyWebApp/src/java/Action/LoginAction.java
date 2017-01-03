package Action;

import DAO.EmpDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author syntel
 */
public class LoginAction extends ActionSupport {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String run() {
        return "Success";
    }
    
    public void validate(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpDAO empDAO=(EmpDAO)ctx.getBean("EmpDAO");
        if(!empDAO.loginCheck(username, password))
        {
            addActionError("Username or password was incorrect.");
        }
        
    }

}
