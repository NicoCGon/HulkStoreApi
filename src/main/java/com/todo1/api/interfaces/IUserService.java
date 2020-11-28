package com.todo1.api.interfaces;

import java.util.Optional;

import com.todo1.api.entities.User;

public interface IUserService {
	 public Optional<User> findByUsername(String username);
	 public User saveUser(User user);
}
