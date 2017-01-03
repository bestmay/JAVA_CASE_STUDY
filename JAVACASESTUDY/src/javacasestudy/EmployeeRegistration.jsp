<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
    <form action="ShowRegistration.action">
    <table>
        <th id="name">Employee Registration</th>
    <tr>
        <td>
            First Name: <input type="text" name="firstName" placeholder="First Name" required>
        </td> 
    </tr>
    <tr>
        <td>
            Last Name: <input type="text" name="lastName" placeholder="Last Name" required>
        </td> 
    </tr>
    <tr>
        <td>
            Emp ID: <input type="text" name="empId" placeholder="Employee ID" min="1000000" required>
        </td> 
    </tr>
    <tr>
        <td>
            Band: <input type="text" name="band" placeholder="Band" required>
        </td> 
    </tr>
    <tr>
        <td>
            Grade: <input type="text" name="grade" placeholder="Grade" required>
        </td> 
    </tr>
    <tr>
        <td>
            Vertical: <input type="text" name="vertical" placeholder="Vertical" required>
        </td> 
    </tr>
    <tr>
        <td>
            Project: <input type="text" name="project" placeholder="Project" required>
        </td> 
    </tr>
    <tr>
        <td>
            Skills: <input type="text" name="skills" placeholder="Skills" required>
        </td> 
    </tr>
    <tr>
        <td>
            Organization: <input type="text" name="org" placeholder="Organization" required>
        </td> 
    </tr>
    <tr>
        <td>
            <input type="file" name="pic" accept="image/*">
            <input type="submit">
        <td>
    </tr>
    <tr>
        <td>
            <input type="Submit" Value="Submit">
            <input type="reset" Value="Reset">
        </td>
    </tr>
    </table>
    </form>
</body>
</html>

