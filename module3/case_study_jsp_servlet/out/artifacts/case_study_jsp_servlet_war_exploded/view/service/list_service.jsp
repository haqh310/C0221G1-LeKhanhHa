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
    <title>List Service</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="container-fluid border pt-5 mt-5">
    <h1>List Service</h1>
    <p><a href="index.jsp">Back to menu</a></p>
    <div class="row">
        <div class="col-6">
            <p> <a href="/services?action=create">Create new service</a></p>
        </div>
        <div class="col-6 d-flex justify-content-end">
            <form action="/services?action=search" method="post">
                <input type="text" name="service_name" placeholder="Enter name...">
                <input type="submit" value="Search">
            </form>
        </div>
    </div>
    <table class="table table-bordered table-striped" id="tableService">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Area</th>
            <th>Cost</th>
            <th>Max People</th>
            <th>Rent Type</th>
            <th>Service Type</th>
            <th>Standard Room</th>
            <th>Description Other</th>
            <th>Pool Area</th>
            <th>Number Floors</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${services}" var="service">
            <tr>
                <td><a href="/services?action=view&service_id=${service.service_id}">${service.service_id}</a></td>
                <td>${service.service_name}</td>
                <td>${service.service_area}</td>
                <td>${service.service_cost}</td>
                <td>${service.service_max_people}</td>
                <c:forEach var="rent" items="${rentTypes}">
                    <c:if test="${rent.rent_type_id == service.rent_type_id}">
                        <td>${rent.rent_type_name}</td>
                    </c:if>
                </c:forEach>
                <c:forEach var="type" items="${requestScope['serviceTypes']}">
                    <c:if test="${type.service_type_id == service.service_type_id}">
                        <td>${type.service_type_name}</td>
                    </c:if>
                </c:forEach>
                <td>${service.standard_room}</td>
                <td>${service.description_other_convenience}</td>
                <td>${service.pool_area}</td>
                <td>${service.number_of_floors}</td>
                <td>
                    <a href="/services?action=edit&service_id=${service.service_id}">
                        <button type="button" class="btn btn-primary">Edit</button>
                    </a>
                </td>
                <td>
                    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="myFunction(${service.service_id})">
                     >Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/services?action=delete" method="post">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="myModalLabel">Accept delete customer</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Do you want to delete this employee???
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-danger btn-ok" value="Delete">
                        <input type="hidden" id="service_id" name="service_id">
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.slim.js"
        integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
        integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
        crossorigin="anonymous"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableService').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
<script>
   function myFunction(id) {
        document.getElementById("service_id").value = id;
   }
</script>
</body>
</html>
