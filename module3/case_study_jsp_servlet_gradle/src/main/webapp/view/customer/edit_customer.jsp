<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 5/27/2021
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../../common/header.jsp"></jsp:include >
<div class="row">
    <div class="container d-flex justify-content-center">
        <div class="col-6 d-flex flex-column">
            <h1>Edit customer</h1>
            <c:if test="${messages.size() == 6}">
                <span>${messages.get(5)}</span>
            </c:if>
            <p>
                <a href="/customers">Back to menu</a>
            </p>
            <form  action="/customers?action=edit&customer_id=${customer.customer_id}" method="post" class="container border border-dark mb-3 pt-3">
                <div class="form-group">
                    <label>ID:</label>
                    <input type="text" class="form-control" name="customer_id" value="${customer.customer_id}" disabled>
                </div>
                <div class="form-group">
                    <label>Customer Code:</label>
                    <input type="text" class="form-control" name="customer_code" value="${customer.customer_code}" disabled>
                    <c:if test="${messages.get(0) != null}">
                        <p class="text-danger h6">${messages.get(0)}</p>
                    </c:if>
                </div>
                <div class="form-group">
                    <label>Type ID: </label>
                    <select class="form-control" name="customer_type_id">
                        <c:forEach var="type" items="${customerTypes}">
                            <option value="${type.customer_type_id}"
                                    ${type.customer_type_id == customer.customer_type_id ? "selected" : ""}>${type.customer_type_name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" class="form-control" name="customer_name" value="${customer.customer_name}">
                </div>
                <div class="form-group">
                    <label>Birthday:</label>
                    <input type="date" class="form-control" name="customer_birthday" value="${customer.customer_birthday}">
                    <c:if test="${messages.get(1) != null}">
                        <p class="text-danger h6">${messages.get(1)}</p>
                    </c:if>
                </div>
                <div class="form-group">
                    <label>Gender: </label>
                    <select class="form-select form-control " name="customer_gender" >
                        <c:if test="${customer.customer_gender == 'Male'}">
                            <option value="Male" selected>Male</option>
                            <option value="Female">Female</option>
                        </c:if>
                        <c:if test="${customer.customer_gender == 'Female'}">
                            <option value="Male">Male</option>
                            <option value="Female" selected>Female</option>
                        </c:if>
                    </select>
                </div>
                <div class="form-group">
                    <label>ID Card: </label>
                    <input type="text" class="form-control" name="customer_id_card" value="${customer.customer_id_card}">
                    <c:if test="${messages.get(2) != null}">
                        <p class="text-danger h6">${messages.get(2)}</p>
                    </c:if>
                </div>
                <div class="form-group">
                    <label>Phone: </label>
                    <input type="number" class="form-control" name="customer_phone" value="${customer.customer_phone}">
                    <c:if test="${messages.get(3) != null}">
                        <p class="text-danger h6">${messages.get(3)}</p>
                    </c:if>
                </div>
                <div class="form-group">
                    <label>Email: </label>
                    <input type="email" class="form-control" name="customer_email" value="${customer.customer_email}">
                    <c:if test="${messages.get(4) != null}">
                        <p class="text-danger h6">${messages.get(4)}</p>
                    </c:if>
                </div>
                <div class="form-group">
                    <label>Address: </label>
                    <input type="text" class="form-control" name="customer_address" value="${customer.customer_address}">
                </div>
                <div class="d-flex justify-content-center ">
                    <button type="submit" class="btn btn-primary mb-3">Update</button>
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
