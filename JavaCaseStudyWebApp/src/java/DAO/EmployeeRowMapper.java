/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import domain.Employees;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import java.sql.*;

class EmployeeRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int index) throws SQLException {
        Employees e = new Employees(rs);
        return e;
    }
}
