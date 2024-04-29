package com.giuseppe.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giuseppe.demo.model.User;
import com.giuseppe.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginUserController {
	@Autowired
	private UserService userService;

	@RequestMapping("loginUser")
	public String loginUser(User user, Model model, HttpServletRequest req) {
		User authenticatedUser = userService.authenticateUser(user);

		if (authenticatedUser != null) {
			HttpSession session = req.getSession();
			session.setAttribute("userId", authenticatedUser.getId());
			return "redirect:/balance";
		} else {
			model.addAttribute("loginError", "Invalid username or password");
			return "Login.jsp";
		}
	}
}
