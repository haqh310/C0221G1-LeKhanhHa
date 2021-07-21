<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 5/27/2021
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<jsp:include page="../../common/header.jsp"></jsp:include >
<div class="container-fluid border pt-5 mt-5">
    <h1>List Customer</h1>
    <p><a href="/index.jsp">Back to menu</a></p>
    <div class="row">
        <div class="col-6">
            <p><a href="/customers?action=create">Create new customer</a></p>
        </div>
        <div class="col-6 d-flex justify-content-end">
            <form action="/customers?action=search" method="post">
                <input type="text" name="customer_name" placeholder="Enter name...">
                <input type="submit" value="Search">
            </form>
        </div>
    </div>
    <table id="tableCustomer" class="table table-bordered table-striped ">
        <thead>
        <tr>
            <th>STT</th>
            <th>Code</th>
            <th>Customer Type</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Show</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="customer" varStatus="stt">
            <tr>
                <td>${stt.index}</td>
                <td>${customer.customer_code}</td>
                <c:forEach var="type" items="${customerTypes}">
                    <c:if test="${type.customer_type_id == customer.customer_type_id}">
                        <td>${type.customer_type_name}</td>
                    </c:if>
                </c:forEach>
                <td>${customer.customer_name}</td>
                <td>${customer.customer_birthday}</td>
                <td>${customer.customer_gender}</td>
                <td>${customer.customer_phone}</td>
                <td>${customer.customer_email}</td>
                <td>${customer.customer_address}</td>
                <td><a href="/customers?action=view&customer_id=${customer.customer_id}">
                    <button type="button" class="btn btn-primary">Show</button>
                </a>
                <td><a href="/customers?action=edit&customer_id=${customer.customer_id}">
                    <button type="button" class="btn btn-primary">Edit</button>
                </a>
                </td>
                <td>
                    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="myFunction(${customer.customer_id})">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/customers?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="myModalLabel">Accept delete customer</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Do you want to delete this customer???
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger btn-ok" id="delete" value="Delete">
                    <input type="hidden" id="customer_id" name="customer_id">
                </div>
            </div>
        </form>

    </div>
</div>
<c:if test="${message != null}">
    <input type="hidden" id="message" value="${message}">
    <script>
        let message = document.getElementById("message").value;
        alert(message);
    </script>
</c:if>
<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
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
        $('#tableCustomer').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
<script type="text/javascript">
    function myFunction(id){
        document.getElementById("customer_id").value=id;
    }

</script>
</body>
</html>
