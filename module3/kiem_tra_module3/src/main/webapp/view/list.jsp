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
    <title>List Product</title>
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="container border pt-5 mt-5">
    <h1>List Product</h1>
    <div class="row">
        <div class="col-6">
            <a href="/products?action=create">
                <button class="btn btn-info">+ Add new product</button>
            </a>
        </div>
        <div class="col-6 d-flex justify-content-end">
            <form action="/products?action=search" method="post">
                <input type="text" name="ten" placeholder="Enter name...">
                <input class="btn btn-primary" type="submit" value="Search">
            </form>
        </div>
        <div class="col-12 d-flex justify-content-end">
            <c:if test="${msgSearch != null}">
                <p class="h4 text-secondary">${msgSearch} result by "${msgTen}"</p>
            </c:if>
        </div>
    </div>
    <table id="tableNhanVien" class="table table-hover table-bordered table-striped my-2">
        <thead>
        <tr>
            <th>#</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sanPhams}" var="sanPham" varStatus="stt">
            <tr>
                <td>${stt.index+1}</td>
                <td>${sanPham.ten}</td>
                <td>${sanPham.gia}</td>
                <td>${sanPham.soLuong}</td>
                <td>${sanPham.mauSac}</td>
                <c:forEach items="${danhMucs}" var="danhMuc">
                    <c:if test="${danhMuc.id == sanPham.idDanhMuc}">
                        <td>${danhMuc.ten}</td>
                    </c:if>
                </c:forEach>
                <td>
                    <a href="/products?action=edit&id=${sanPham.id}">
                        <button type="button" class="btn btn-info">Edit</button></a>
                    <span> | </span>
                    <button class="btn btn-danger" data-toggle="modal" data-target="#myModal"
                            onclick="myFunction(${sanPham.id})">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/products?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="myModalLabel">Accept delete</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Do you want to delete this product???
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
<script src="../bootstrap/jquery-3.6.0.min.js"></script>
<script src="../bootstrap/popper.min.js"></script>
<script src="../bootstrap/bootstrap.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableNhanVien').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
<script type="text/javascript">
    function myFunction(id) {
        document.getElementById("id").value = id;
    }

</script>
</body>
</html>

