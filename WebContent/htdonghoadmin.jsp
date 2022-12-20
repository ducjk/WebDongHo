<%@page import="bean.donghobean"%>
<%@page import="bean.adminbean"%>
<%@page import="bo.giohangbo"%>
<%@page import="bo.loaibo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.loaibean"%>
<%@page import="dao.loaidao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
  td {
  	padding: 10px;
  }
  .activities-item {
  	width: 240px;
  	display: flex;
  	justify-content: space-between;
  }
  .sub-item {
  font-weight:400;
  	font-size: 16px;
  	color: blue;
  	padding: 4px 8px;
  	background-color: rgba(0,0,0,0.3);
  	border-radius: 6px;
  	cursor: pointer;
  }
  .sub-item:hover {
	background-color: rgba(0,0,0,0.2);
}
  </style>
</head>
<body>
			<% 	
		String errorMessage = (String) request.getAttribute("themdonghothanhcong");
		if (errorMessage != null){
			%>
			<script type="text/javascript">alert("Thêm đồng hồ thành công")</script>
			
		<% }
	%>	
		<% 	
		String errorMessage1 = (String) request.getAttribute("xoadongho");
		if (errorMessage1 != null){
			%>
			<script type="text/javascript">alert("Xóa đồng hồ thành công")</script>
			
		<% }
	%>	
	<% 	
		String errorMessage2 = (String) request.getAttribute("xoathatbai");
		if (errorMessage2 != null){
			%>
			<script type="text/javascript">alert("Xóa đồng hồ thất bại")</script>
			
		<% }
	%>	
	<% 	
		String errorMessage3 = (String) request.getAttribute("suadongho");
		if (errorMessage3 != null){
			%>
			<script type="text/javascript">alert("Sửa thông tin đồng hồ thành công")</script>
			
		<% }
	%>	
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li ><a href="admin">Trang chủ</a></li>
      
      <li ><a href="loaiadmin">Quản lý loại</a></li>
      <li class="active"><a href="hienthidonghoadmin">Quản lý đồng hồ</a></li>
      <li><a href="xacnhanadmin">Xác nhận</a></li>
      <li><a href="danhsachchuyentien">danh sách chuyển tiền</a></li>
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
	<div>
	<a href="quanlydongho?them=true" style="text-decoration: none; font-size:20px; font-weight: 400; color: blue; display:inline-block; padding: 10px 20px; background-color: rgba(0, 0, 0, 0.1);margin-bottom: 20px;">Thêm Đồng hồ</a>
	<div class="container" style="width:1200px;">
		<div class="container-fluid container" style="display: flex;padding: 0;">
		    <ul class="list-group list-item" style="list-style: none;width: 180px;margin-right:40px;">
				<%
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				//loaibo loai = new loaibo();
				ArrayList<loaibean> loai = (ArrayList<loaibean>)request.getAttribute("dsloai");
					for(loaibean l: loai){%>
						<li class="" style="width: 180px;"><a class="list-group-item" href="hienthidonghoadmin?ml=<%=l.getMaLoai()%>">
						<%=l.getTenLoai()%></a></li>
					<%
					}
				%>
		    </ul>
		    
		    <div>
		     	<%
		     		ArrayList<donghobean> dsdongho = (ArrayList<donghobean>) session.getAttribute("dsdonghoadmin");
		     		if (dsdongho.size() == 0){
		     	%>
		     			<h3>Danh sách đồng hồ rỗng</h3>
		     		<%}else{%>
		    		<table width="960px" style="padding: 0 15px;" border: none;>
		   		
		   		 <%   	
		   		   		 //}
		   		    //}
		   				//ArrayList<sachbean> dssach = (ArrayList<sachbean>)request.getAttribute("dssach");
		   		   
			   		    int n = dsdongho.size();
			   		    for(int i=0;i<n;i++){
			   		    	donghobean s = dsdongho.get(i);
			   		%>
			   		     <tr style="height: 380px;">
				   		      <td width="240px" style="border: 1px solid #ccc;border-radius: 6px;" >
					   		  	 <img style="border-radius: 6px; width: 200px; height: 240px; object-fit: cover;" src="<%=s.getAnh() %>"> <br>
					   		     <span style="width: 220px;height: 20px;display: block;overflow: hidden;text-overflow: ellipsis;"><%=s.getTenDongHo() %></span> <br>
					   		     <%=s.getGia() %><br>
					   		     Xuất xứ: <%=s.getXuatXu() %><br>
					   		     <span class="activities-item">
					   		     	<a href="quanlydongho?sua=true&madongho=<%=s.getMaDongHo()%>&tendongho=<%=s.getTenDongHo() %>&gia=<%=s.getGia()%>&soluong=<%=s.getSoLuong()%>&maloai=<%=s.getMaLoai()%>&xuatxu=<%=s.getXuatXu()%>&anh=<%=s.getAnh()%>" class="sub-item">Cập nhật</a>
					   		     	<a href="quanlydongho?xoa=true&madongho=<%=s.getMaDongHo() %>" class="sub-item">Xóa</a>
					   		     </span>
					   		  </td>
				   		   
				   		   	  <% i++; 
				   		   	  if(i<n){
				   		      		s = dsdongho.get(i);%>
				   		     		<td width="240px" style="border: 1px solid #ccc;border-radius: 6px;" >
					   		  	 <img style="border-radius: 6px; width: 200px; height: 240px; object-fit: cover;" src="<%=s.getAnh() %>"> <br>
					   		     <span style="width: 220px;height: 20px;display: block;overflow: hidden;text-overflow: ellipsis;"><%=s.getTenDongHo() %></span> <br>
					   		     <%=s.getGia() %><br>
					   		     Xuất xứ: <%=s.getXuatXu() %><br>
					   		     <span class="activities-item">
					   		     	<a href="quanlydongho?sua=true&madongho=<%=s.getMaDongHo()%>&tendongho=<%=s.getTenDongHo() %>&gia=<%=s.getGia()%>&soluong=<%=s.getSoLuong()%>&maloai=<%=s.getMaLoai()%>&xuatxu=<%=s.getXuatXu()%>&anh=<%=s.getAnh()%>" class="sub-item">Cập nhật</a>
					   		     	<a href="quanlydongho?xoa=true&madongho=<%=s.getMaDongHo() %>" class="sub-item">Xóa</a>
					   		     </span>
					   		  </td>
					   		
				   		     <%} %>
				   		     <% i++; 
				   		   	  if(i<n){
				   		      		s = dsdongho.get(i);%>
				   		     		<td width="240px" style="border: 1px solid #ccc;border-radius: 6px;" >
					   		  	 <img style="border-radius: 6px; width: 200px; height: 240px; object-fit: cover;" src="<%=s.getAnh() %>"> <br>
					   		     <span style="width: 220px;height: 20px;display: block;overflow: hidden;text-overflow: ellipsis;"><%=s.getTenDongHo() %></span> <br>
					   		     <%=s.getGia() %><br>
					   		     Xuất xứ: <%=s.getXuatXu() %><br>
					   		     <span class="activities-item">
					   		     	<a href="quanlydongho?sua=true&madongho=<%=s.getMaDongHo()%>&tendongho=<%=s.getTenDongHo() %>&gia=<%=s.getGia()%>&soluong=<%=s.getSoLuong()%>&maloai=<%=s.getMaLoai()%>&xuatxu=<%=s.getXuatXu()%>&anh=<%=s.getAnh()%>" class="sub-item">Cập nhật</a>
					   		     	<a href="quanlydongho?xoa=true&madongho=<%=s.getMaDongHo() %>" class="sub-item">Xóa</a>
					   		     </span>
					   		  </td>
					   		
				   		     <%} %>
				   		     <% i++; 
				   		   	  if(i<n){
				   		      		s = dsdongho.get(i);%>
				   		     		<td width="240px" style="border: 1px solid #ccc;border-radius: 6px;" >
					   		  	 <img style="border-radius: 6px; width: 200px; height: 240px; object-fit: cover;" src="<%=s.getAnh() %>"> <br>
					   		     <span style="width: 220px;height: 20px;display: block;overflow: hidden;text-overflow: ellipsis;"><%=s.getTenDongHo() %></span> <br>
					   		     <%=s.getGia() %><br>
					   		     Xuất xứ: <%=s.getXuatXu() %><br>
					   		     <span class="activities-item">
					   		     	<a href="quanlydongho?sua=true&madongho=<%=s.getMaDongHo()%>&tendongho=<%=s.getTenDongHo() %>&gia=<%=s.getGia()%>&soluong=<%=s.getSoLuong()%>&maloai=<%=s.getMaLoai()%>&xuatxu=<%=s.getXuatXu()%>&anh=<%=s.getAnh()%>" class="sub-item">Cập nhật</a>
					   		     	<a href="quanlydongho?xoa=true&madongho=<%=s.getMaDongHo() %>" class="sub-item">Xóa</a>
					   		     </span>
					   		  </td>
					   		
				   		     <%} %>
				   		  </tr>
				   	<%}} %>
				   	
				   	
		   		   
	   		 </table>
		    </div>
		    
		</div>
		
	</div>
	</div>
	
	
</body>
</html>