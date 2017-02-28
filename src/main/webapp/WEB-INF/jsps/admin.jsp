<%-- 
    Document   : admin
    Created on : 28/02/2017, 11:48:18
    Author     : guilh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Admins only</h1>
        <h2>Users</h2>
        <table>
            <tr>
                <td>Username</td>
                <td>E-mail</td>
                <td>Role</td>
                <td>Enabled</td>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td><c:out value="${user.username}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.authority}" /></td>
                    <td><c:out value="${user.enabled}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
