<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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