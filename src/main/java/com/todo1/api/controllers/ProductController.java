package com.todo1.api.controllers;

import java.math.BigInteger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	
	@PostMapping("/addProduct")   
	public String addProduct(@RequestParam("quantity") BigInteger quantity, Model model) {
		return "pages/manager";
	}
	
	@PostMapping("/drawProduct")
	public String drawProduct() {
		return "pages/manager";
	}
	
}
