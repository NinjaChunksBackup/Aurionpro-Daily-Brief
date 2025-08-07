<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<title>JSTL Demo</title>
</head>
<body>

	<%-- Set and output a value --%>
	<c:set var="name" value="Sanskruti" />
	<p>
		Hello,
		<c:out value="${name}" />
	</p>

	<%-- Conditional check --%>
	<c:if test="${name == 'Sanskruti'}">
		<p>Welcome to JSTL!</p>
	</c:if>

	<%-- Loop through numbers --%>
	<h3>Numbers from 1 to 5:</h3>
	<c:forEach var="i" begin="1" end="5">
  ${i} 
</c:forEach>

	<%-- Use choose/when/otherwise --%>
	<c:set var="marks" value="82" />
	<p>
		<c:choose>
			<c:when test="${marks >= 90}">Grade A</c:when>
			<c:when test="${marks >= 75}">Grade B</c:when>
			<c:otherwise>Grade C</c:otherwise>
		</c:choose>
	</p>

</body>
</html>
