package com.todo1.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.api.auth.entities.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findByEmail(String email);
}