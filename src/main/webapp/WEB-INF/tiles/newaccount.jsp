<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- commandName : nome do atributo no método --%>
<sf:form id="details" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
    <table class="formtable">
        <tr>
            <td class="label">Username: </td>
            <td>
        <sf:input path="username" class="control" name="username" type="text" /><br />
        <sf:errors path="username" cssClass="error" />
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
            <td class="label">Password: </td>
            <td>
        <sf:input id="password" path="password" class="control"  name="password" type="password" /><br />
        <sf:errors path="password" cssClass="error" />
        </td>
        </tr>
        <tr>
            <td class="label">Confirm Password: </td>
            <td>
                <input id="confirmpass" class="control" type="password" name="confirmpass" />
                <div id="matchpass"></div>
            </td>
        </tr>
        <tr>
            <td class="label"> </td>
            <td><input class="control"  value="Create Account" type="submit" /></td>
        </tr>
    </table>
</sf:form>