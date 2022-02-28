<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<form action="/action_page.php">

	<div class="form-group">
		<label for="email">User Name:</label> <input type="text" class="form-control" placeholder="Enter user name" id="username">
	</div>

	<div class="form-group">
		<label for="email">Password:</label> <input type="text" class="form-control" placeholder="Enter password" id="password">
	</div>

	<div class="form-group form-check">
		<label class="form-check-label"> <input class="form-check-input" type="checkbox"> Remember me
		</label>
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form>
<%@ include file="../layout/footer.jsp"%>



