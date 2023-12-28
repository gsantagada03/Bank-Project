package com.giuseppe.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giuseppe.demo.model.Transaction;

import com.giuseppe.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DepositController {
	@Autowired
	UserService userService;

	@RequestMapping("DepositMoney")
	public String depositMoney(Transaction transaction, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId != null) {
			boolean deposit = userService.depositMoney(userId, transaction);

			if (deposit) {
				return "redirect:/balance";
			}
		}

		return "Login.jsp";
	}
}

