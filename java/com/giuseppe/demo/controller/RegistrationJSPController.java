package com.giuseppe.demo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationJSPController {

	@RequestMapping("registration")
	public String login() {
		return "Registration.jsp";
	}
}
