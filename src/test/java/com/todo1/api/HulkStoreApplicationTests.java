package com.todo1.api;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class HulkStoreApplicationTests {
	private final String EXAMPLE = "example";

	@Test
	public void passWordEncoder() {
	    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(5);
	    String exampleEncripted = bCryptPasswordEncoder.encode(EXAMPLE);
	    assertTrue(String.join(":", exampleEncripted,exampleEncripted), !exampleEncripted.equals(EXAMPLE));
	}
}
