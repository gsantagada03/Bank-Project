package com.giuseppe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giuseppe.demo.model.User;
import com.giuseppe.demo.repository.TransactionRepo;
import com.giuseppe.demo.repository.UserRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class CloseAccountController {
	@Autowired
	UserRepo userRepo;
	@Autowired
	TransactionRepo transactionRepo;

	@RequestMapping("removeUser")
	public String closeAccount(HttpSession session,org.springframework.ui.Model model,String enteredUsername, String enteredPassword) {
		Integer userId = (Integer) session.getAttribute("userId");
		User user = userRepo.findById(userId).orElse(null);
		if(userId != null && user.getUsername().equals(enteredUsername) && user.getPassword().equals(enteredPassword)) {
			transactionRepo.updateRecipientIdToNull(userId);
			transactionRepo.deleteTransactionsByUserId(userId);
			userRepo.delete(user);
			session.invalidate();
			return "redirect:aboutUs";
		}else {
			model.addAttribute("closeAccountError", "Invalid username or password");
			return "CloseAccount.jsp";
		}
	}
}

