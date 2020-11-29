package com.todo1.api;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import com.todo1.api.auth.entities.CustomUser;
import com.todo1.api.auth.entities.User;
import com.todo1.api.interfaces.IUserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	IUserService userservice;
 
    @Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
  
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
         
        User user = userservice.findByEmail(email).orElseThrow(() -> new BadCredentialsException("Usuario no existente"));
    	if(BCrypt.checkpw(password, user.getPassword())) {
       	 	Set<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                    .map(p -> new SimpleGrantedAuthority(p.getAuthority()))
                    .collect(Collectors.toSet());
        	return new CustomUser(user.getEmail(), user.getPassword(),user.getAge(),grantedAuthorities);
    	}
    	else {
    		throw new BadCredentialsException("Contrasena es incorrecta");
    	}
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
