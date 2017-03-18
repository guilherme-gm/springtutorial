<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <li><a href="${pageContext.request.contextPath}/offers">View Offers</a></li>
    <li><a href="${pageContext.request.contextPath}/createoffer">Create Offer</a></li>
    <li><a href='<c:url value="/newaccount" />'>Create Account</a></li>
</ul>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="<c:url value="/admin" />">Admin</a>
</sec:authorize>