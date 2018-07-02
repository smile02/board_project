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
			<td><a href="">${boardVo.title }</a></td>
			<td>${boardVo.writer }</td>
			<td><f:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVo.regdate }"/> </td>
			<td><span class="badge bg-red">${boardVo.viewcnt }</span></td>
		</tr>
	
	</c:forEach>
</table>

<%@include file="../include/footer.jsp" %>
</body>
<script>
	var result = '${msg}';
	
	if(result = 'SUCCESS'){
		alert("처리가 완료되었습니다.");
	}
</script>
</html>