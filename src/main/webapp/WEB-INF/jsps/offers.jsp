<%-- 
    Document   : offers
    Created on : 25/02/2017, 21:10:23
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table class="offers">
            <tr><td>Name</td><td>Email</td><td>Offer</td></tr>

            <c:forEach var="offer" items="${offers}">
                <tr>

                    <td><c:out value="${offer.name}"></c:out></td>

                        <td><c:out value="${offer.email}"></c:out></td>

                        <td><c:out value="${offer.text}"></c:out></td>

                    </tr>
            </c:forEach>
        </table>

        <%--
        <c:forEach var="offer" items="${offers}">
            <p>
                <c:out value="${offer}"></c:out>
            </p>
        </c:forEach>
        --%>
    </body>
</html>
