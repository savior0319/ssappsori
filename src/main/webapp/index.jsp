
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
			<div class="ui large header">푸엑</div>
		</div>
		<form class="ui form" action="/boardsave.ssap" method="POST">
			<input name="subject" placeholder="글 제목을 입력하세요" style="margin-bottom: 5px;" id="subject"></input>
			<input name="insertId" placeholder="작성자를 입력하세요" style="margin-bottom: 8px;" id="insertId"></input>
			<textarea name="content" id="editor" rows="20" cols="80"> 
        </textarea>
			<br>
			<input type="password" name="pwd" placeholder="비밀번호" style="margin-bottom: 8px;" id="password"></input>
			<div align="center">
				<button class="ui primary button" onclick="return save();">글쓰기</button>
			</div>
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
		filebrowserUploadUrl : '/fileupload.ssap'
	});

	function save() {

		if ($("#subject").val() == '') {
			alert("글 제목을 입력해 주세요.");
			return false;
		}

		if ($("#insertId").val() == '') {
			alert("작성자를 입력해 주세요.");
			return false;
		}

		if (CKEDITOR.instances.editor.getData().length < 1) {
			alert("내용을 입력해 주세요.");
			return false;
		}

		if ($("#password").val() == '') {
			alert("비밀번호를 입력해 주세요.");
			return false;
		}
	}
</script>
</html>