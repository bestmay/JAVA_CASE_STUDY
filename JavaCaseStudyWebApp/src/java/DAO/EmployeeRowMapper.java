/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import domain.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import java.sql.*;

class EmployeeRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int index) throws SQLException {
        Employee e = new Employee(rs);
        return e;
    }
}
