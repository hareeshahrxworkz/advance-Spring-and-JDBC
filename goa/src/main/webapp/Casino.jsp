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

				<form class="d-flex">
					<input class="form-control me-3" type="search" placeholder="Search"
						aria-label="Search"> <a class="btn btn-outline-primary"
						href="index.jsp">Home</a>

				</form>
			</div>
		</nav>
	</div>


	<form action="casino" method="post">

		<div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Casino
					Name </label> <input type="text" class="form-control"
					id="exampleFormControlInput1" placeholder="Enter Beach Name  "
					name="name">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Cruise
				</label> <input type="text" class="form-control"
					id="exampleFormControlInput1" placeholder="Enter Cruise"
					name="cruise">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Entry
					fee </label> <input type="text" class="form-control"
					id="exampleFormControlInput1" placeholder="Enter Entry Fee"
					name="fee">
			</div>

			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Free
					Food </label>: yes<input type="radio" value="true" name="food" /> No<input
					type="radio" name="food" value="false">:
			</div>

			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Free
					alcohol :yes</label> <input type="radio" value="true" name="alcohol" /> No<input
					type="radio" name="alcohol" value="false" />:
			</div>
			<div>
				<input type="submit" class="btn btn-dark" value="submit"
					name="submit" />

			</div>


		</div>
</body>
</html>