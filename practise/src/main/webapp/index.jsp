<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workz</title>
</head>
<body>
	<h1>Hi Hareesha</h1>
	<h1>hello</h1>
	<form action="abc" method="get">
		<input type="text" name="name" /> <input type="submit"
			value=" Submit" />
	</form>


	<h2>${names}</h2>
	<h1>${error}</h1>
	<form action="findall" method="get">
		<input type="text" name="id" /> <input type="submit" value="search" />
	</form>
	${dtos.id} ${dtos.name}
</body>
</html>