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
<body
	style="background-image: url('https://cdn.pixabay.com/photo/2021/07/06/19/26/drops-6392473__340.jpg'); background-size: cover;">
	<div>
		<nav class="navbar navbar-green bg-dark">
			<div class="container-fluid">
				<img
					src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
					class="img-fluid" hight="80px" width="80px">

				<form class="d-flex" action="findByName" method="get">
					<a href="game"
						class="btn btn-primary">Game</a> <a href="findByname.jsp"
						class="btn btn-primary">FindByName</a>


				</form>

			</div>
		</nav>
	</div>
	<h1>Welcome to Game .........</h1>


	<form action="find" method="get">
		<input type="submit" class="btn btn-primary" name="All"
			value="Print All Data" />

	</form>



	<div class="card text-white bg-light mb-3">
		<span style="color: red">${err}</span>


	</div>

</body>
</html>