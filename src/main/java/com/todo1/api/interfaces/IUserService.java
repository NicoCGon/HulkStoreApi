package com.todo1.api.interfaces;

import java.util.Optional;

import com.todo1.api.auth.entities.User;

public interface IUserService {
	 public Optional<User> findByEmail(String username);
	 public User saveUser(User user);
}
