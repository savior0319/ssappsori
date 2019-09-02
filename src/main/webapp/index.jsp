
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쌉소리</title>
<script src="/ckeditor/ckeditor.js"></script>
</head>

<body>
	<div class="main" style="width: 350px; margin: 0 auto;">
		<h1 align="center">힝구리바보</h1>
		<img src="/img/ssappsori.jpg" style="width: 350px; height: 350px;">
	</div>
	<div style="width: 75%; margin: 0 auto;">
		<form>
			<textarea name="editor" id="editor" rows="20" cols="80"> 
            
        </textarea>
		</form>
	</div>
</body>

<script>
	CKEDITOR.replace('editor', {
		height : 500,
		filebrowserUploadUrl : 'fileupload.do'
	});
</script>
</html>