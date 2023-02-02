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
					class="img-fluid" alt="..." hight="80px" width="80px">

				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search"> <a class="btn btn-outline-primary"
						
						href="index.jsp">Home</a>	
						
				</form>
			</div>
		</nav>
	</div>

	<form action="delivery" method="post">

		<div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Delivery
				boy	Name</label> <input type="text" class="form-control"
					id="exampleFormControlInput1"
					placeholder="Enter your Delivery boy  Name" name="fname">
			</div>

			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Delivery
					Email</label> <input type="text" class="form-control"
					id="exampleFormControlInput1"
					placeholder="Enter your Delivery email" name="email">
			</div>
			<select class="form-select" aria-label="Default select example"
				name="gender">
				<option selected>Select Delivery gender</option>
				<option value="Male">Male</option>
				<option value="Female">Female</option>
				<option value="Other">other</option>
			</select>

			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Mobile
					NO </label> <input type="text" class="form-control"
					id="exampleFormControlInput1"
					placeholder="Enter your delivery boy no" name="mobile_NO">
			</div>
			<div>
				<input type="submit" class="btn btn-dark" value="Send" name="send" />

			</div>



		</div>

	</form>

</body>
</html>