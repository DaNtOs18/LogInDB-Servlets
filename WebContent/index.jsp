<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login BBDD</title>
</head>
<body>

<form action="logica" method="post">

	Usuario: <input type="text" name="usr"/>
	Contraseña: <input type="password" name="pass"/>

<input type="submit" value="LogIn" name="login">

<p id="mensaje"> </p>

</body>
</html>