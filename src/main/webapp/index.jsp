<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/commons.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<title>Main Page</title>
</head>
<body>
	<center>
		<div class="page">
			<h2 class="index">�Խ��� ���α׷�</h2>
			<c:if test="${empty sessionScope.user.id}">
				<button type="button" class="btn btn-outline-info" onclick="location.href='login.jsp' ">�α���</button>
				<button type="button" class="btn btn-outline-primary" onclick="location.href='createUser.jsp' ">ȸ������</button>
				<button type="button" class="btn btn-outline-danger" onclick="location.href='getId.jsp' ">���̵�ã��</button>
				<button type="button" class="btn btn-outline-warning" onclick="location.href='getPw.jsp' ">��ȣã��</button>
			</c:if>
			<br>
			<c:if test="${!empty sessionScope.user.id}">
				<h3 class="index">${user.id}�� ȯ���մϴ�!</h3>
				<a class="index" href="getBoardList.do">�Խ��Ǹ���Ʈ</a>
				<a class="index" href="updateUser.jsp">��������</a>
				<a class="index" href="logout.do">�α׾ƿ�</a>
			</c:if>
		</div>
	</center>
</body>
</html>