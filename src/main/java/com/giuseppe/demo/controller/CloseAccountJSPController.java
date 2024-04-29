package com.giuseppe.demo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CloseAccountJSPController {

	@RequestMapping("closeAccount")
	public String closeAccountJSP(HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId!=null) {
			return "CloseAccount.jsp";
		}
		return "redirect:/login";
	}
}
