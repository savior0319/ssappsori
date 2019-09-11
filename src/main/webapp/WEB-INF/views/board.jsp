<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>쌉소리</title>
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
		<table class="ui celled table">
			<thead>
				<tr align="center">
					<th style="width: 10%;">글번호</th>
					<th style="width: 40%;">글제목</th>
					<th style="width: 20%;">작성자</th>
					<th style="width: 20%;">작성시간</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList.arrayList}" var="i">
					<tr>
						<td style="text-align: center;">${i.boardNo}</td>
						<td><a href="/boardcontent.ssap?index=${i.boardNo}">${i.subject}</a></td>
						<td>${i.insertId}</td>
						<td style="text-align: center;"><fmt:formatDate value="${i.insertDate}"
								pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<label>${boardList.pageNavi}</label>
	</div>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="/Layouts/footer.jsp"></jsp:include>
</body>

<script>
	
</script>

</html>
