<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 5/26/2021
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Calculator</title>
  <style>
    form{
      width: 300px;
      margin: 50px;
      padding: 20px;
      border: 1px solid black;
    }
  </style>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculator" method="get" >
  <table>
    <tr>
      <td><label>First operand: </label></td>
      <td><input type="number" name="first_op"></td>
    </tr>
    <tr>
      <td><label>Operator:</label></td>
      <td><select name="operator">
        <option value="+">addition</option>
        <option value="-">subtraction</option>
        <option value="*">multiplication</option>
        <option value="/">division</option>
      </select></td>
    </tr>
    <tr>
      <td><label>Second operand:</label></td>
      <td> <input type="text" name="second_op"><br></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" id="calculator" value="calculator"></td>
    </tr>
  </table>
</form>
</body>
</html>
