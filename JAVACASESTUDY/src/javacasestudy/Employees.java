/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacasestudy;

import java.sql.ResultSet;

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

    public Employees(String firstName, String lastName, double EmpId, String band, String grade,
            String vertical, String project, String skills, String org) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.empId = EmpId;
        this.band = band;
        this.grade = grade;
        this.vertical = vertical;
        this.project = project;
        this.skills = skills;
        this.org = org;
    }

    public Employees(ResultSet rset) {
        try {
            this.empId = rset.getDouble(1);
            this.firstName = rset.getString(2);
            this.lastName = rset.getString(3);
            this.vertical = rset.getString(4);
            this.project = rset.getString(5);
            this.skills = rset.getString(6);
            this.grade = rset.getString(7);
            this.band = rset.getString(8);
            this.org = rset.getString(10);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public Employees()
    {
        
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public double getEmpId() {
        return empId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "  Employee Id: " + (int)empId + "  band: " + band + "  grade: " + grade + "  vertical: " + vertical + "  project: " + project + "  skills: " + skills + "  org: " + org;
    }

}
