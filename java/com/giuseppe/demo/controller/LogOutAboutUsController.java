package com.giuseppe.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogOutAboutUsController {

	@RequestMapping("aboutUs")
	public String home() {
		return "LogOutAboutUs.jsp";
	}
}
