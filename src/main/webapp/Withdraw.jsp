<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Withdraw</title>
</head>
<body>
	<div id="wrapper">
		<div id="div1">
			<img src="images/immagine1.gif" id="immagine1">
			<h1 id="title1">APANA - BANK</h1>
			<h2 id="title2">Extraordinary Service</h2>

			<nav class="navbar">
				<ul>
					<li><a href="registration">NEW ACCOUNT</a></li>
					<li><a href="logout">LOGOUT</a></li>
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
			<h2 id="formTitle">WITHDRAW</h2>
			<form action="WithdrawMoney" method="post" id="regForm">
				<%
				String messageError = (String) request.getAttribute("messageWithdraError");
				%>
				<%
				if (messageError != null) {
				%>
				<p style="color: red;"><%=messageError%></p>
				<%
				}
				%>

				<label for="amount">Amount:</label> <input type="number" id="amount"
					name="amount" required> <br> <br> <input
					type="hidden" name="type" value="Withdraw"> <input
					type="submit" value="Withdraw" style="margin-top: -110px;">
			</form>
		</div>
	</div>

</body>
</html>