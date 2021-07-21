<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Sandwich</title>
</head>
<body>
<h3>Sandwich Condiments</h3>
<form action="/save" method="post">
    <input type="checkbox" value="Lettuce" name="condiment" id="lettuce">
    <label for="lettuce">Lettuce</label>
    <input type="checkbox" value="Tomato" name="condiment" id="tomato">
    <label for="tomato">Tomato</label>
    <input type="checkbox" value="Mustard" name="condiment" id="mustard">
    <label for="mustard">Mustard</label>
    <input type="checkbox" value="Sprouts" name="condiment" id="sprouts">
    <label for="sprouts">Sprouts</label><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
