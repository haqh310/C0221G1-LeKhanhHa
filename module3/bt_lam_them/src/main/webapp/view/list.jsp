<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 6/9/2021
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List Nhan vien</title>
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"--%>
<%--          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="../bootrap/bootstrap.min.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="container border pt-5 mt-5">
    <h1>Danh sach Nhan Vien</h1>
    <div class="row">
        <div class="col-6">
            <p><a href="/nhan_vien?action=create">Create new customer</a></p>
        </div>
    </div>
    <table id="tableNhanVien" class="table table-hover table-bordered table-striped my-2">
        <thead>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Name</th>
            <th>Ngay Sinh</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${nhanViens}" var="nhanVien" varStatus="stt">
            <tr>
                <td>${stt.index}</td>
                <td>${nhanVien.id}</td>
                <td>${nhanVien.ten}</td>
                <td>${nhanVien.ngaySinh}</td>
                <td><a href="/nhan_vien?action=edit&id=${nhanVien.id}">
                    <button type="button" class="btn btn-primary">Edit</button>
                </a>
                </td>
                <td>
                    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="myFunction(${nhanVien.id})">
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
        <form action="/nhan_vien?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="myModalLabel">Accept delete</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Do you want to delete this nhan vien???
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger btn-ok" id="delete" value="Delete">
                    <input type="hidden" id="id" name="id">
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
<script src="../bootrap/jquery-3.6.0.min.js"></script>
<script src="../bootrap/popper.min.js"></script>
<script src="../bootrap/bootstrap.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableNhanVien').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
<script type="text/javascript">
    function myFunction(id){
        document.getElementById("id").value=id;
    }

</script>
</body>
</html>

