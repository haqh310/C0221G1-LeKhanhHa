<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 5/26/2021
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <style>
        div{
            width: 600px;
            height: 500px;
            border: 1px solid black;
            text-align: center;
            box-shadow: 1px 1px 5px 5px #3bb7ff;
        }
        table{
            border-collapse:  collapse;
        }
        table td{
            padding: 10px 30px;
        }
        table tr{
            border-bottom: 1px solid black;
        }
        img{
            width :40px;
            height:40px;
        }
    </style>
</head>
<body>
<div>
    <h2>Danh sách khách hàng</h2>
    <table>
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
    <tr>
   <c:forEach items="${customers}" var="customer">
    <tr>
        <td>${customer.name}</td>
        <td>${customer.date}</td>
        <td>${customer.address}</td>
        <td><img src="${customer.img}"></td>
    </tr>
   </c:forEach>
    </tr>
    </table>
</div>
</body>
</html>
