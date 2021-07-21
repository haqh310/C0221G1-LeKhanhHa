<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 6/1/2021
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List customer use service</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="container border pt-5 mt-5">
    <h1>List Customer use service</h1>
    <p><a href="/index.jsp">Back to menu</a></p>
    <div class="row">
        <div class="col-6">
            <p><a href="/contracts?action=create_contract"> Create new contract</a></p>
            <p><a href="/contracts?action=create_contract_detail"> Create new contract detail</a></p>
        </div>
        <div class="col-6 d-flex justify-content-end">
            <form action="/contracts?action=search" method="post">
                <input type="text" name="customer_name" placeholder="Enter name...">
                <input type="submit" value="Search">
            </form>
        </div>
    </div>
    <table id="tableList" class="table table-bordered table-striped ">
        <thead>
        <tr>
            <th>ID</th>
            <th>Customer Name</th>
            <th>Employee</th>
            <th>Service </th>
            <th>Attach Service</th>
            <th>Total Money</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCustomer}" var="list">
            <tr>
                <td>${list[0]}</td>
                <td>${list[1]}</td>
                <td>${list[2]}</td>
                <td>${list[3]}</td>
                <td>${list[4]}</td>
                <td>${list[5]}</td>
                <td>${list[6]}</td>
                <td>${list[7]}</td>
                <td><a href="/contracts?action=edit&contract_id=${contract.contract_id}">
                    <button type="button" class="btn btn-primary">Edit</button>
                </a>
                </td>
                <td>
                    <a class="delete" data-toggle="modal" data-target="#myModal">
                        <button type="button" class="btn btn-primary">Delete</button>
                    </a>
                    <input type="hidden" id="id" value="${customer.customer_id}">
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
        $('#tableList').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>

<script type="text/javascript">
    $(document).ready(function () {
        $('.delete').on('click', function () {
            let id = $(this).parent('td').find('#id').val();
            $('#customer_id').val(id);
        });
    });
</script>
</body>
</html>
