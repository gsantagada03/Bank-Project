package com.giuseppe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giuseppe.demo.model.Transaction;
import com.giuseppe.demo.model.User;
import com.giuseppe.demo.repository.UserRepo;
import com.giuseppe.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TransferController {
	@Autowired
	UserService userService;
	@Autowired
	UserRepo userRecipientRepo;

	@RequestMapping("TransferMoney")
	public String transferMoney(Transaction transaction, HttpSession session, Model model, String recipientUsername) {
		Integer userIdFunder = (Integer) session.getAttribute("userId");

		if (userIdFunder != null) {
			User recipientUser = userRecipientRepo.findByUsername(recipientUsername);
			if (recipientUser != null) {
				boolean transferMoneySuccess = userService.transferMoney(userIdFunder, recipientUser.getUsername(), transaction);
				if (transferMoneySuccess) {
					return "redirect:/balance";
				} else {
					model.addAttribute("messageError", "Insufficient funds for transfer");
					return "Transfer.jsp";
				}
			} else {
				model.addAttribute("messageError2", "Recipient user not found");
				return "Transfer.jsp";
			}

		}
		return null;
	}
}
