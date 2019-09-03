<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쌉소리</title>
<script src="/ckeditor/ckeditor.js"></script>
<jsp:include page="/Layouts/resource.jsp" />
</head>

<body>
<body><jsp:include page="/Layouts/nav.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<div class="ui main text container">
		<div class="ui message" align="center">
			<div class="ui large header">힝구리바보</div>
		</div>
		<form>
			<textarea name="editor" id="editor" rows="20" cols="80"> 
        </textarea>
		</form>
		<br>
		<div align="center">
			<img src="/img/ssappsori.jpg" style="width: 200px; height: 200px;">
		</div>
		<br>
		<br>
		<br>
	</div><jsp:include page="/Layouts/footer.jsp"></jsp:include>
</body>

<script>
	CKEDITOR.replace('editor', {
		height : 500,
		filebrowserUploadUrl : 'fileupload.do'
	});
</script>
</html>