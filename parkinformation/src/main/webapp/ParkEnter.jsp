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
					src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
					class="img-fluid" hight="80px" width="80px">

				<form class="d-flex">
					<input class="form-control me-3" type="search" placeholder="Search"
						aria-label="Search"> <a href="index.jsp"
						class="btn btn-primary">Home</a>


				</form>
			</div>
		</nav>
	</div>
	<h1>Welcome to ParkEnter Detiles.........</h1>



	<span> <c:forEach items="${message}" var="m">
			</br>
			<span style="color: red">${m.message}</span>

		</c:forEach>


		<form action="park" method="post">
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">Park
					Visitor Name </label> <input type="text" class="form-control"
					id="formGroupExampleInput" placeholder="Enter Park Visitor Name"
					name="visitorNme" />
			</div>

			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">Park
					Name </label> <input type="text" class="form-control"
					id="formGroupExampleInput" placeholder="Enter Park Name"
					name="parkName" />
			</div>

			<div>
				<select class="form-select form-select-lg mb-3"
					aria-label=".form-select-lg example" name="place">
					<option value="">select</option>

					<c:forEach items="${place}" var="p">Place
						<option value="${p}">${p}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<select class="form-select form-select-lg mb-3"
					aria-label=".form-select-lg example" name="week">
					<option value="">select</option>

					<c:forEach items="${week}" var="w">week
						<option value="${w}">${w}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-floating">
				<textarea class="form-control" name="review"
					placeholder="Enter Review detiled" id="floatingTextarea2"
					style="height: 100px"></textarea>
				<label for="floatingTextarea2">Review</label>
			</div>


			<input type="submit" class="btn btn-warning" value="Submit" />

		</form>
</body>
</html>