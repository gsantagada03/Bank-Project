package com.giuseppe.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class WithdrawJSPController {

	@RequestMapping("withdraw")
	public String withdraw(HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId != null) {
			return "Withdraw.jsp";
		}
		return "redirect:/login";
	}
}
