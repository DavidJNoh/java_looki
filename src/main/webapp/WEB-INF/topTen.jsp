<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top ten</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<h1>Top Ten Songs:</h1>
	<div>
		<c:forEach items="${songs}" var="song">
        <tr>
            <td><c:out value="${song.name}"/></td>
            <td><c:out value="${song.rating}"/></td>
        </tr>
        </c:forEach>
	</div>
</body>
</html>