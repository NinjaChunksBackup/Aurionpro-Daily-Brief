<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Thank you for your feedback ${param.name} </h1>

	<h6>your gender : ${param.gender }</h6>
	
	<c:choose >
	<c:when test="${not empty paramValues.topics }">
		<h3>Your Feedback on :</h3>
		<ul>
		<c:forEach var="topic" items="${paramValues.topics}">
		
			<li>${topic}</li>
		</c:forEach>
		
		</ul>
		
		</c:when>
		
		<c:otherwise>
			<p>no topics are selected</p>
		</c:otherwise>
	
	</c:choose>
	
	
	<p><strong>your rating : ${param.rate}</strong></p>
	
	<c:choose>
		<c:when test="${param.rate gt 3}">
		
			<p>we are glad to see you</p>
		</c:when>
		<c:otherwise>
			<p> Sorry to hear that. We'll try to improve.</p>
		</c:otherwise>
	</c:choose>
	
	
	<c:choose >
	<c:when test="${not empty param.comment}">
		<h3>Your Comment :</h3>
		<blockquote>${param.comment}</blockquote>
	</c:when>
	
	<c:otherwise>
		<p>no comments </p>
	</c:otherwise>
	</c:choose>
	

</body>
</html>