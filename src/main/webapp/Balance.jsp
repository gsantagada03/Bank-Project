<%@page import="com.giuseppe.demo.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.giuseppe.demo.model.Transaction"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Comparator"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Balance</title>
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
			<h2 id="formTitle">BALANCE</h2>
			<h2>Transactions</h2>

			<%
			String messageSuccesful = (String) request.getAttribute("messageSuccesful");
			%>
			<%
			if (messageSuccesful != null) {
			%>
			<p style="color: green;"><%=messageSuccesful%></p>
			<%
			}
			%>

			<p>
				Balance:
				<%=request.getAttribute("balance")%></p>

			<table border="1">
				<tr>
					<th>Type</th>
					<th>Amount</th>
					<th>Date</th>
				</tr>
				<%
				List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
				List<Transaction> recipientTransactions = (List<Transaction>) request.getAttribute("recipientTransactions");

				// Combina le due liste
				List<Transaction> allTransactions = new ArrayList<>();
				if (transactions != null) {
					allTransactions.addAll(transactions);
				}
				if (recipientTransactions != null) {
					allTransactions.addAll(recipientTransactions);
				}

				Collections.sort(allTransactions, Comparator.comparing(Transaction::getDate).reversed());
				if (allTransactions != null && !allTransactions.isEmpty()) {
					for (Transaction transaction : allTransactions) {
				%>
				<tr>
					<td><%=transaction.getType()%></td>
					<td><%=transaction.getAmount()%></td>
					<td><%=transaction.getDate()%></td>
				</tr>
				<%
				}
				} else {
				%>
				<p>No transactions available</p>
				<%
				}
				%>
			</table>
		</div>
	</div>
</body>
</html>