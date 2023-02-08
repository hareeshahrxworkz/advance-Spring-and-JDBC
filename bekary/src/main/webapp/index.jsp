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


				</form>
			</div>
		</nav>
	</div>
	<div class=container>


		<h1>Save Detiles of bekary</h1>

		<form action="save" method="get">

			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">Bekary
					Name </label> <input type="text" class="form-control"
					id="formGroupExampleInput" placeholder="Enter Bekary Name"
					name="bekary" />
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label"> Owner
					Name</label> <input type="text" class="form-control"
					id="formGroupExampleInput" placeholder="Enter Owner Name"
					name="owner" />
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label"> Wife
					Name</label> <input type="text" class="form-control"
					id="formGroupExampleInput" placeholder="Enter Wife Name"
					name="wife" />
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label"> Owner
					Married</label> <input type="radio" name="married" value="true" /> Yes <input
					type="radio" name="married" value="false" /> No
			</div>
			<div class="form-floating">

				<textarea class="form-control" placeholder="Bekary Famous for"
					id="floatingTextarea" name="famous"></textarea>
				<label for="floatingTextarea">Bekary Famous for</label>

			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">
					Bekary Since </label> <input type="text" class="form-control"
					id="formGroupExampleInput" placeholder="Enter Since" name="since" />
			</div>
			<input type="submit" value="Save" class="btn btn-dark" />



		</form>


	</div>
</body>
</html>