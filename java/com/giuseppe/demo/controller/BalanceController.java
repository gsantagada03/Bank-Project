package com.giuseppe.demo.controller;





import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giuseppe.demo.model.Transaction;
import com.giuseppe.demo.model.User;
import com.giuseppe.demo.repository.TransactionRepo;
import com.giuseppe.demo.repository.UserRepo;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BalanceController {

	@Autowired
	UserRepo userRepo;
	@Autowired
	TransactionRepo transactionRepo;

	@RequestMapping("balance")
	public String balance(HttpSession session, Model model, HttpServletRequest req) {
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId!= null) {
			User user = userRepo.findById(userId).orElse(null);
			List <Transaction> transactions = transactionRepo.findTransactionsByUserId(userId);
			List <Transaction> recipientTransactions = transactionRepo.findTransactionsByRecipientId(userId);
			Double balance = user.getBalance();
			if(balance == null) {
				balance = 0.0;
			}
			req.setAttribute("balance", balance);
			req.setAttribute("transactions", transactions);
			req.setAttribute("recipientTransactions", recipientTransactions);
			return "Balance.jsp";
		}
		return "redirect:/login";
	}
}
