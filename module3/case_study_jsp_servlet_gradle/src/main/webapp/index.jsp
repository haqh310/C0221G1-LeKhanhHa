<%--
  Created by IntelliJ IDEA.
  User: haqh310
  Date: 6/3/2021
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Furama Resort</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include >
<div class="row">
  <nav class="container-fluid navbar navbar-expand-lg bg-success">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto h5">
        <li class="nav-item active px-5 h4">
          <a class="nav-link text-white" href="">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item px-5">
          <a class="nav-link text-white" href="/employees">Employee</a>
        </li>
        <li class="nav-item px-5">
          <a class="nav-link text-white" href="/customers">Customer</a>
        </li>
        <li class="nav-item px-5">
          <a class="nav-link text-white" href="/services">Service</a>
        </li>
        <li class="nav-item px-5">
          <a class="nav-link text-white" href="/contracts">Contract</a>
        </li>
      </ul>
      <form class="form-inline my-2 my-lg-0 mr-3">
        <input class="form-control mr-sm-2" type="search" placeholder="Search..." aria-label="Search">
        <button class="btn btn-warning btn-outline-dark my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>
</div>
<div class="row">
  <div class="container-fluid px-5 d-flex flex-wrap mt-5">
    <div class="col-4 pt-2 px-4">
      <p class=" h3 text-warning">
        KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI, FURAMA ĐÀ NẴNG, NỔI TIẾNG LÀ KHU NGHỈ DƯỠNG ẨM THỰC TẠI VIỆT NAM.
      </p>
    </div>
    <div class="col-4 d-flex justify-content-center">
      <a href="https://www.youtube.com/watch?v=IjlT_4mvd-c">
        <img width="370" height="280"
             src="https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior_Beach.jpg">
      </a>
    </div>
    <div class="col-4 pt-2 px-4">
      <p>Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama Resort
        Đà Nẵng là cửa ngõ đến với 3 di sản văn hoá thế giới: Hội An
        (20 phút), Mỹ Sơn (90 phút) và Huế (2 tiếng. 196 phòng
        hạng sang cùng với 70 căn biệt thự từ hai đến bốn phòng
        ngủ có hồ bơi riêng đều được trang trí trang nhã, theo
        phong cách thiết kế truyền thống của Việt Nam và kiến trúc
        thuộc địa của Pháp, biến Furama thành khu nghỉ dưỡng danh
        giá nhất tại Việt Nam – vinh dự được đón tiếp nhiều người
        nổi tiếng, giới hoàng gia, chính khách, ngôi sao điện ảnh và
        các nhà lãnh đạo kinh doanh quốc tế.
      </p>
    </div>
  </div>
</div>
<div class="row">
  <div class="container d-flex flex-wrap justify-content-center w-50 mt-5">
    <h3 class="text-warning">CÁC LOẠI PHÒNG</h3>
    <p>
      Khu nghỉ dưỡng có 196 phòng được thiết kế theo phong cách truyền thống Việt Nam kết
      hợp với phong cách Pháp, 2 tòa nhà 4 tầng có hướng nhìn ra biển, nhìn ra hồ bơi trong xanh
      và những khu vườn nhiệt đới xanh tươi mát. Ngoài ra, khu nghỉ dưỡng Furama còn cung cấp
      các liệu pháp spa, phòng xông hơi ướt, phòng xông hơi khô, dịch vụ mát-xa cạnh hồ bơi, các
      dịch vụ thể thao dưới nước và các lớp tập yoga và Thái Cực Quyền trên bãi biển.
    </p>
  </div>
</div>
<div class="row">
  <div class="container-fluid mx-5 mt-3 pt-3 border border-dark-0">
    <div id="myCarousel" class="carousel slide" data-ride="carousel" >
      <div class="carousel-inner container-fluid">
        <div class="carousel-item active ">
          <div class="container d-flex justify-content-center align-items-center">
            <div class="col-6">
              <h2 class="text-warning">ẨM THỰC</h2>
              <p>Trải nghiệm ẩm thực tại Khu nghỉ có sự pha trộn độc đáo các món ăn truyền
                thống Việt Nam với nhiều những hương vị ẩm thực châu Á, Ý và châu Âu cùng các
                món bò nhập khẩu thượng hạng tại đa dạng các nhà hàng, quầy bar đẳng cấp được
                bao quanh bởi một khu vườn nhiệt đới hay hướng mình ra biển, đón…</p>
              <button class="bg-success btn-lg text-white"> XEM THÊM</button>
            </div>
            <div class="col-6">
              <img class="img-fluid"
                   src="https://furamavietnam.com/wp-content/uploads/2018/07/CULIRARY.jpg">
            </div>
          </div>
        </div>
        <div class="carousel-item">
          <div class="container d-flex justify-content-center align-items-center">
            <div class="col-6">
              <h2 class="text-warning">GIẢI TRÍ</h2>
              <p>Biến kỳ nghỉ dưỡng năng động hơn bằng cách tham gia các hoạt động thể thao trên nước từ
                chèo thuyền catamaran, lướt ván buồm, chèo thuyền trên biển, lướt vát, đi xe đạp nước,
                trượt nước, lướt ván, chuối, dù lượn và đa dạng các hoạt động.</p>
              <button class="bg-success btn-lg text-white"> XEM THÊM</button>
            </div>
            <div class="col-6">
              <img class="img-fluid"
                   src="https://furamavietnam.com/wp-content/uploads/2018/07/RECREATION.jpg">
            </div>
          </div>
        </div>
        <div class="carousel-item">
          <div class="container d-flex justify-content-center align-items-center">
            <div class="col-6">
              <h2 class="text-warning">SỰ KIỆN</h2>
              <p>Cung hội nghị Quốc tế International Convention Palace (ICP) với phòng Hội nghị lớn
                sức chứa lên tới 1000 khách cùng hơn 10 phòng chức năng phụ trợ quy mô từ 50 đến
                300 khách được trang bị cơ sở vật chất, thiết bị hiện đại, là địa điểm lý tưởng dành
                cho các đoàn MICE tổ chức hội nghị, hội thảo và sự kiện..</p>
              <button class="bg-success btn-lg text-white"> XEM THÊM</button>
            </div>
            <div class="col-6">
              <img class="img-fluid bg-success"
                   src="https://furamavietnam.com/wp-content/uploads/2018/10/02.-ICP-ICP_Furama_Danang_-Ball-Room-4.jpg">
            </div>
          </div>
        </div>
      </div>
      <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
  </div>
</div>
<div class="row">
  <div class="container d-flex justify-content-center mt-3">
    <p>© 2018 Furama Resort Danang.</p>
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
  setTimeout(function () {
    $('.alert').fadeOut('slow');
  }, 3000);
</script>
</body>
</html>
