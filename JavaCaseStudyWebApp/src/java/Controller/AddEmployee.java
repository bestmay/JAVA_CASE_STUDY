package Controller;

import DAO.EmpDAO;
import POJO.Employees;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


public class AddEmployee extends SimpleFormController{
    private String firstName;
    private String lastName;
    private double empId;
    private String band;
    private String grade;
    private String vertical;
    private String project;
    private String skills;
    private String org;
    
    

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getEmpId() {
        return empId;
    }

    public String getBand() {
        return band;
    }

    public String getGrade() {
        return grade;
    }

    public String getVertical() {
        return vertical;
    }

    public String getProject() {
        return project;
    }

    public String getSkills() {
        return skills;
    }

    public String getOrg() {
        return org;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmpId(double empId) {
        this.empId = empId;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setOrg(String org) {
        this.org = org;
    }
    
    
}
