<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    $(document).ready(function () {
        document.f.username.focus();
    });
</script>

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
        <tr><td>Remember me:</td><td><input type='checkbox' name='remember-me'/></td></tr>
    </table>
</form>

<a href="<c:url value="/newaccount" />">Create Account</a>