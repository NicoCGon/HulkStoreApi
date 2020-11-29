package com.todo1.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo1.api.entities.Product;
import com.todo1.api.exceptions.ProductException;
import com.todo1.api.interfaces.IProductService;
import com.todo1.api.interfaces.IUserService;
import com.todo1.api.validator.ProductValidator;

@Controller
@RequestMapping(value = "/Products")
public class ProductSaleController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ProductValidator productValidator;
	
	@GetMapping("/Sale")   
	public String saleProduct(Authentication authentication,Model model) {
		model.addAttribute("user",userService.findByEmail(authentication.getName()).get());
		return "pages/manager";
	}
	
	@PostMapping("/upProduct")   
	public String upProduct(@Valid Product product, Authentication authentication, Model model,BindingResult bindingResult) {
		productValidator.validate(product, bindingResult);
		if(bindingResult.hasErrors()) {
			List<String> dangers = bindingResult.getAllErrors().stream().map(erro -> erro.getCode()).collect(Collectors.toList());
    		model.addAttribute("dangers", dangers);
			return "principal/manager";
		}
		
		try {
			productService.upProduct(product);
		}
		catch (ProductException exception) {
			model.addAttribute("exception",exception.getMessage());
		}
		model.addAttribute("user",userService.findByEmail(authentication.getName()).get());
		return "pages/manager";
	}
	
}
