<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 5/28/2021
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List Employees</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="container-fluid border pt-5 mt-5">
    <h1>List Employee</h1>
    <p><a href="index.jsp">Back to menu</a></p>
    <div class="row">
        <div class="col-6">
            <p> <a href="/employees?action=create">Create new employee</a></p>
        </div>
        <div class="col-6 d-flex justify-content-end">
            <form action="/employees?action=search" method="post">
                <input type="text" name="employee_name" placeholder="Enter name...">
                <input type="submit" value="Search">
            </form>
        </div>
    </div>
    <table id="tableEmployee" class="table table-bordered table-striped" >
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>ID Card</th>
            <th>Salary</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Position</th>
            <th>Education Degree</th>
            <th>Division</th>
            <th>Username</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope['employees']}" var="employee">
            <tr>
                <td><a href="/employees?action=view&employee_id=${employee.employee_id}">${employee.employee_id}</a></td>
                <td id="name">${employee.employee_name}</td>
                <td>${employee.employee_birthday}</td>
                <td>${employee.employee_id_card}</td>
                <td>${employee.employee_salary}</td>
                <td>${employee.employee_phone}</td>
                <td>${employee.employee_email}</td>
                <td>${employee.employee_address}</td>
                <c:forEach var="position" items="${requestScope['positions']}">
                    <c:if test="${position.position_id == employee.position_id}">
                        <td>${position.position_name}</td>
                    </c:if>
                </c:forEach>
                <c:forEach var="education" items="${educationDegrees}">
                    <c:if test="${education.education_degree_id == employee.education_degree_id}">
                        <td>${education.education_degree_name}</td>
                    </c:if>
                </c:forEach>
                <c:forEach var="division" items="${divisions}">
                    <c:if test="${division.division_id == employee.division_id}">
                        <td>${division.division_name}</td>
                    </c:if>
                </c:forEach>
                <td>${employee.username}</td>
                <td>
                    <a href="/employees?action=edit&employee_id=${employee.employee_id}">
                        <button type="button" class="btn btn-primary">Edit</button>
                    </a>
                </td>
                <td>
                    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick=" myFunction(${employee.employee_id})">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/employees?action=delete" method="post">
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
                        <input type="hidden" id="employee_id" name="employee_id">
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
        $('#tableEmployee').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
<script>
    function myFunction(id){
        document.getElementById("employee_id").value=id;
    }
</script>
</body>
</html>
