<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 5/30/2021
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit service</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../../common/header.jsp"></jsp:include >
<div class="row">
    <div class="container d-flex justify-content-center">
        <div class="col-6 d-flex flex-column">
            <h1>Edit service</h1>
            <c:if test="${messages.size() == 7}">
                <span>${messages.get(6)}</span>
            </c:if>
            <p>
                <a href="/services">Back to menu</a>
            </p>
            <form action="/services?action=edit&service_id=${service.service_id}" method="post" class="container border border-dark mb-3 pt-3">
                <div class="form-group">
                    <label>ID:</label>
                    <input type="text" class="form-control" name="service_id" value="${service.service_id}" disabled>
                </div>
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" class="form-control" name="service_code" value="${service.service_code}" disabled>
                    <c:if test="${messages.get(0) != null}">
                        <p class="text-danger h6">${messages.get(0)}</p>
                    </c:if>
                </div>
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" class="form-control" name="service_name" value="${service.service_name}">
                </div>
                <div class="form-group">
                    <label>Area:</label>
                    <input type="number" class="form-control" name="service_area" value="${service.service_area}">
                    <c:if test="${messages.get(1) != null}">
                        <p class="text-danger h6">${messages.get(1)}</p>
                    </c:if>
                </div>
                <div class="form-group">
                    <label>Cost:</label>
                    <input type="text" class="form-control" name="service_cost" value="${service.service_cost}">
                    <c:if test="${messages.get(2) != null}">
                        <p class="text-danger h6">${messages.get(2)}</p>
                    </c:if>
                </div>
                <div class="form-group">
                    <label>Max People:</label>
                    <input type="number" class="form-control" name="service_max_people"
                           value="${service.service_max_people}">
                    <c:if test="${messages.get(3) != null}">
                        <p class="text-danger h6">${messages.get(3)}</p>
                    </c:if>
                </div>
                <div class="form-group">
                    <label>Rent Type: </label>
                    <select name="rent_type_id" class="form-control">
                        <c:forEach var="rent" items="${rentTypes}">
                            <option value="${rent.rent_type_id}" ${rent.rent_type_id == service.rent_type_id ? "selected" :""} >${rent.rent_type_name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Division ID: </label>
                    <select id="service_type_id" name="service_type_id" class="form-control">
                        <c:forEach var="type" items="${serviceTypes}">
                            <option value="${type.service_type_id}" ${type.service_type_id == service.service_type_id ? "selected" :""} >${type.service_type_name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div id="standard_room" class="form-group">
                    <label>Standard room:</label>
                    <input id="input_standard_room" type="text" class="form-control" name="standard_room" value="${service.standard_room}">
                </div>
                <div id="description_other_convenience" class="form-group">
                    <label>Description other convenience:</label>
                    <input id="input_description_other_convenience" type="text" class="form-control" name="description_other_convenience" value="${service.description_other_convenience}">
                </div>
                <div id="pool_area" class="form-group">
                    <label>Pool area:</label>
                    <input id="input_pool_area" type="number" class="form-control" name="pool_area" value="${service.pool_area}">
                    <c:if test="${messages.get(4) != null}">
                        <p class="text-danger h6">${messages.get(4)}</p>
                    </c:if>
                </div>
                <div id="number_of_floors" class="form-group">
                    <label>Number of floors:</label>
                    <input id="input_number_of_floors" type="number" class="form-control" name="number_of_floors" value="${service.number_of_floors}">
                    <c:if test="${messages.get(5) != null}">
                        <p class="text-danger h6">${messages.get(5)}</p>
                    </c:if>
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
<script>
    function myFunction() {
        setDisplay();
        let id = document.getElementById("service_type_id").value;
        if (id == 2) {
            document.getElementById("pool_area").style.display = "none";
            document.getElementById("input_pool_area").value = null;
        } else if (id == 3) {
            document.getElementById("standard_room").style.display = "none";
            document.getElementById("description_other_convenience").style.display = "none";
            document.getElementById("pool_area").style.display = "none";
            document.getElementById("number_of_floors").style.display = "none";
            document.getElementById("input_standard_room").disabled = true;
            document.getElementById("input_description_other_convenience").disabled = true;
            document.getElementById("input_pool_area").disabled = true;
            document.getElementById("input_number_of_floors").disabled = true;
        }
    }
    function setDisplay() {
        document.getElementById("standard_room").style.display = "block";
        document.getElementById("description_other_convenience").style.display = "block";
        document.getElementById("pool_area").style.display = "block";
        document.getElementById("number_of_floors").style.display = "block";
        document.getElementById("input_standard_room").disabled = false;
        document.getElementById("input_description_other_convenience").disabled = false;
        document.getElementById("input_pool_area").disabled = false;
        document.getElementById("input_number_of_floors").disabled = false;
    }
</script>
</body>
</html>
