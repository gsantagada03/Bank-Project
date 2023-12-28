<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Close Account</title>
</head>
<body>
	<div id="wrapper">
		<div id="div1">
			<img src="images/immagine1.gif" id="immagine1">
			<h1 id="title1">APANA - BANK</h1>
			<h2 id="title2">Extraordinary Service</h2>

			<nav class="navbar">
				<ul>
					<li><a href="logout">LOGOUT</a></li>
					<li><a href="registration">NEW ACCOUNT</a></li>
					<li><a href="balance">BALANCE</a></li>
					<li><a href="deposit">DEPOSIT</a></li>
					<li><a href="withdraw">WITHDRAW</a></li>
					<li><a href="transfer">TRANSFER</a></li>
					<li><a href="closeAccount">CLOSE ACCOUNT</a></li>
					<li><a href="loginAboutUs">ABOUT US</a></li>
				</ul>
			</nav>

		</div>
		<div id="div2form">
			<h2 id="formTitle">CLOSE ACCOUNT</h2>
			<form action="removeUser" method="post" id="regForm">
				<label for="enteredUsername">Username:</label> <input type="text"
					id="enteredUsername" name="enteredUsername" required> <br>
				<br> <label for="enteredPassword">Password:</label> <input
					type="password" id="enteredPassword" name="enteredPassword"
					required> <br> <br>
				<p style="color: red;">${closeAccountError}</p>
				<input type="submit" value="Close Account"
					style="margin-top: -110px;">
			</form>

		</div>
	</div>

</body>
</html>