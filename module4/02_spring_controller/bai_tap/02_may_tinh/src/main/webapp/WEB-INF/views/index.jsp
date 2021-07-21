<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 6/14/2021
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h3>calculator</h3>
<form action="/calculator" method="post">
    <input type="number" name="number1" value="${number1}">
    <input type="number" name="number2" value="${number2}">
    <br><br>
    <button type="submit" name="cal" value="+">Addition(+)</button>
    <button type="submit" name="cal" value="-">Subtraction(-)</button>
    <button type="submit" name="cal" value="*">Multiplication(X)</button>
    <button type="submit" name="cal" value="/">Division(/)</button>
</form>
<p>Result Division: ${result}</p>
</body>
</html>
