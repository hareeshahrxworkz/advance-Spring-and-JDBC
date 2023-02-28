<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<title>X-Workz</title>
</head>
<body
	style="background-image: url('https://cdn.pixabay.com/photo/2021/07/06/19/26/drops-6392473__340.jpg'); background-size: cover;">
	<div>
		<nav class="navbar navbar-green bg-dark">
			<div class="container-fluid">
				<img
					src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
					class="img-fluid" hight="80px" width="80px">

				<form class="d-flex" action="findByName" method="get">
					<input class="form-control me-3" type="text" placeholder="Search"
						aria-label="Search" name="name"> <input type="submit"
						value="Search"><a href="game" class="btn btn-primary">Game</a>
					<a href="index.jsp" class="btn btn-primary">Home</a>


				</form>

			</div>
		</nav>
	</div>
	<h1>Welcome to Game .........</h1>


	<h1></h1>




	<div class="card text-white bg-light mb-3">
		<span style="color: red">${err}</span> <span style="color: gold">
			${msg}</span>

		<table class="table caption-top">
			<caption>Display Detiles of finding Game</caption>
			<thead>
				<tr>
					<th scope="col">id</th>
					<th scope="col">Name</th>
					<th scope="col">Type</th>
					<th scope="col">Playars</th>
					<th scope="col">NoOfLevels</th>
					<th scope="col">Wepon</th>
					<th scope="col">PlayingMood</th>
					<th scope="col">Delete/Modify</th>



				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="p">
					<tr>
						<th scope="row">${p.id}</th>
						<td>${p.name}</td>
						<td>${p.type}</td>
						<td>${p.playars}</td>
						<td>${p.getNoOfLevels()}</td>
						<td>${p.getWepon()}</td>
						<td>${p.online}</td>
						<form action="delete" method="get">
						<td><button value="${p.id}" name="de" href="delete"
								class="btn btn-primary">Delete</button></td>
						</form>

					</tr>
				</c:forEach>


			</tbody>
		</table>

	</div>
</body>
</html>