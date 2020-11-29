package com.todo1.api.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.api.entities.Authority;
import com.todo1.api.entities.User;
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
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
    public User saveUser(User user) {
        user.setEnabled(Boolean.TRUE);
        Authority authority = authorityRepository.findByAuthority("ROLE_USER");
        user.setAuthorities(new HashSet<Authority>(Arrays.asList(authority)));
        return userRepository.save(user);
    }
}