<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 5/26/2021
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product by ${name}</h1>
<p>
    <a href="/customers">Back to customer list</a>
</p>
<p><a href="/products?action=create">Create new product</a></p>
<form action="/products?action=search" method="post">
    <input type="text" name="name" placeholder="Enter name product">
    <input type="submit" value="Search">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacturer</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${requestScope['products']}" var="product">
        <tr>
            <td><a href="/products?action=view&id=${product.id}">${product.id}</a></td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.manufacturer}</td>
            <td><a href="/products?action=edit&id=${product.id}">edit</a></td>
            <td><a href="/products?action=delete&id=${product.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
