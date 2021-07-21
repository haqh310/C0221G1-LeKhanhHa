<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 5/27/2021
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Create new customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class="row">
    <div class="container d-flex justify-content-center">
        <div class="col-6 d-flex flex-column">
            <h1>Create new customer</h1>
            <c:if test="${requestScope['message'] != null}">
                <span>${requestScope["message"]}</span>
            </c:if>
            <p>
                <a href="/customers">Back to menu</a>
            </p>
            <form action="/customers?action=create" method="post" class="container border border-dark mb-3 pt-3">
                <div class="form-group">
                    <label>Type ID: </label>
                    <select class="form-control" name="customer_type_id">
                        <c:forEach var="type" items="${customerTypes}">
                            <option value="${type.customer_type_id}">${type.customer_type_name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" class="form-control" placeholder="Enter name... " name="customer_name">
                </div>
                <div class="form-group">
                    <label>Birthday:</label>
                    <input type="date" class="form-control" placeholder="Enter birthday" name="customer_birthday">
                </div>
                <div class="form-group">
                    <label>Gender: </label>
                    <select class="form-control "  name="customer_gender" aria-label="Default select example">
                        <option selected>Choose gender</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>ID Card: </label>
                    <input type="text" class="form-control" placeholder="Enter id card... " name="customer_id_card">
                </div>
                <div class="form-group">
                    <label>Phone: </label>
                    <input type="number" class="form-control" placeholder="Enter phone number..." name="customer_phone">
                </div>
                <div class="form-group">
                    <label>Email: </label>
                    <input type="email" class="form-control" placeholder="Enter email..." name="customer_email">
                </div>
                <div class="form-group">
                    <label>Address: </label>
                    <input type="text" class="form-control" placeholder="Enter address... " name="customer_address">
                </div>
                <div class="d-flex justify-content-center ">
                    <button type="submit" class="btn btn-primary mb-3">Create</button>
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
