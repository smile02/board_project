<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../include/header.jsp" %>

	<table class="table table-borderd">
	<tr>
		<th style="width: 10px">BNO</th>
		<th>TITLE</th>
		<th>WRITER</th>
		<th>REGDATE</th>
		<th style="width: 40px">VIEWCNT</th>
	</tr>
	
	<c:forEach var="boardVo" items="${list }">
		<tr>
			<td>${boardVo.bno }</td>
			<td><a href="/board/readPage${pageMaker.makeQuery(pageMaker.cri.page)}&bno=${boardVo.bno }">
				${boardVo.title }</a></td>
			<td>${boardVo.writer }</td>
			<td><f:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVo.regdate }"/> </td>
			<td><span class="badge bg-red">${boardVo.viewcnt }</span></td>
		</tr>
	
	</c:forEach>	
</table>
<%-- <form id="jobForm">
	<input type="hidden" name="page" value=${pageMaker.cri.perPageNum }/>
	<input type="hidden" name="perPageNum" value=${pageMaker.cri.perPageNum } />
</form> --%>
	<div class="text-center">
		<ul class="pagination">
			<c:if test="${pageMaker.prev }">
				<li><a href="listPage${pageMaker.makeQuery(pageMaker.startPage-1) }">&laquo;</a></li>
			</c:if>
			
			<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
				<li<c:out value="${pageMaker.cri.page == idx?'class=active':''}"/>>
					<a href="listPage${pageMaker.makeQuery(idx) }">${idx }</a>
				</li>
			</c:forEach>
			
			<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
				<li><a href="listPage${pageMaker.makeQuery(pageMaker.endPage +1) }">&raquo;</a></li>
			</c:if>
		</ul>
	</div>
<%@include file="../include/footer.jsp" %>
<script>
	/* $(".pagination li a").on("click", function(event){
		event.preventDefault();
		
		var targetPage = $(this).attr("href");
		
		var jobForm=$("#jobForm");
		jobForm.find("[name='page']").val(targetPage);
		jobForm.attr("action","/board/listPage").attr("method","get");
		jobForm.submit();
	}); */
	
</script>
</body>
</html>