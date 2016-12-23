/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaseStudy;

import java.util.Scanner;
/**
 *
 * @author syntel
 */
public class Employees {
    private String name;
    private double EmpId;
    private String band;
    private String grade;
    private String vertical;
    private String project;
    private String skills;
    private String org;

    public Employees(String name, double EmpId, String band, String grade, 
            String vertical, String project, String skills, String org) {
        this.name = name;
        this.EmpId = EmpId;
        this.band = band;
        this.grade = grade;
        this.vertical = vertical;
        this.project = project;
        this.skills = skills;
        this.org = org;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEmpId() {
        return EmpId;
    }

    public void setEmpId(long EmpId) {
        this.EmpId = EmpId;
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
    
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        
        System.out.println("Name");
        name = in.nextLine();
        
        System.out.println("Employee ID");
        
        System.out.println("Band");
        
        System.out.println("Grade");
        
        System.out.println("Vertical");
        
        System.out.println("Project");
        
        System.out.println("Skills");
        
        System.out.println("Organization");
        */
    }
}
