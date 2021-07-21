<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 6/15/2021
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h3>Settings</h3>
<form:form action="setting" method="post" modelAttribute="mailSetting">
<table>
    <tr>
        <td><form:label path="language">Languages: </form:label></td>
       <td><form:select path="language">
           <form:option value="English">English</form:option>
           <form:option value="Vietnamese">Vietnamese</form:option>
           <form:option value="Japanese">Japanese</form:option>
           <form:option value="Chinese">Chinese</form:option>
       </form:select></td>
    </tr>
    <tr>
        <td><form:label path="size">Page Size: </form:label></td>
        <td>Show <form:select path="size">
            <form:option value="5">5</form:option>
            <form:option value="10">10</form:option>
            <form:option value="15">15</form:option>
            <form:option value="25">25</form:option>
            <form:option value="50">50</form:option>
            <form:option value="100">100</form:option>
        </form:select> emails per page</td>
    </tr>
    <tr>
        <td><form:label path="spam">Spams filter: </form:label></td>
        <td><form:checkbox path="spam" value="1"/>Enable spams filter</td>
    </tr>
    <tr>
        <td><form:label path="signature">Signature: </form:label></td>
        <td><form:textarea path="signature" rows="3" /></td>
    </tr>
    <tr>
        <td></td>
        <td>
            <form:button>Update</form:button>
            <input type="button"  onclick="location.href='/setting'" value="Cancel">
        </td>
    </tr>
</table>
</form:form>
</body>
</html>
