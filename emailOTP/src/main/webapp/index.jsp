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






	<div class="container "></div>
	<div class="container ">
		<form class=row-g-6 action="email" method="post">
			<div class="mb-4">
				<label for="exampleInputEmail1" class="form-label">Email
					address</label> <input placeholder="Enter Your Email Address" type="email"
					class="form-control" name="email" value="${email}"
					id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			<div>

				<div class="mb-4">
					<button type="submit" name="email" class="btn btn-primary">Get
						OTP</button>

				</div>
			</div>

		</form>
		<!-- <form action="validOtp" method="get">
			<div class="mb-4">
				<input type="text" class="form-control"
					placeholder="Enter Recived OTP" name="otp">
			</div>

			<div class="mb-4">
				<input type="submit" class="btn btn-primary" value="Login" />

			</div>
		</form> -->



	</div>
</body>
</html>