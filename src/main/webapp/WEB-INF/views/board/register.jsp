<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%@include file="../include/header.jsp" %>
<form role="form" method="post">
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label>
			<input type="text" name="title" placeholder="Enger Title" class="form-control" />
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea name="content" rows="3" placeholder="Enter..." class="form-control"></textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label>
			<input type="text" name="writer" placeholder="Enter Writer" class="form-group" />
		</div>		
	</div>
	<div class="box-footer">
		<button class="btn btn-primary" type="submit">Submit</button>
	</div>
</form>
<%@include file="../include/footer.jsp" %>
</body>
</html>