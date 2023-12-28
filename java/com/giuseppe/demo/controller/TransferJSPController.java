package com.giuseppe.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class TransferJSPController {

	@RequestMapping("transfer")
	public String transfer(HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId != null) {
			return "Transfer.jsp";
		}
		return "redirect:/login";
	}
}
