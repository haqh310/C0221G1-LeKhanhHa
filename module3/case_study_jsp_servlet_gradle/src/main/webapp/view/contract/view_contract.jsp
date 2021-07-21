<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 6/3/2021
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Show Contract</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<jsp:include page="../../common/header.jsp"></jsp:include >
<div class="container border pt-5 mt-5">
    <h1>Show contract</h1>
    <p><a href="/index.jsp">Back to menu</a></p>
    <div class="row">
        <div class="col-6">
            <p><a href="/contract_details?action=create&contract_id=${contract.contract_id}"> Create new contract detail</a></p>
        </div>
    </div>
    <table id="tableList" class="table table-bordered table-striped ">
        <thead>
        <tr>
            <th>ID</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Deposit</th>
            <th>Total money</th>
            <th>Employee</th>
            <th>Customer</th>
            <th>Service</th>
            <th>Edit</th>
            <th>Show detail</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${contract.contract_id}</td>
                <td>${contract.contract_start_date}</td>
                <td>${contract.contract_end_date}</td>
                <td>${contract.contract_deposit}</td>
                <td>${contract.contract_total_money}</td>
                <c:forEach var="employee" items="${employees}">
                    <c:if test="${employee.employee_id == contract.employee_id}">
                        <td>${employee.employee_name}</td>
                    </c:if>
                </c:forEach>
                <c:forEach var="customer" items="${customers}">
                    <c:if test="${customer.customer_id == contract.customer_id}">
                        <td>${customer.customer_name}</td>
                    </c:if>
                </c:forEach>
                <c:forEach var="service" items="${services}">
                    <c:if test="${service.service_id == contract.service_id}">
                        <td>${service.service_name}</td>
                    </c:if>
                </c:forEach>
                <td><a href="/contracts?action=edit&contract_id=${contract.contract_id}">
                    <button type="button" class="btn btn-primary">Edit</button></a>
                </td>
                <td><a href="/contract_details?action=view&contract_id=${contract.contract_id}">
                    <button type="button" class="btn btn-primary">Show Detail</button></a>
                </td>
            </tr>
        </tbody>
    </table>
</div>
<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/contracts?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="myModalLabel">Accept delete contract</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Do you want to delete this contract???
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger btn-ok" id="delete" value="Delete">
                    <input type="hidden" id="contract_id" name="contract_id">
                </div>
            </div>
        </form>

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
