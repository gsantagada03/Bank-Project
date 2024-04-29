package com.giuseppe.demo.controller;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class DepositJSPController {
	@RequestMapping("deposit")
	public String balance(HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId != null) {
			return "Deposit.jsp";
		}
		return "redirect:/login";
	}

}
