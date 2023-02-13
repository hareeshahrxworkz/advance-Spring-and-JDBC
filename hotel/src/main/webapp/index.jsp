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
						aria-label="Search">
						<a href="Cm.jsp" class="btn btn-primary"> CMDTO</a>


				</form>
			</div>
		</nav>
	</div>
	<div class=container>


		<h1>Hotel order Information</h1>

		<form action="order" method="post">

			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">Hotel
					Name </label> <input type="text" class="form-control"
					id="formGroupExampleInput" placeholder="Enter Hotel Name"
					name="hotelName" />
			</div>

			<div>
				<select class="form-select form-select-lg mb-3"
					aria-label=".form-select-lg example" name="items">
					<option selected>Hotel order Items</option>
					<option>Egg</option>
					<option>Egg-burgi</option>
					<option>egg masala</option>
					<option>chapati</option>
					<option>sambar</option>
					<option>olige</option>
					<option>malsla majjige</option>
					<option>chikan beriyani</option>
					<option>kabab</option>
					<option>dosa</option>
					<option>curd</option>
				</select>
			</div>
			<div>
				<select class="form-select form-select-lg mb-3"
					aria-label=".form-select-lg example" name="quantity">
					<option selected>Hotel order Quantity</option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
					<option>9</option>
					<option>10</option>
				</select>
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">Price</label>
				<input type="text" class="form-control" id="formGroupExampleInput"
					placeholder="Enter Price " name="price" />
			</div>

			<div class="form-check">
				<label>Take Away</label><br> <input class="form-check-input"
					type="radio" value="true" name="takeAway" id="flexRadioDefault1">
				<label class="form-check-label" for="flexRadioDefault1">
					yes: </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="takeAway"
					id="flexRadioDefault2" value="false" checked> <label
					class="form-check-label" for="flexRadioDefault2"> No: </label>
			</div>
			<div>
				<div class="mb-3">
					<label for="formGroupExampleInput" class="form-label">Hotel
						Place </label> <input type="text" class="form-control"
						id="formGroupExampleInput" placeholder="Enter place Name"
						name="place" />
				</div>
				<input type="submit" class="btn btn-warning" value="Order Now" />

			</div>

		</form>
	</div>
</body>
</html>