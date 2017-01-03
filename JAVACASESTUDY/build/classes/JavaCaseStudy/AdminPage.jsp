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
        <th id="name">Administrative Options:</th>
    <tr>
        <td>
            <button type="submit">Add</button>
        </td> 
    </tr>
    <tr>
        <td>
            <button type="submit">View</button>
        </td> 
    </tr>
    <tr>
        <td>
            <button type="submit">Edit</button>
        </td> 
    </tr>
    <tr>
        <td>
            <button type="submit">Delete</button>
        </td> 
    </tr>
    <tr>
        <td>
            <button type="submit">Generate Report</button>
        </td> 
    </tr>
    </table>
    </form>
</body>
</html>

