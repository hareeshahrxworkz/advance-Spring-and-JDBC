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


		<h1>Hotel order Information</h1>

		<form action="cm" method="post">

			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">CM
					Name </label> <input type="text" class="form-control"
					id="formGroupExampleInput" placeholder="Enter CM Name"
					name="CMName" />
			</div>
			<div>

				<select class="form-select form-select-lg mb-3"
					aria-label=".form-select-lg example" name="state">
					<option value=" ">select</option>
					<option>Karnataka</option>
					<option>TamilNadu</option>
					<option>AndraPredesh</option>
					<option>Madyapredesh</option>
					<option>Gujarath</option>
					<option>Hydaradbad</option>
					<option>Kerala</option>
					<option>Bihar</option>
					<option>Kolkatta</option>
				</select>
			</div>
			<div>

				<select class="form-select form-select-lg mb-3"
					aria-label=".form-select-lg example" name="age">
					<option value="0">select</option>
					<option>23</option>
					<option>24</option>
					<option>25</option>
					<option>26</option>
					<option>27</option>
					<option>28</option>
					<option>29</option>
					<option>30</option>
					<option>31</option>
				</select>
			</div>
			<div>

				<select class="form-select form-select-lg mb-3"
					aria-label=".form-select-lg example" name="tenure">
					<option value="0">select</option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
					<option>9</option>
				</select>
			</div>

			<div class="form-floating">
				<textarea class="form-control" name="vaccine"
					placeholder="Enter Vaccine detiled" id="floatingTextarea2"
					style="height: 100px"></textarea>
				<label for="floatingTextarea2">vaccine information</label>
			</div>
			<input type="submit" class="btn btn-warning" value="Submit" />


		</form>
	</div>


</body>
</html>