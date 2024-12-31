<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Book</title>
<link rel="stylesheet"
	href="/studentsoft/resources/static/css/student.css">
</head>
<body>
	<h1>Add a Book to the Library</h1>
	<form action="books"
		method="post">
		<div>
			<label for="bookName">Book Name:</label> 
			<input type="text"
				id="bookName" name="bookName" required>
		</div>
		<div>
			<label for="authorName">Author Name:</label> <input type="text"
				id="authorName" name="author" required>
		</div>
		<div>
			<button type="submit">Add Book</button>
		</div>
	</form>
</body>
</html>
