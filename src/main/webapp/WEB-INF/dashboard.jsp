<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>        
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<a href="/new">Add New</a>
	<a href="/top">Top Songs</a>
	
	<form action="/search" method="POST">
		<input type="text" name="artist">
		<button type=submit>Search</button>
	</form>
	
	<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
   		<c:forEach items="${songs}" var="song">
        <tr>
            <td><a href="/song/${song.id}"><c:out value="${song.name}"/></a></td>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="/delete/${song.id}">Delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
	</table>
</body>
</html>