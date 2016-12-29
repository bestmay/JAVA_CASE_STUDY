<<<<<<< HEAD:Employees.java
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

    public double getEmpId() {
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
    
    public static void GenerateReport() throws IOException{        
        File file =  new File("C:/temp/emp_details.pdf");        
        PDDocument document = new PDDocument();                
        PDPage blankPage = new PDPage();        
        document.addPage(blankPage);                
        PDPage page =  document.getPage(0);        
        PDPageContentStream contentStream = new PDPageContentStream(document,page);                
        contentStream.beginText();                
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);        
        contentStream.newLineAtOffset(25, 500);        
        String text = "This is the sample document and we are adding"                
            + "content to it";        
        contentStream.showText(text);        
        contentStream.endText();                
        System.out.println("Content added");                
        contentStream.close();                
        document.save(new File("C:/temp/emp_details.pdf"));                
        document.close();    
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        try{            
            GenerateReport();        
        }catch(Exception e){           
            System.out.println(e);        
        }             
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
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCaseStudy;

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

    public double getEmpId() {
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
>>>>>>> refs/remotes/origin/master:JAVACASESTUDY/src/javacasestudy/Employees.java
