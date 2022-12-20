<%@page import="bean.donghobean"%>
<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Admin</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
		* {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
  }
  html {
    color: #333;
    font-size: 62.5%;
    font-family: "Open Sans", sans-serif;
  }
  .main {
    background: #f1f1f1;
    min-height: 100vh;
    display: flex;
    justify-content: center;
  }
  .form {
    width: 360px;
    min-height: 100px;
    padding: 32px 24px;
    text-align: center;
    background: #fff;
    border-radius: 2px;
    margin: 24px;
    align-self: center;
    box-shadow: 0 2px 5px 0 rgba(51, 62, 73, 0.1);
  }
  .form .heading {
    font-size: 2rem;
  }
  .form .desc {
    text-align: center;
    color: #636d77;
    font-size: 1.6rem;
    font-weight: lighter;
    line-height: 2.4rem;
    margin-top: 16px;
    font-weight: 300;
  }
  
  .form-group {
    display: flex;
    margin-bottom: 16px;
    flex-direction: column;
  }
  
  .form-label,
  .form-message {
    text-align: left;
  }
  
  .form-label {
    font-weight: 700;
    padding-bottom: 6px;
    line-height: 1.8rem;
    font-size: 1.4rem;
  }
  
  .form-control {
    height: 40px;
    padding: 8px 12px;
    border: 1px solid #b3b3b3;
    border-radius: 3px;
    outline: none;
    font-size: 1.4rem;
  }
  
  .form-control:hover {
    border-color: #1dbfaf;
  }
  
  .form-group.invalid .form-control {
    border-color: #f33a58;
  }
  
  .form-group.invalid .form-message {
    color: #f33a58;
  }
  
  .form-message {
    font-size: 1.2rem;
    line-height: 1.6rem;
    padding: 4px 0 0;
  }
  
  .form-submit {
    outline: none;
    background-color: #1dbfaf;
    margin-top: 12px;
    padding: 12px 16px;
    font-weight: 600;
    color: #fff;
    border: none;
    width: 100%;
    font-size: 14px;
    border-radius: 8px;
    cursor: pointer;
  }
  
  .form-submit:hover {
    background-color: #1ac7b6;
  }
  
  .spacer {
    margin-top: 36px;
  }
  .link-register {
  	color: #000;
  	display: block;
  	font-size: 14px;
  	margin-top: 12px;
  	text-decoration: none;
  }
  
  .link-register:hover {
  	color: #1d4bbf;
  }
	</style>
</head>
<body>
	<% 	
		String errorMessage = (String) request.getAttribute("thatbai");
		if (errorMessage != null){
			%>
			<script type="text/javascript">alert("Sửa đồng hồ thất bại")</script>
			
		<%response.sendRedirect("hienthidonghoadmin"); } %>
	<% request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8"); %>
	<%
		donghobean dh = (donghobean) request.getAttribute("dongho");
	%>
	<div class="main">
		<form action="suadongho?anh=<%=dh.getAnh() %>" method="post" class="form" id="form-1" enctype="multipart/form-data">
		<h3 class="heading">Sửa đồng hồ</h3>
      
          <div class="spacer"></div>
      
          <div class="form-group">
            <label for="txtmadongho" class="form-label">Mã đồng hồ</label>
            <input id="txtmadongho" name="txtmadongho" type="text" placeholder="VD:DH100" class="form-control" value="<%=dh.getMaDongHo() %>">
            <span class="form-message"></span>
          </div>
      
          <div class="form-group">
            <label for="txttendongho" class="form-label">Tên đồng hồ</label>
            <input id="txttendongho" name="txttendongho" type="text" placeholder="Đồng hồ ABC" class="form-control" value="<%=dh.getTenDongHo() %>">
            <span class="form-message"></span>
          </div>
          <div class="form-group">
            <label for="maloai" class="form-label">Mã loại</label>
            <select  class="form-control" required name="maloai">
            	<%
				
				ArrayList<loaibean> loai = (ArrayList<loaibean>)request.getAttribute("dsloai");
					for(loaibean l: loai){%>
						<option value=<%=l.getMaLoai() %>><%=l.getTenLoai() %></option>
					<%
					}
				%>
            </select>
            <span class="form-message"></span>
          </div>
          <div class="form-group">
            <label for="txtsoluong" class="form-label">Số lượng</label>
            <input id="txtsoluong" name="txtsoluong" type="number" min="1" placeholder="Nhập số lượng" class="form-control" value="<%=dh.getSoLuong() %>">
            <span class="form-message"></span>
          </div>
          <div class="form-group">
            <label for="txtgia" class="form-label">Giá</label>
            <input id="txtgia" name="txtgia" type="text" min="1000" placeholder="Nhập giá" class="form-control" value="<%=dh.getGia() %>">
            <span class="form-message"></span>
          </div>
          <div class="form-group">
            <label for="txtxuatxu" class="form-label">Xuất xứ</label>
            <input id="txtxuatxu" name="txtxuatxu" type="text" placeholder="Nhập xuất xứ" class="form-control" value="<%=dh.getXuatXu() %>">
            <span class="form-message"></span>
          </div>
           <div class="form-group">
           		<label class="control-label col-sm-2" for="pwd" style="margin-top: 10px">Ảnh:</label>
          		<input type="file" class="form-control" id="pwd" placeholder="Chọn ảnh" name="txtanh" accept="image/png, image/jpeg" required>
           </div>
           <div class="form-group">
            <label for="txtngaynhap" class="form-label">Ngày nhập</label>
            <input id="txtngaynhap" name="txtngaynhap" type="date" placeholder="Chọn ngày" class="form-control">
            <span class="form-message"></span>
          </div> 
      
          <button class="form-submit">Sửa</button>
	</form>
	</div>
	
</body>
</html>