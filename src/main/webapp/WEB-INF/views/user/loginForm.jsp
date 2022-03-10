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
	</form>
</div>
<!-- static/js/user.js -->
<%@ include file="../layout/footer.jsp"%>



