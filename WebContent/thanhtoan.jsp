<%@page import="bo.giohangbo"%>
<%@page import="bean.khachhangbean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>AJax</title>
	<meta charset="utf-8">
<title>Insert title here</title>
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
  
  .total {
  	font-size: 20px;
  	color: red;
  }
	</style>
</head>
<body>
	<% request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("uft-8");
	khachhangbean kh = (khachhangbean) session.getAttribute("khachhang");
		giohangbo gh = (giohangbo) session.getAttribute("gio");
	%>
	
	<div class="main">

        <form action="thanhtoan" method="post" class="form" id="form-1">
          <h3 class="heading">Thanh Toán</h3>
      
          <div class="spacer"></div>
      
          <div class="form-group">
            <label for="fullname" class="form-label">Họ và tên</label>
            <input id="fullname" name="fullname" type="text" placeholder="VD:Duc Huynh" class="form-control" value="<%=kh != null ? kh.getHoten(): "" %>">
            <span class="form-message"></span>
          </div>
      
          <div class="form-group">
            <label for="email" class="form-label">Email</label>
            <input id="email" name="email" type="text" placeholder="VD: email@domain.com" class="form-control" value="<%=kh != null ? kh.getEmail() : "" %>">
            <span class="form-message"></span>
          </div>
      
      	  <div class="form-group">
            <label for="address" class="form-label">Địa chỉ</label>
            <input id="address" name="address" type="text" placeholder="31 An Duong Vuong, Huế" class="form-control" value="<%=kh != null ? kh.getDiachi() : "" %>">
            <span class="form-message"></span>
          </div>
      
          <div class="form-group">
            <label for="phone" class="form-label">SĐT</label>
            <input id="phone" name="phone" type="phone" placeholder="09XXXXXX" class="form-control" value="<%=kh != null ? kh.getSdt() : "" %>">
            <span class="form-message"></span>
          </div>
          <span class="total">Tổng Tiền: <strong><%=gh.TongTien() %></strong></span>
      
          <button class="form-submit">Thanh toán</button>
        </form>
      
      </div>
</body>
</html>