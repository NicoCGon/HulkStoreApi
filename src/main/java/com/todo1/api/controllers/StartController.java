package com.todo1.api.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {
	
	@RequestMapping(value= {"/StoreOnline"})
	public String initStoreOnline(Model model,Authentication authentication,HttpSession ses,HttpServletRequest request, HttpServletResponse response) {
		return "pages/manager";
	}
}
