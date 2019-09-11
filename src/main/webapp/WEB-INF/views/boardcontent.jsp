<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>쌉소리</title>
<script src="/ckeditor/ckeditor.js"></script>
<jsp:include page="/Layouts/resource.jsp" />
</head>

<body>
	<jsp:include page="/Layouts/nav.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<div class="ui main container" align="center">
		<div class="ui large message">
			<div class="ui large center header">게시판</div>
		</div>
		<div
			style="width: 100%; border-top: solid 2px lightgray; border-left: solid 2px lightgray; border-right: solid 2px lightgray;">
			제목 - ${boardContent.subject}
			<br> 
			작성자 - ${boardContent.insertId}
			<br> 	
			작성일 -
			<fmt:formatDate value="${boardContent.insertDate}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate>
		</div>
		<div style="width: 100%; min-height: 400px; border: solid 2px lightgray; text-align: left;">${boardContent.contents}</div>
		<br>
		<div align="center">
			<button class="ui orange button" onclick="back();">글목록</button>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="/Layouts/footer.jsp"></jsp:include>
</body>


<script>
	function back() {
		history.back(-1);
	}
</script>

</html>