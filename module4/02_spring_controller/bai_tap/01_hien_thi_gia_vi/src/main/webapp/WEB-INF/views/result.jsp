<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 6/14/2021
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<p>Result:
    <c:forEach var="c" items="${condiment}">
        <span>${c} </span>
    </c:forEach>
</p>
</body>
</html>
