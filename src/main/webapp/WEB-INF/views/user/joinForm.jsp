<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div>
	<form>

		<div class="form-group">
			<label for="email">User Name:</label> <input type="text" class="form-control" placeholder="Enter user name" id="username">
		</div>

		<div class="form-group">
			<label for="email">Password:</label> <input type="text" class="form-control" placeholder="Enter password" id="password">
		</div>

		<div class="form-group">
			<label for="email">Email address:</label> <input type="email" class="form-control" placeholder="Enter email" id="email">
		</div>
		<!-- 
	<div class="form-group form-check">
		<label class="form-check-label"> <input class="form-check-input" type="checkbox"> Remember me
		</label>
	</div>
	-->

	</form>
	<button id="btn-save" class="btn btn-primary">회원가입</button>
</div>
<script src="/blog/js/user.js"></script> <!-- static/js/user.js -->
<%@ include file="../layout/footer.jsp"%>



