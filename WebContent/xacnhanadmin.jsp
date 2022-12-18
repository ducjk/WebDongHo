<%@page import="bean.adminbean"%>
<%@page import="bean.xacnhanadminbean"%>
<%@page import="bean.khachhangbean"%>

<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Admin</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
  	* {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
  }
  table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
  </style>
</head>
<body>
				
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li ><a href="admin">Trang chủ</a></li>
      
      <li><a href="loaiadmin">Quản lý loại</a></li>
      <li><a href="hienthidonghoadmin">Quản lý sách</a></li>
      <li class="active"><a href="xacnhanadmin">Xác nhận</a></li>
      <li><a href="xacnhanchuyentienadmin">danh sách chuyển tiền</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li>
      <%if(session.getAttribute("admin")==null){ %>
      <a href="dangnhapadmin">
      <span class="glyphicon glyphicon-log-in"></span>
       Login
       </a>
       <%}else{ %>
       <a href="#">
	      <span class="glyphicon glyphicon-log-in"></span>
	       Hi: <%
	       adminbean kh =(adminbean) session.getAttribute("admin");
	        out.print(kh.getTenDangNhap());
	       %>
	       </a>
	       <%} %>
       </li>
    </ul>
  </div>
</nav>
<table class="table table-hover" >
   <%ArrayList<xacnhanadminbean> ds=(ArrayList<xacnhanadminbean>) request.getAttribute("ds");
     for(xacnhanadminbean xn: ds){
   %>
       <tr>
        <td>  <%=xn.getHoten() %> </td>
        <td>  <%=xn.getTendongho()%> </td>
        <td>  <%=xn.getSoLuongMua() %> </td>
        <td>  <%=xn.getGia() %> </td>
        <td>  <%=xn.getThanhTien()%> </td>
        <td>  
        <a href="xacnhanadmin?mct=<%=xn.getMaChiTietHD()%>">
           Xác nhận
        </a> </td>
        </tr>
     <%} %>  
</table>
</table>
</body>
</html>
