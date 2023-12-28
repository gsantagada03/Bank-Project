<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div id="wrapper">
		<div id="div1">
			<img src="images/immagine1.gif" id="immagine1">
			<h1 id="title1">APANA - BANK</h1>
			<h2 id="title2">Extraordinary Service</h2>

			<nav class="navbar">
				<ul>
					<li><a href="registration">NEW ACCOUNT</a>
					<li><a href="login">LOGIN</a>
					<li><a href="login">BALANCE</a>
					<li><a href="login">DEPOSIT</a>
					<li><a href="login">WITHDRAW</a>
					<li><a href="login">TRANSFER</a>
					<li><a href="login">CLOSE ACCOUNT</a>
					<li><a href="aboutUs">ABOUT US</a>
				</ul>
			</nav>

		</div>
		<div id="div2form">
			<h2 id="formTitle">LOGIN</h2>
			<form action="loginUser" method="post" id="regForm">
				<label for="username">Username:</label> <input type="text"
					id="username" name="username" required> <br> <br>


				<label for="password">Password:</label> <input type="password"
					id="password" name="password" required> <br> <br>
				<p style="color: red;">${loginError}</p>
				<input type="submit" value="Submit" style="margin-top: -110px;">

			</form>

		</div>
	</div>

</body>
</html>