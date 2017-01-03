<%-- 
    Document   : Login
    Created on : Jan 3, 2017, 11:07:20 AM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees</title>
    </head>
    <body>
        <s:form method="POST" commandName="user">
            <s:errors path="username" cssClass="error" /><br>
            <s:errors path="password" cssClass="error" /><br>
            User name: <br>
            <s:input path="username" />
            <br>
            Password: <br>
            <s:input path="password" />         
            <br>
            <input type="submit" name="login">
            <input type="reset" name="clearform">
        </s:form>

    </body>
</html>
