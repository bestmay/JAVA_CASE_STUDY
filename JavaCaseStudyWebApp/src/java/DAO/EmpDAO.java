/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import domain.Employees;
/**
 *
 * @author syntel
 */
public interface EmpDAO {
    public void createRecord(Employees e);
    public void readRecord(String empId); 
    public void updateRecord(String empId);
    public void deleteRecord(String empId);
    public boolean loginCheck(String username, String password);
    List getAllEmp();
    long getTotalNoOfEmp();
    Employees getEmpByName(String name);
    List getEmpOfDept(String dept);
}
