<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
index 입니다.  </br>
<a href="/admin"> admin </a> </br>
<a href="/user"> user </a> </br>

<sec:authorize access="isAnonymous()">
<br>로그아웃중
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<br>로그인중
</sec:authorize>

<c:url var="logoutUrl" value="/logout"/>
<form action="${logoutUrl}" method="post">
	<input type="submit" value="Log out" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>