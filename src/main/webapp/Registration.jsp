<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Registration</title>
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
			<h2 id="formTitle">OPEN ACCOUNT</h2>
			<form action="addUser" method="post" id="regForm">
				<label for="name">Name:</label> <input type="text" id="name"
					name="name" required> <br> <br> <label
					for="surname">Surname:</label> <input type="text" id="surname"
					name="surname" required> <br> <br> <label
					for="username">Username:</label> <input type="text" id="username"
					name="username" required> <br> <br> <label
					for="password">Password:</label> <input type="password"
					id="password" name="password" required> <br> <br>


				<label for="address">Address:</label> <input type="text"
					id="address" name="address" required> <br> <br> <label
					for="phone">Phone:</label> <input type="tel" id="phone"
					name="phone" required> <br> <br>


				<p id="usernameError" style="color: red; visibility: hidden;">
					Invalid username</p>
				<p id="passwordError" style="color: red; visibility: hidden;">
					Invalid password</p>

				<p style="color: red;">${usernameError}</p>
				<p style="color: red;">${phoneError}</p>

				<input type="submit" value="Submit" style="margin-top: -110px;">
			</form>
		</div>
	</div>

	<script src="script.js"></script>
</body>
</html>