<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 5/26/2021
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<c:if test="${requestScope['message'] != null}">
    <span>${requestScope['message']}</span>
</c:if>
<c:if test="${requestScope['message'] == null}">
    <h1>Result :</h1>
    <h1><c:out value="${first_op} ${operator} ${second_op} = ${result}"></c:out></h1>
</c:if>
</body>
</html>
