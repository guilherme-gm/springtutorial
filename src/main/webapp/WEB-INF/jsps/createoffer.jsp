<%-- 
    Document   : createoffer
    Created on : 25/02/2017, 21:12:27
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
    </head>
    <body>

        <%-- commandName : nome do atributo no método --%>
        <sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">

            <table class="formtable">
                <tr>
                    <td class="label">Name: </td>
                    <td>
                        <sf:input path="name" class="control" name="name" type="text" /><br />
                        <sf:errors path="name" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td class="label">Email: </td>
                    <td>
                        <sf:input path="email" class="control"  name="email" type="text" /><br />
                        <sf:errors path="email" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td class="label">Your offer: </td>
                    <td>
                        <sf:textarea path="text" class="control"  name="text" rows="10" cols="10"></sf:textarea><br />
                        <sf:errors path="text" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td class="label"> </td>
                    <td><input class="control"  value="Create advert" type="submit" /></td>
                </tr>
            </table>

        </sf:form>

        <%--
        <form method="post" action="${pageContext.request.contextPath}/docreate">

            <table class="formtable">
                <tr><td class="label">Name: </td><td><input class="control" name="name" type="text" /></td></tr>
                <tr><td class="label">Email: </td><td><input class="control"  name="email" type="text" /></td></tr>
                <tr><td class="label">Your offer: </td><td><textarea class="control"  name="text" rows="10" cols="10"></textarea></td></tr>
                <tr><td class="label"> </td><td><input class="control"  value="Create advert" type="submit" /></td></tr>
            </table>

        </form>
        --%>

    </body>
</html>