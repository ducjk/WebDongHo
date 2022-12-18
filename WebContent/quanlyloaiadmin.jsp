
<%@page import="bean.adminbean"%>
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
      
      <li class="active"><a href="loaiadmin">Quản lý loại</a></li>
      <li><a href="hienthidonghoadmin">Quản lý sách</a></li>
      <li><a href="xacnhanadmin">Xác nhận</a></li>
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
<div style="margin: 20px auto;">
	<div style="margin: 0 0 20px 40px; border: 1px solid rgba(0, 0, 0, 0.1); width: 400px;padding: 20px;" >
		<h3>Thêm loại</h3>
		<form action="loaiadmin" method ="post">
			<%request.setCharacterEncoding("utf-8");
						response.setCharacterEncoding("uft-8"); %>
			 <label style="width: 100px;">Mã loại</label><input type="text" name="txtml"><br>
			 <label style="width: 100px;">Tên loại</label><input type="text" name="txttl"><br>
			 <input type="submit" name="add" value="Thêm" style="padding: 4px 20px; background-color: #1dbfaf; color: #fff;font-weight:600; border: 1px solid #ccc; border-radius: 8px;font-size: 18px;">
			
		</form>
	</div>
	<table width="1000" align="center" style="margin: 0 auto;">
			<tr>
			<td>Mã Loại</td>
			<td>Tên Loại</td>
			</tr>
<%				
				
				//loaibo loai = new loaibo();
				ArrayList<loaibean> loai = (ArrayList<loaibean>)request.getAttribute("dsloai");
					for(loaibean l: loai){%> 
					<form action="loaiadmin?update=<%=l.getMaLoai() %>" method="post">
						<tr>
						<td ><%=l.getMaLoai() %></td>
						<td>
							<input type="text" name="suacmn" value="<%=l.getTenLoai()%>" style="border: none;"/>
						</td>
						<td> <a href="loaiadmin?ml=<%=l.getMaLoai()%> &remove=1">Xóa</a>
						<td>
							<input type="submit" value="Cập nhật"/>
						</td>
						</tr>
					</form>	
						
					<%
					}
				%>	


	  
	</table>
</div>

</body>
</html>
