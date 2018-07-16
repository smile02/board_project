<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../include/header.jsp" %>
<form role="form" method="post" action="modifyPage">
	<input type="hidden" name="bno" value="${ boardVo.bno}" />
	<input type="hidden" name="page" value="${cri.page }" />
	<input type="hidden" name="perPageNum" value="${cri.perPageNum}" />
</form>
<div class="box-body">
	<div class="form-group">
		<label for="exampleInputEmail1">Title</label>
		<input type="text" name="title" class="form-control" value="${boardVo.title }"
			readonly="readonly" />
	</div>
	<div class="form-group">
		<label for="exampleInputPassword1">Content</label>
		<textarea name="content" class="form-control" readonly="readonly" cols="30" rows="10">${boardVo.content}</textarea>
	</div>
	<div class="form-group">
		<label for="exampleInputEmail1">Writer</label>
		<input type="text" name="writer" class="form-control" value="${boardVo.writer}"
			readonly="readonly" />
	</div>
</div>
<div class="box-footer">
	<button class="btn btn-warning">Modify</button>
	<button class="btn btn-danger">Remove</button>
	<button class="btn btn-primary">List All</button>
</div>

<%@include file="../include/footer.jsp" %>
</body>
<script>
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$(".btn-warning").on("click", function(){
			formObj.attr("action", "/board/modifyPage");
			formObj.attr("method","get");
			formObj.submit();
		});
		
		$(".btn-danger").on("click", function(){
			formObj.attr("action", "/board/removePage");
			formObj.submit();
		});
		
		$(".btn-primary").on("click",function(){
			formObj.attr("method","get");
			formObj.attr("action","/board/listPage");
			formObj.submit();
		});
	});
</script>
</html>