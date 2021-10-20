<%-- 
    Document   : ShoppingList
    Created on : Oct 16, 2021, 7:34:41 PM
    Author     : 794974
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <form method="post" action="">
    <body>
        <h1>Shopping List</h1>
        <div>
            Hello, ${username} <a href="?logout" value="logout" name="logout">Logout</a>
        </div>
        <h2>List</h2>
        <div>
            <label> Add item:</label>
            <input type="text" name="item" value="">
            <input type="submit" name="add" value="Add">
        </div>
            </form>
            <c:if test="${empty_goods}">
                <p>Please enter item you wish to add</p>
            </c:if>

        <form method="post" action="">
            <ul>
            <c:forEach var="item" items="${items}">
                <li>
                <input type="radio" name="added_item" value="<c:out value="${item}"/>">
                           <c:out value="${item}"/>
                </li>
            </c:forEach>
                </ul>
            <!--add a hidden field and check if the action of hidden field equals delete -->
            <input type="submit" name="delete" value="delete">
            <input type="hidden" name="action" value="delete">
            <c:if test="${deleteError}">
                <p> Please Select and item to be deleted</p>
            </c:if>
        </form>
    </body>
</html>
