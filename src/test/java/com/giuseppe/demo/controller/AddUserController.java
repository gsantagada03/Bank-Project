package com.giuseppe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.giuseppe.demo.model.User;
import com.giuseppe.demo.repository.UserRepo;


@Controller
public class AddUserController {

	@Autowired
	UserRepo repo;

	@RequestMapping("addUser")
	public String addUser(User user, Model model) {
		if (repo.existsByUsername(user.getUsername()) && repo.existsByPhone(user.getPhone())) {
			model.addAttribute("usernameError", "Username already exists");
			model.addAttribute("phoneError", "Phone number already exists");
			return "Registration.jsp";
		}



		repo.save(user);
		return "redirect:/login";
	}
}
