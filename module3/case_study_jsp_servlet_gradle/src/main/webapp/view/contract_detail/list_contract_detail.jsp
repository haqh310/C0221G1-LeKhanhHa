<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 6/3/2021
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List Contract Detail</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<jsp:include page="../../common/header.jsp"></jsp:include >
<div class="container border pt-5 mt-5">
    <h1>List contract detail</h1>
    <p><a href="/contracts">Back to menu</a></p>
    <div class="row">
        <div class="col-6">
            <p><a href="/contract_details?action=create&contract_id=${contract_id}"> Create new contract detail</a></p>
        </div>
    </div>
    <table id="tableContract_detail" class="table table-bordered table-striped ">
        <thead>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Attach service</th>
            <th>Quantity</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contractDetails}" var="contractDetail" varStatus="stt">
            <tr>
                <td>${stt.index}</td>
                <td>${contractDetail.contract_detail_id}</td>
                <c:forEach var="attachService" items="${attachServices}">
                    <c:if test="${attachService.attach_service_id == contractDetail.attach_service_id}">
                        <td>${attachService.attach_service_name}</td>
                    </c:if>
                </c:forEach>
                <td>${contractDetail.quantity}</td>
                <td><a href="/contract_details?action=edit&contract_detail_id=${contractDetail.contract_detail_id}">
                    <button type="button" class="btn btn-primary">Edit</button>
                </a>
                </td>
                <td>
                    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="myFunction('${contractDetail.contract_detail_id}','${contractDetail.contract_id}')">
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
        <form action="/contract_details?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="myModalLabel">Accept delete contract detail</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Do you want to delete this contract detail???
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger btn-ok" id="delete" value="Delete">
                    <input type="hidden" id="contract_detail_id" name="contract_detail_id">
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
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableContract_detail').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
<script>
    function myFunction(contract_detail_id, contract_id) {
        document.getElementById("contract_detail_id").value = contract_detail_id;
        document.getElementById("contract_id").value = contract_id;
    }
</script>
</body>
</html>
