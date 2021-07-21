<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 5/30/2021
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>View service</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../../common/header.jsp"></jsp:include >
<div class="row">
    <div class="container d-flex justify-content-center">
        <div class="col-6 d-flex flex-column">
            <h1>View service</h1>
            <p>
                <a href="/services">Back to menu</a>
            </p>
            <form class="container border border-dark mb-3 pt-3">
                <div class="form-group">
                    <label>ID:</label>
                    <input type="text" class="form-control" name="service_id" value="${service.service_id}">
                </div>
                <div class="form-group">
                    <label>Code:</label>
                    <input type="text" class="form-control" name="service_code" value="${service.service_code}">
                </div>
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" class="form-control" name="service_name" value="${service.service_name}">
                </div>
                <div class="form-group">
                    <label>Area:</label>
                    <input type="number" class="form-control" name="service_area" value="${service.service_area}">
                </div>
                <div class="form-group">
                    <label>Cost:</label>
                    <input type="text" class="form-control" name="service_cost" value="${service.service_cost}">
                </div>
                <div class="form-group">
                    <label>Max People:</label>
                    <input type="number" class="form-control" name="service_max_people"
                           value="${service.service_max_people}">
                </div>
                <div class="form-group">
                    <label>Rent Type: </label>
                    <c:forEach var="rent" items="${rentTypes}">
                        <c:if test="${rent.rent_type_id == service.rent_type_id}">
                            <input type="text" class="form-control" value="${rent.rent_type_name}">
                        </c:if>
                    </c:forEach>
                </div>
                <div class="form-group">
                    <label>Division ID: </label>
                    <c:forEach var="type" items="${requestScope['serviceTypes']}">
                        <c:if test="${type.service_type_id == service.service_type_id}">
                            <input type="text" class="form-control" value="${type.service_type_name}">
                        </c:if>

                    </c:forEach>
                </div>
                <div class="form-group">
                    <label>Standard room:</label>
                    <input type="text" class="form-control" name="standard_room" value="${service.standard_room}">
                </div>
                <div class="form-group">
                    <label>Description other convenience:</label>
                    <input type="text" class="form-control" name="description_other_convenience"
                           value="${service.description_other_convenience}">
                </div>
                <div class="form-group">
                    <label>Pool area:</label>
                    <input type="number" class="form-control" name="pool_area" value="${service.pool_area}">
                </div>
                <div class="form-group">
                    <label>Number of floors:</label>
                    <input type="number" class="form-control" name="number_of_floors"
                           value="${service.number_of_floors}">
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