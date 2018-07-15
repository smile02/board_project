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
<form role="form" method="post">
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">BNO</label>
			<input type="text" name="bno" class="form-control" value="${boardVo.bno }"/>
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label>
			<input type="text" name="title" class="form-control" value="${boardVo.title }"/>
		</div>
		
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>			
			<textarea name="content" class="form-control"
			cols="30" rows="10">${boardVo.content }</textarea>
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label>
			<input type="text" name="writer" class="form-control" value="${boardVo.writer }" />
		</div>	
	</div>
	
	<div class="box-footer">
		<button class="btn btn-primary">SAVE</button>
		<button class="btn btn-warning">CANCEL</button>
	</div>
</form>


<%@include file="../include/footer.jsp" %>
</body>
<script>
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		
		$(".btn-warning").on("click", function(){
			self.location = "/board/listAll";
		});
		
		$(".btn-primary").on("click", function(){
			formObj.submit();
		});
	});
</script>
</html>