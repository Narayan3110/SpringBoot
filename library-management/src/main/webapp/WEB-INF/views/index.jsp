<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Management System</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 80%;
        margin: 50px auto;
        background: #fff;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    h1 {
        color: #333;
    }
    h2 {
        color: #555;
    }
    img {
        width: 150px;
        margin: 20px 0;
    }
    a {
        display: inline-block;
        margin: 20px 0;
        padding: 10px 20px;
        background-color: #5cb85c;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s;
    }
    a:hover {
        background-color: #4cae4c;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Welcome To Library</h1>
        <img src="/studentsoft/resources/static/images/logo.png" alt="Library Logo">
        <h2>Library Management System</h2>
        <a href="addbook">Add Book</a>
    </div>
</body>
</html>
