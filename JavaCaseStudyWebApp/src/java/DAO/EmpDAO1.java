/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author syntel
 */
import domain.Employee;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author LS5002117
 */
public class EmpDAO1 implements EmpDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createRecord(Employee e) {
        /*String query="insert into Emp values('"+e.getEmpId()+"','"+e.getEmpName()+"',"+e.getSalary()+")";
         jdbcTemplate.update(query);*/

        //INserting using prepared Statement
        String p_query = "insert into Employees values(?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(p_query, new Object[]{
            e.getFirstName(),e.getLastName(),e.getVertical(),e.getProject(),e.getSkills(),
            e.getGrade(),e.getBand(),false,e.getOrg(),e.getEmpId()});
        System.out.println("Inserted Emp Record");
    }

    @Override
    public void readRecord(String empId) {
        System.out.println("Fetched");
    }

    public long getTotalNoOfEmp() {
        //JdbcTemplate jt = getJdbcTemplate();
        return jdbcTemplate.queryForLong("select count(empname) from Emp");
    }

    public void deleteRecord(String empId) {
        String p_query = "delete from Emp where empno = ?";
        jdbcTemplate.update(p_query, new Object[]{
            empId});
    }

    public void updateRecord(String empId) {
        System.out.println("Enter new Name:");
        Scanner sn = new Scanner(System.in);
        String name = sn.nextLine();
        System.out.println("Enter new Salary:");
        int salary = sn.nextInt();
        String p_query = "update Emp set empname = ?, salary=? where empno=? ";
        jdbcTemplate.update(p_query, new Object[]{
            name,salary,empId});
    }
    
    public boolean loginCheck(String username, String password){
        String p_query = "select * from login_info where username=? and password=?";
        if(jdbcTemplate.query(p_query,new EmployeeRowMapper(), new Object[]{
            username,password}).isEmpty())
        {
            return false;
        }
        else{
            return true;
        }
    }

    public List getAllEmp() {
        return jdbcTemplate.query("select * from Emp", new EmployeeRowMapper());
    }

    public List getEmpOfDept(String dept) {
        //JdbcTemplate jt = getJdbcTemplate();
        Object o[] = {dept};
        int argsTypes[] = {Types.VARCHAR};
        RowMapper mapper = new EmployeeRowMapper();
        List l = jdbcTemplate.query("select empno,ename, salary,dname from Emp where Emp.dname=?", o, argsTypes, mapper);
        return l;
    }

    public Employee getEmpByName(String name) {
        //JdbcTemplate jt = getJdbcTemplate();
        Object o[] = {name};
        int argsTypes[] = {Types.VARCHAR};
        RowMapper mapper = new EmployeeRowMapper();
        List l = jdbcTemplate.query("select * from Emp", o, argsTypes, mapper);
        Iterator it = l.iterator();
        Employee e = (Employee) it.next();
        return e;
    }
}