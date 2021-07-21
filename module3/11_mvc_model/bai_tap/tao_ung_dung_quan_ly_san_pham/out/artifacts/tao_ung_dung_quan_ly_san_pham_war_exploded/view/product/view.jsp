<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 5/26/2021
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/customers">Back to customer list</a>
</p>
<fieldset>
    <legend>Product information</legend>
    <table>
        <tr>
            <td>Name: </td>
            <td>${product.name}</td>
        </tr>
        <tr>
            <td>Price: </td>
            <td>${product.price}</td>
        </tr>
        <tr>
            <td>Description: </td>
            <td>${product.description}</td>
        </tr>
        <tr>
            <td>Manufacturer: </td>
            <td>${product.manufacturer}</td>
        </tr>
    </table>
</fieldset>
</body>
</html>
