

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>

<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>     
        <form:form method="POST" commandName="user"> 
        <table> 
            <tr> 
                <td>User Name :</td> 
                <td><form:input path="username" /></td> 
                <td><form:errors path="username" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Password :</td> 
                <td><form:password path="password" /></td> 
                <td><form:errors path="password" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td colspan="2">
                <input type="submit"></td> 
            </tr> 
        </table> 
        </form:form>
    </body>
</html>
