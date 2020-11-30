package com.todo1.api.auth.controllers.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.todo1.api.auth.controllers.LoginController;

@SpringBootTest
public class LoginControllerTest {
	private final String EXAMPLE = "example";
	
	@Autowired
	private LoginController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void passWordEncoder() {
	    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(5);
	    String exampleEncripted = bCryptPasswordEncoder.encode(EXAMPLE);
	    assertTrue(String.join(":", exampleEncripted,exampleEncripted), !exampleEncripted.equals(EXAMPLE));
	}
}
