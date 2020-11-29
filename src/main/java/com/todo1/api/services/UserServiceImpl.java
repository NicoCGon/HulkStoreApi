package com.todo1.api.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.todo1.api.auth.entities.Authority;
import com.todo1.api.auth.entities.User;
import com.todo1.api.interfaces.IUserService;
import com.todo1.api.repositories.AuthorityRepository;
import com.todo1.api.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

	@Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email); 
    }

	@Override
    public User saveUser(User user) {
        user.setEnabled(Boolean.TRUE);
        Authority authority = authorityRepository.findByAuthority("ROLE_USER");
        Set<Authority> userAuthorityList = new HashSet<Authority>(Arrays.asList(authority));
        user.setAuthorities(userAuthorityList);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(5);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}