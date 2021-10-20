<%-- 
    Document   : register
    Created on : Oct 16, 2021, 7:34:55 PM
    Author     : 794974
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List register</title>
    </head>
    
    <body>
        <form method="post" action="">
            <h1>Shopping List</h1>
        <div>
            <label>Username: </label>
            <input type="text" name="username" required>
            <input type="submit" name="register" value="Register Name">
            
        </div>
        
        </form>
        <c:if test="${success}">
            <p>"you have successfully logged out"</p>
        </c:if>
    </body>
    
</html>
