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
  </style>
</head>
<body>
				
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li ><a href="admin">Trang chủ</a></li>
      
      <li ><a href="loaiadmin">Quản lý loại</a></li>
      <li class="active"><a href="hienthidonghoadmin">Quản lý sách</a></li>
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
	<a href="quanlydongho" style="text-decoration: none; font-size:20px; font-weight: 400; color: blue; display:inline-block; padding: 10px 20px; background-color: rgba(0, 0, 0, 0.1);margin-bottom: 20px;">Thêm Đồng hồ</a>
	<div class="container">
		<div class="container-fluid container" style="display: flex; justify-content: space-between;">
		    <ul class="list-group list-item" style="list-style: none;">
				<%
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("uft-8");
				//loaibo loai = new loaibo();
				ArrayList<loaibean> loai = (ArrayList<loaibean>)request.getAttribute("dsloai");
					for(loaibean l: loai){%>
						<li class=""><a class="list-group-item" href="hienthidonghoadmin?ml=<%=l.getMaLoai()%>">
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
		    		<table width="600" style="padding: 0 15px;" border: none;>
		   		
		   		 <%   	
		   		   		 //}
		   		    //}
		   				//ArrayList<sachbean> dssach = (ArrayList<sachbean>)request.getAttribute("dssach");
		   		   
			   		    int n = dsdongho.size();
			   		    for(int i=0;i<n;i++){
			   		    	donghobean s = dsdongho.get(i);
			   		%>
			   		     <tr style="height: 380px;">
				   		      <td>
					   		  	 <img style="border-radius: 6px; width: 240px; height: 264px; object-fit: cover;" src="<%=s.getAnh() %>"> <br>
					   		     <%=s.getTenDongHo() %> <br>
					   		     <%=s.getGia() %><br>
					   		     <%=s.getXuatXu() %><br>
					   		     
					   		  </td>
				   		   
				   		   	  <% i++; 
				   		   	  if(i<n){
				   		      		s = dsdongho.get(i);%>
				   		     		<td>
							   		    <img style="border-radius: 6px; width: 240px; height: 264px; object-fit: cover;" src="<%=s.getAnh() %>"> <br>
							   		    <%=s.getTenDongHo() %> <br>
					   		     		<%=s.getGia() %><br>
					   		     		<%=s.getXuatXu() %><br>
							   		   
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