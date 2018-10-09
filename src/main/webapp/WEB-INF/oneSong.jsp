<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Song</title>
</head>
<body>
	<a href="/dashboard"><h1>Dashboard</h1></a>
	<h1>${name}</h1>
	<p>${artist}</p>
	<p>${rating}</p>
	<a href="/remove/${id}"><button>Delete</button></a>
</body>
</html>