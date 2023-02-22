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
						value="Search"> <a href="index.jsp"
						class="btn btn-primary">Home</a>


				</form>
			</div>
		</nav>
	</div>
	<h1>Welcome to Flight .........</h1>
	<span> <c:forEach items="${error}" var="m">
			</br>
			<span style="color: red">${m.message}</span>
			</br>

		</c:forEach> <span style="color: green">${sucess}</span> <span style="color: red">${failure}</span>

		<span style="color: green">${dto}</span> <span style="color: red">${nu}</span>
		<form action="flight" method="post">

			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">Light
					Company Name </label> <input type="text" class="form-control"
					id="formGroupExampleInput" placeholder="Enter Flight Company Name"
					name="name" />
			</div>

			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">Flight
					Name </label> <input type="text" class="form-control"
					id="formGroupExampleInput" placeholder="Enter Flight Name"
					name="fname" />
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">Flight
					cost </label> <input type="text" class="form-control"
					id="formGroupExampleInput" placeholder="Enter Flight cost"
					name="cost" />
			</div>

			<div>
				<select class="form-select form-select-lg mb-3"
					aria-label=".form-select-lg example" name="type">
					<option value="">select</option>

					<c:forEach items="${type}" var="p">Type
						<option value="${p}">${p}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<select class="form-select form-select-lg mb-3"
					aria-label=".form-select-lg example" name="country">
					<option value="">select</option>

					<c:forEach items="${country}" var="c">country
						<option value="${c}">${c}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<input type="submit" class="btn btn-warning" value="Save" />
			</div>
		</form>
</body>
</html>