<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<body>
	<div>
		<nav class="navbar navbar-green bg-dark">
			<div class="container-fluid">
				<img
					src="https://images.hindustantimes.com/img/2022/08/04/1600x900/go-first-_1659603871151_1659603879354_1659603879354.jpg"
					class="img-fluid" hight="80px" width="80px">

				<form class="d-flex" action="find" method="get">
					<input class="form-control me-3" type="text" placeholder="Search"
						aria-label="Search" name="id"> <input type="submit"
						value="Search"><a href="flight" class="btn btn-primary">Flight</a>


				</form>
			</div>
		</nav>
	</div>
	<h1>Welcome to Flight .........</h1>
	<%-- 	<span style="color: green">${dto}</span>
 --%>
	<span style="color: red">${nu}</span>

	<h1>Display Detiles</h1>
	Company name:
	<span>${dto.name}</span>
	<br> Flight name :
	<span>${dto.fname}</span>
	<br> cost:
	<span>${dto.cost}</span>
	<br> type:
	<span>${dto.type}</span>
	<br> country
	<span>${dto.country}</span>
	<br>


</body>
</html>