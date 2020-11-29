package com.todo1.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo1.api.interfaces.IUserService;

@Controller
public class StartController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value= {"/StoreOnline"})
	public String initStoreOnline(Authentication authentication,Model model) {
		model.addAttribute("user",userService.findByEmail(authentication.getName()).get());
		return "pages/manager";
	}
}
