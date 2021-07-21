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
    <title>Delete product</title>
</head>
<body>
<h1>Delete product</h1>
<form method="post">
    <h3>Are you sure?</h3>
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
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="/products">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
