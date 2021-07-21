<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 6/11/2021
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <style>
        body{
            background-size: cover;
            background-image: url("https://hotelfuramadanang.files.wordpress.com/2016/03/furama-resort-da-nang-1.jpg");
            background-repeat: no-repeat;
        }
        button{
            width: 75px;
        }
    </style>
</head>
<body>
<div class="row">
    <div class="container d-flex justify-content-center mt-5 pt-5">
        <div class="col-4 d-flex flex-column bg-light">
            <p class="h4 pt-2 mx-auto">Sign in</p>
            <c:if test="${message !=null}">
                <small style="color: red">${message}</small>
            </c:if>
            <form action="/login" method="post">
                <div class="form-group">
                    <label>Username:</label>
                    <input type="text" class="form-control" placeholder="Enter username... " name="username" value="${username}">
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <input type="text" class="form-control" placeholder="Enter password... " name="password" value="${password}">
                </div>
                <div class="form-group">
                    <input name="remember" value="1" type="checkbox">
                    <label class="form-check-label">Remember me</label>
                </div>
                <div class="d-flex justify-content-center ">
                    <a href="index.jsp">
                        <button class="btn btn-dark">Back</button>
                    </a>
                    <button type="submit" class="btn btn-success ml-3 mb-3">Sign in</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
        integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
        crossorigin="anonymous"></script>
</body>
</html>
