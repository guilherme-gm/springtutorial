<%-- 
    Document   : login
    Created on : 27/02/2017, 16:42:02
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Login Page</title>
        
        <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
    </head>
    <body onload='document.f.username.focus();'>
        <h3>Login with Username and Password</h3>
        <c:if test="${param.error != null}">
            <span class="error">
                Login failed. Bad Credentials
            </span>
        </c:if>
        
            <form name='f' action='${pageContext.request.contextPath}/login' method='POST'>
            <table class="formtable">
                <tr><td>User:</td><td><input type='text' name='username' value=''></td></tr>
                <tr><td>Password:</td><td><input type='password' name='password'/></td></tr>
                <tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
                <input name="_csrf" type="hidden" value="${_csrf.token}" />
            </table>
        </form>
    </body>
</html>
