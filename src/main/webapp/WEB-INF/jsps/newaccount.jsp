<%-- 
    Document   : createoffer
    Created on : 25/02/2017, 21:12:27
    Author     : guilh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="<c:url value="static/script/jquery-3.1.1.min.js"></c:url>"></script>

            <script type="text/javascript">
                function onLoad() {
                    $("#password").keyup(checkPasswordMatch);
                    $("#confirmpass").keyup(checkPasswordMatch);
                    
                    $("#details").submit(canSubmit);
                }
                
                function canSubmit() {
                    var password = $("#password").val();
                    var confirmpass = $("#confirmpass").val();
                    
                    if (password === confirmpass) {
                        return true;
                    } else {
                        alert("Password invalid");
                        return false;
                    }
                }
                
                function checkPasswordMatch() {
                    var password = $("#password").val();
                    var confirmpass = $("#confirmpass").val();
                    
                    if (password.length < 3) {
                        return;
                    }
                    
                    if (password === confirmpass) {
                        $("#matchpass").text("Passwords match.");
                        $("#matchpass").addClass("valid");
                        $("#matchpass").removeClass("error");
                        
                    } else {
                        $("#matchpass").text("Passwords do not match.");
                        $("#matchpass").addClass("error");
                        $("#matchpass").removeClass("valid");
                    }
                }
                
                $(document).ready(onLoad);
            </script>
        </head>
        <body>

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
