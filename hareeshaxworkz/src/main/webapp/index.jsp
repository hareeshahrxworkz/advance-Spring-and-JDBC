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
					src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
					class="img-fluid" hight="80px" width="80px">

				<form class="d-flex" action="find" method="get">
					<input class="form-control me-3" type="text" placeholder="Search"
						aria-label="Search" name="id"> <input type="submit"
						value="Search"><a href="game" class="btn btn-primary">Game</a>


				</form>

			</div>
		</nav>
	</div>
	<h1>Welcome to Game .........</h1>

	<span style="color: red">${err}</span>

	<h1>Display Detiles of finding Game</h1>
	Game Name
	<span>${dto.name}</span>
	<br> Game Type :
	<span>${dto.type}</span>
	<br> Game Wepon:
	<span>${dto.getWepon()}</span>
	<br> Game Levels:
	<span>${dto.getNoOfLevels()}</span>
	<br> Geme Playars
	<span>${dto.playars}</span>
	<br> Game online or offline
	<span>${dto.online}</span>

	<span>${id}</span>




</body>
</html>