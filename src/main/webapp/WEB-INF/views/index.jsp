<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>
<div class="container">
	<c:forEach var="board" items="${boards.content}">
		<div class="card m-2">
			<div class="card-body">
				<h4 class="card-title">${board.title}</h4>
				<!-- board의 getTitle 호출 -->
				<a href="/board/${board.id}" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</c:forEach>
	<ul class="pagination justify-content-center">
		<!-- start center end -->
		<c:choose>
			<c:when test="${boards.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>
		
		<c:forEach var="i" begin="1" end="${boards.totalPages}"> <!-- 이렇게 하면 1부터 끝까지 다 나옴 -> 페이지가 1000개면 1 2 3 .. 1000까지 다 나와서 못씀 -->
			<li class="page-item"><a class="page-link" href="?page=${i-1}">${i}</a></li>
		</c:forEach>
		
		<c:choose>
			<c:when test="${boards.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
<%@ include file="layout/footer.jsp"%>



