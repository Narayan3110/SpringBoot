<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	width: 50%;
	margin: 50px auto;
	background: #fff;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	color: #333;
}

form {
	display: flex;
	flex-direction: column;
}

label {
	margin-bottom: 10px;
	color: #555;
}

input[type="text"], input[type="submit"] {
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ddd;
	border-radius: 5px;
}

input[type="submit"] {
	background-color: #5cb85c;
	color: white;
	border: none;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #4cae4c;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Add a New Book</h2>
		<form action="management/addBook" method="post">
			<label for="bookName">Book Name:</label> <input type="text"
				id="bookName" name="bookName" required> <label for="author">Author:</label>
			<input type="text" id="author" name="author" required> <input
				type="submit" value="Add Book">
		</form>
	</div>
</body>
</html>
