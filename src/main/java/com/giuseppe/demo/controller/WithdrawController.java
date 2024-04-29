package com.giuseppe.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giuseppe.demo.model.Transaction;
import com.giuseppe.demo.service.UserService;


import jakarta.servlet.http.HttpSession;

@Controller
public class WithdrawController {
	@Autowired
	UserService userService;

	@RequestMapping("WithdrawMoney")
	public String withdrawMoney(Transaction transaction, HttpSession session, Model model) {
		Integer userId = (Integer) session.getAttribute("userId");

		if(userId != null) {
			boolean withdrawSuccess = userService.withdrawMoney(userId, transaction);

			if(withdrawSuccess) {
				return "redirect:/balance";
			} else {
				model.addAttribute("messageWithdraError", "Insufficient funds for withdrawal");
				return "Withdraw.jsp";
			} 
		}
		return null;
	}
}


