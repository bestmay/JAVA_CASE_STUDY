

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>     
        <form action="loginAction.action">
            <s:actionerror></s:actionerror>
            User name:<br>
            <input type="text" name="username" placeholder="User name"><br>
            <s:fielderror></s:fielderror>
            Password:<br>
            <input type="password" name="password" placeholder="Password"><br>
            <s:fielderror></s:fielderror>

            <input type="Submit" Value="Submit">
            <input type="reset" Value="Reset">
        </form>
    </body>
</html>
