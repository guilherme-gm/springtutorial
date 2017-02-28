<%-- 
    Document   : home
    Created on : 24/02/2017, 15:29:10
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--
        <h1>Hello World!</h1>
        Session: <%= session.getAttribute("name") %><br />
        Request: <%= request.getAttribute("name") %><br />
        Request (EL): ${name}<br />
        <c:out value="${name}"></c:out>
        --%>
        <%--
            ${pageContext.request.contextPath} - Permite que o sistema funcione em diferentes servidores
            por causa do que vem antes da /
        --%>
        <ul>
            <li><a href="${pageContext.request.contextPath}/offers">View Offers</a></li>
            <li><a href="${pageContext.request.contextPath}/createoffer">Create Offer</a></li>
            <li><a href="<c:url value="/newaccount" />">Create Account</a></li>
        </ul>

        <sec:authorize access="!isAuthenticated()">
            <a href="<c:url value="/login" />">Login</a>
        </sec:authorize>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <a href="<c:url value="/admin" />">Admin</a>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <c:url var="logoutUrl" value="/logout"/>
            <form action="${logoutUrl}" method="post">
                <input type="submit" value="Logout"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </sec:authorize>
    </body>
</html>
