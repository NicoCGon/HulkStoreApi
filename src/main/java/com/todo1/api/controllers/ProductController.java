package com.todo1.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.todo1.api.entities.Product;
import com.todo1.api.exceptions.ProductException;
import com.todo1.api.interfaces.IProductService;
import com.todo1.api.interfaces.IUserService;

@Controller
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/Sale")   
	public String saleProduct(Authentication authentication,Model model) {
		model.addAttribute("user",userService.findByEmail(authentication.getName()).get());
		return "pages/manager";
	}
	
	@GetMapping("/Buy")   
	public String buyProduct(Authentication authentication,Model model) {
		model.addAttribute("user",userService.findByEmail(authentication.getName()).get());
		return "pages/manager";
	}
	
	@PostMapping("/upProduct")   
	public String upProduct(@Valid Product product, Authentication authentication, Model model) {
		try {
			productService.upProduct(product);
		}
		catch (ProductException e) {
			model.addAttribute("exception",e.getMessage());
		}
		model.addAttribute("user",userService.findByEmail(authentication.getName()).get());
		return "pages/manager";
	}
	
	@PostMapping("/addProduct")   
	public String addProduct(@Valid Product product, Authentication authentication, Model model) {
		try {
			productService.addProduct(product);
		}
		catch (ProductException e) {
			model.addAttribute("exception",e.getMessage());
		}
		model.addAttribute("user",userService.findByEmail(authentication.getName()).get());
		return "pages/manager";
	}
	
	@PostMapping("/drawProduct")
	public String drawProduct(@Valid Product product, Authentication authentication, Model model) {
		try {
			productService.downProduct(product);
		}
		catch (ProductException e) {
			model.addAttribute("exception",e.getMessage());
		}
		model.addAttribute("user",userService.findByEmail(authentication.getName()).get());
		return "pages/manager";
	}
	
}
