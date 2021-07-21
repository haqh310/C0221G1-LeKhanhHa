<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 5/26/2021
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
  <title>Product Discount Calculator</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<h2>Product Discount Calculator</h2>
<form action="/discount" method="get">
  <label>Product Description: </label><br/>
  <input type="text" name="product"  /><br/>
  <label>List Price: </label><br/>
  <input type="text" name="price" value="0"/><br/>
  <label>Discount Percent: </label><br/>
  <input type="text" name="percent" value="0.0"/><br/>
  <input type = "submit" id = "submit" value = "Amount"/>
</form>
</body>
</html>
