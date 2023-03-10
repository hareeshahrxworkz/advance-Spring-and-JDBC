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
<body
	style="background-image: url('https://cdn.pixabay.com/photo/2021/07/06/19/26/drops-6392473__340.jpg'); background-size: cover;">
	<div>
		<nav class="navbar navbar-green bg-dark">
			<div class="container-fluid">
				<img
					src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
					class="img-fluid" hight="80px" width="80px">

				<form class="d-flex" action="findByName" method="get">
					<input class="form-control me-3" type="text" placeholder="Search"
						aria-label="Search" name="name"> <input type="submit"
						value="Search"><a href="index.jsp" class="btn btn-primary">Home</a>


				</form>




			</div>
		</nav>
	</div>


	<div class="mx-auto" style="width: 625px;">
		<div class="card text-white bg-primary mb-3" style="width: 40rem;">
			<div class="card-body">
				<h5>Welcome to Game .........</h5>

				<span style="color: red"> <c:forEach items="${error}" var="e">
						<span> ${e.message}</span>
						</br>

					</c:forEach>
				</span> <span style="color: yellow">${save}</span>
				<form action="game" method="post">

					<div class="mb-3">
						<label for="formGroupExampleInput" class="form-label">Game
							Name </label> <input type="text" class="form-control"
							id="formGroupExampleInput" placeholder="Enter  Game Name"
							name="name" value="${dto.name}" />
					</div>

					<div class="mb-3">
						<label for="formGroupExampleInput" class="form-label">Game
							Type </label> <input type="text" class="form-control"
							id="formGroupExampleInput" placeholder="Enter Game Type"
							value="${dto.type}" name="type" />
					</div>


					<div>
						Online<select class="form-select form-select-lg mb-3"
							aria-label=".form-select-lg example" name="online">
							<option value="">select</option>

							<c:forEach items="${online}" var="o">
								<option value="${o}">${o}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						No OF Levels<select class="form-select form-select-lg mb-3"
							aria-label=".form-select-lg example" name="NoOfLevels">
							<option value="">select</option>

							<c:forEach items="${levels}" var="l">
								<option onmouseover="name" value="${l}">${l}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						playars<select class="form-select form-select-lg mb-3"
							aria-label=".form-select-lg example" name="playars">
							<option value="">select</option>

							<c:forEach items="${playars}" var="p">
								<option value="${p}">${p}</option>
							</c:forEach>
						</select>
					</div>
					<div class="mb-3">
						<label for="formGroupExampleInput" class="form-label">Game
							Wepon </label> <input type="text" class="form-control"
							id="formGroupExampleInput" placeholder="Enter Game Wepon"
							name="Wepon" />
					</div>
					<div class="d-grid gap-2 col-2 mx-auto">
						<input type="submit" value="ClickHere" class="btn btn-warning" />
					</div>

				</form>

			</div>
		</div>
	</div>
</body>
</html>