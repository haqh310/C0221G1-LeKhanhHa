<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 6/13/2021
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Exchange money</title>
  </head>
  <body>
  <form action="/result" method="post">
    <label>USD:</label>
    <input type="number" name="usd" placeholder="Enter usd..." value="${usd}"><br><br>
    <label>Rate:</label>
    <input type="number" name="rate" value="${rate != null? rate: "22000"}"><br><br>
    <label>VND:</label>
    <input type="number" value="${vnd}" ${vnd != null? "":"disabled"}><br><br>
    <input type="submit" value="Exchange">
  </form>
  </body>
</html>
