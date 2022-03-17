<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div>
	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	<br/>
	<br/>
	<form>
		<input type="hidden" id="id" value="${principal.user.id}" />
		<div class="form-group">
			<label for="email">Username:</label> <input type="text" value="${principal.user.username}" class="form-control" placeholder="Enter user name" id="username" readonly>
		</div>

		<div class="form-group">
			<label for="email">Password:</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>

		<div class="form-group">
			<label for="email">Email address:</label> <input type="email" value="${principal.user.email}" class="form-control" placeholder="Enter email" id="email">
		</div>

	</form>
	<button id="btn-update" class="btn btn-primary">수정</button>
</div>
<script src="/js/user.js"></script>
<!-- static/js/user.js -->
<%@ include file="../layout/footer.jsp"%>



