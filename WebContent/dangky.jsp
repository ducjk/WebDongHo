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
    border: 1px solid deepskyblue;
    border-radius: 3px;
    outline: none;
    font-size: 1.4rem;
  }
  
  .form-control:hover {
    border-color: mediumvioletred ;
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
    background-color: black;
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
    background-color: gray;
  }
  
  .spacer {
    margin-top: 36px;
  }
	</style>
</head>
<body>
	<% 	
		String errorMessage = (String) request.getAttribute("Themthatbai");
		if (errorMessage != null){
			%>
			<script type="text/javascript">alert("Thêm tài khoản thất bại")</script>
			
		<% }
	%>
    <div class="main">
	
        <form action="dangky" method="post" class="form" id="form-1">
          <h3 class="heading">Đăng ký</h3>
      
          <div class="spacer"></div>
      
          <div class="form-group">
            <label for="fullname" class="form-label">Họ và tên</label>
            <input id="fullname" name="fullname" type="text" placeholder="VD:Duc Huynh" class="form-control">
            <span class="form-message"></span>
          </div>
      
          <div class="form-group">
            <label for="email" class="form-label">Email</label>
            <input id="email" name="email" type="text" placeholder="VD: email@email.com" class="form-control">
            <span class="form-message"></span>
          </div>
      
      	  <div class="form-group">
            <label for="username" class="form-label">Tài khoản</label>
            <input id="username" name="username" type="text" placeholder="VD:duchuynh360" class="form-control">
            <span class="form-message"></span>
          </div>
      
          <div class="form-group">
            <label for="password" class="form-label">Mật khẩu</label>
            <input id="password" name="password" type="password" placeholder="Nhập mật khẩu" class="form-control">
            <span class="form-message"></span>
          </div>
      
          <div class="form-group">
            <label for="password_confirmation" class="form-label">Nhập lại mật khẩu</label>
            <input id="password_confirmation" name="password_confirmation" placeholder="Nhập lại mật khẩu" type="password" class="form-control">
            <span class="form-message"></span>
          </div>
      
          <button class="form-submit">Đăng ký</button>
        </form>
      
      </div>
      
</body>
</html>