<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 6/10/2021
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit product</title>
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="row">
    <div class="container d-flex justify-content-center">
        <div class="col-6 d-flex flex-column">
            <h1>Edit product</h1>
            <c:if test="${message != null}">
                <span class="text-primary">${message}</span>
            </c:if>
            <form action="/products?action=edit&id=${sanPham.id}" method="post" class="container border border-dark mb-3 pt-3">
                <div class="form-group">
                    <label>ID:</label>
                    <input type="text" class="form-control" name="id" value="${sanPham.id}" disabled>
                </div>
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" class="form-control"  name="ten" value="${sanPham.ten}" >
                </div>
                <div class="form-group">
                    <label>Price:</label>
                    <input type="number" class="form-control" name="gia" value="${sanPham.gia}"  >
                </div>
                <div class="form-group">
                    <label>Quantity:</label>
                    <input type="number" class="form-control" name="soLuong" value="${sanPham.soLuong}"  >
                </div>
                <div class="form-group">
                    <label>Color:</label>
                    <input type="text" class="form-control" name="mauSac" value="${sanPham.mauSac}"  >
                </div>
                <div class="form-group">
                    <label>Description:</label>
                    <textarea type="text" rows="4" class="form-control" name="moTa" >${sanPham.moTa}</textarea>
                </div>
                <div>
                    <label>Category: </label>
                    <select class="form-control" name="idDanhMuc">
                        <c:forEach var="danhMuc" items="${danhMucs}">
                            <option value="${danhMuc.id}" ${danhMuc.id == sanPham.idDanhMuc? "selected" :""}>${danhMuc.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="d-flex my-3 2">
                    <button type="submit" class="btn btn-success mr-2">Update</button>
                    <span class="mr-2"> | </span>
                    <a href="/products">
                        <button type="button" class="btn btn-dark " >Back</button>
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="../bootstrap/jquery-3.6.0.min.js"></script>
<script src="../bootstrap/popper.min.js"></script>
<script src="../bootstrap/bootstrap.min.js"></script>
</body>
</html>
