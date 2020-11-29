package com.todo1.api.auth.entities;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;

@Getter
public class CustomUser extends UsernamePasswordAuthenticationToken{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2799269586911067020L;
	private final Integer dni;

	public CustomUser(String username, String password,Integer dni, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.dni = dni;
	}
}
