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
						aria-label="Search">

				</form>
			</div>
		</nav>
	</div>



	<form action="email" method="get">
		<pre>
	<label>Email is :${email}</label>		
	<input type="submit" value="Email" />		
			</pre>
	</form>
	<form action="mobile" method="get">
		<pre>
	<label>Mobile is :${mobile}</label>		
	<input type="submit" value="Mobile" />
	</pre>
	</form>
	<form action="aadar" method="get">
		<pre>
	<label>Aadar is :${aadar}</label>	
	<input type="submit" value="Aadar" />
	</pre>
	</form>
	<form action="age" method="get">
		<pre>
	<label>Age is :${age}</label>		
	<input type="submit" value="Age" />
	</pre>
	</form>


	<form action="date" method="get">
		<pre>
	<label>Date is :${date}</label>		
	<input type="submit" value="date" />
	</pre>
	</form>

	<form action="sal" method="get">
		<pre>
	<label>Salary is :${sal}</label>		
	<input type="submit" value="date" />
	</pre>
	</form>
	<form action="best" method="get">
		<ul>
			<label>BestFriend </label>
			<input type="submit" value="Bestfriend" />
			<c:forEach items="${lists}" var="name">
				<li>${name}</li>

			</c:forEach>
		</ul>
	</form>

	<form action="place" method="get">

		<ol>
			<label>Most Visited Places </label>
			<input type="submit" value="Place" />
			<c:forEach items="${place}" var="placename">
				<li>${placename}</li>
			</c:forEach>
		</ol>
	</form>

	<form action="set" method="get">

		<ol>
			<label>Skill Set </label>
			<input type="submit" value="SkillSet" />
			<c:forEach items="${set}" var="set">
				<li>${set}</li>
			</c:forEach>
		</ol>
	</form>

	<form action="education" method="get">
		<input type="submit" value="education" />
		<h6>Name :${dto.name}</h6>
		<h6>location :${dto.location}</h6>
		<h6>type :${dto.type}</h6>
		<h6>year :${dto.year}</h6>
		<h6>distic :${dto.distic}</h6>
		<h6>pincode :${dto.pincode}</h6>
		<h6>passesdout :${dto.passesdout}</h6>
		<h6>courseName :${dto.courseName}</h6>
		<h6>collegeName :${dto.collegeName}</h6>
	</form>
	<form action="chat">
		<input type="submit" value="Chat" />
		<h6>Name :${dto.name}</h6>
		<h6>contactname :${chat.contactname}</h6>
		<h6>contactNo :${chat.contactNo}</h6>
		<h6>personName :${chat.personName}</h6>
		<h6>chatType :${chat.chatType}</h6>
		<h6>chatHistory :${chat.chatHistory}</h6>
		<h6>chatingAppName :${chat.chatingAppName}</h6>
		<h6>network :${chat.network}</h6>
		<h6>charge :${chat.charge}</h6>
		<h6>live :${chat.live}</h6>
	</form>

	<form action="mobiles">
		<input type="submit" value="mobile">
		<h6>name :${mobile.name}</h6>
		<h6>company :${mobile.company}</h6>
		<h6>releseYear :${mobile.releseYear}</h6>
		<h6>nation :${mobile.nation}</h6>
		<h6>manufaturDate :${mobile.manufaturDate}</h6>
	</form>

	<form action="beverage">
		<input type="submit" value="Beverage" />
		<h6>name :${beverage.name}</h6>
		<h6>row :${beverage.row}</h6>
		<h6>contactno :${beverage.contactno}</h6>
		<h6>modelNo :${beverage.modelNo}</h6>
		<h6>state :${beverage.state}</h6>

	</form>
	<form action="family">
		<input type="submit" value="Family" />
		<h6>name :${beverage.name}</h6>
		<h6>fatherName :${family.fatherName}</h6>
		<h6>motherName :${family.motherName}</h6>
		<h6>sisterName :${family.sisterName}</h6>
		<h6>nativeName :${family.nativeName}</h6>
		<h6>place :${family.place}</h6>
		<h6>surname :${family.surname}</h6>
		<h6>grandFatherName${family.grandFatherName}</h6>

	</form>









</body>
</html>