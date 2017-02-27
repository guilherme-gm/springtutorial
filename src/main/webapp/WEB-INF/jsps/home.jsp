<%-- 
    Document   : home
    Created on : 24/02/2017, 15:29:10
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        </ul>
    </body>
</html>
