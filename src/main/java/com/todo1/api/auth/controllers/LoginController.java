package com.todo1.api.auth.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todo1.api.auth.entities.User;
import com.todo1.api.auth.validator.UserValidator;
import com.todo1.api.interfaces.IUserService;


@Controller
public class LoginController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) Optional<String> error,
						@RequestParam(value="logout", required = false) Optional<String> logout, 
						Model model, RedirectAttributes flash, HttpServletRequest request) {
		
		if(error.isPresent()) {
			if(request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION") instanceof BadCredentialsException) 
        		model.addAttribute("error", ((BadCredentialsException)request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION")).getMessage());	
        	else
        		model.addAttribute("error", "Compruebe el usuario y contraseña. Si el problema persiste, contacte con el administrador de sistema!");
		}
		
		if(logout.isPresent()){
			model.addAttribute("success", "Ha cerrado sesión con éxito!");
		}

		return "principal/login";
	}

    @GetMapping(path = "/signup")
    public String singUp(Model model) {
    	return "principal/signup";
    }

    @PostMapping(path = "/createNewUser")
    public String createNewUser(@Valid User user, Model model,BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
        	List<String> dangers = bindingResult.getAllErrors().stream().map(erro -> erro.getCode()).collect(Collectors.toList());
    		model.addAttribute("dangers", dangers);
			return "principal/signup";
		}
    	userService.saveUser(user);
    	model.addAttribute("accept",new ResponseEntity<Void>(HttpStatus.CREATED)) ;
    	return "principal/signup";
    }
}
