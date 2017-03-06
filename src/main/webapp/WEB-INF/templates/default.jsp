<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src='<c:url value="static/script/jquery-3.1.1.min.js" />'></script>
        
        <tiles:insertAttribute name="includes" />

        <title><tiles:insertAttribute name="title" /> </title>
    </head>
    <body>

        <div class="header">
            <tiles:insertAttribute name="header"/>
        </div>
        <div class="content">
            <tiles:insertAttribute name="content"/>
        </div>
        <div class="footer">
            <tiles:insertAttribute name="footer"/>
        </div>


    </body>
</html>
