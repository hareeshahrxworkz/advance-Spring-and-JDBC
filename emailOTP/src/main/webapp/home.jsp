<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<title>Xworkz</title>
</head>
<body
	style="background-image: url('https://cdn.pixabay.com/photo/2021/07/06/19/26/drops-6392473__340.jpg'); background-size: cover;">
	<div>
		<nav class="navbar navbar-green bg-dark">
			<div class="container-fluid">
				<img
					src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
					class="img-fluid" hight="80px" width="80px">

				<form class="d-flex" action="registerpage" method="get">
					<a href="register" class="btn btn-primary">Register Email</a>


				</form>

			</div>
		</nav>
	</div>
	<h1>Welcome to Email .........</h1>



	<table class="table caption-top">
		<caption>Displaying Getting Email</caption>
		<thead>

			<tr>
				<th scope="col">id</th>
				<th scope="col">email</th>
				<th scope="col">Fname</th>
				<th scope="col">Lname</th>
				<th scope="col">MobileNo</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lists}" var="p">
				<tr>
					<th scope="row">${p.id}</th>
					<td>${p.email}</td>
					<td>${p.FName}</td>
					<td>${p.lname}</td>
					<td>${p.mobileNo}</td>


				</tr>
			</c:forEach>


		</tbody>
	</table>


	<c:forEach items="${list}" var="e">
		<span style="color: blue;"> ${e.id}</span>
		</br>

	</c:forEach>


</body>
</html>