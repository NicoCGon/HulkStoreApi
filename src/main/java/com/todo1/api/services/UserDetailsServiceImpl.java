package com.todo1.api.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todo1.api.entities.Authority;
import com.todo1.api.entities.User;
import com.todo1.api.repositories.AuthorityRepository;
import com.todo1.api.repositories.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;
	
	@Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario")); 
    	Set<Authority> rolesList = user.getAuthorities();
    	List<Authority> authorityList = (List<Authority>) authorityRepository.findAll();
    	if(rolesList instanceof List) {
        	List grantList = rolesList.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
//        	UserDetails userSesion = (UserDetails) User.builder().username(user.getUsername()).password(user.getPassword()).authorities((Set<Authority>) grantList).build();
        	UserDetails userSesion = (UserDetails) user;
        	return userSesion;
    	}
    	else{
    		throw new UsernameNotFoundException("El usuario no tiene un rol asignado");
    	}
    	
    }
}
