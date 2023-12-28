package com.giuseppe.demo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
@Controller
public class LoginAboutUs {
	@RequestMapping("loginAboutUs")
	public String loginAboutUs(HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId != null) {
			return "LoginAboutUs.jsp";
		}
		return "redirect:/login";
	}
}
