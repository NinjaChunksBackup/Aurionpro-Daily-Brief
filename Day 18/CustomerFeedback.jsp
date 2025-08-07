<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Customer FeedBack Form</h1>
	
	<form action="CustomerResponse.jsp" method="post">
		<label>Name :</label><br>
		<input type="text" name="name" placeholder="enter your name" /><br><br>
		
		<label>Gender:</label><br>
		<select name="gender" required>
			<option value="">Select Gender</option>
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			<option value="Other">Other</option>
		</select>
		<br><br>
		
		<label>Select the topics :</label><br>
		<input type="checkbox" name="topics" value="website" /> Website <br>
		<input type="checkbox" name="topics" value="Support" /> Support <br>
		<input type="checkbox" name="topics" value="Content" /> Content <br>
		<input type="checkbox" name="topics" value="Speed" /> Speed <br><br>
		
		<label>Rate us :</label><br>
		<input type="radio" name="rate" value="1" />1 star<br>
		<input type="radio" name="rate" value="2" />2 stars<br>
		<input type="radio" name="rate" value="3" />3 stars<br>
		<input type="radio" name="rate" value="4" />4 stars<br>
		<input type="radio" name="rate" value="5" />5 stars<br></br>
		
		<strong>Any comments ?</strong><br>
		<textarea name="comment" rows="4" ></textarea><br><br>
		
		
		<button type="submit">Submit</button>
	
	</form>
</body>
</html>