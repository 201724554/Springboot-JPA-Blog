<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div>
	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">User Name:</label> <input type="text" name="username" class="form-control" placeholder="Enter user name" id="username">
		</div>

		<div class="form-group">
			<label for="password">Password:</label> <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<button id="btn-login" type="submit" class="btn btn-primary">Submit</button>
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=58e9b2e62e635e63b04c19e20acefae5&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code"><img height="38px" src="/image/kakao_login_btn.png"/></a>
	</form>
</div>
<!-- static/js/user.js -->
<%@ include file="../layout/footer.jsp"%>



