package com.todo1.api;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class HulkStoreApplicationTests {

	@Test
	void contextLoads() {
	}
	

	@Test
	public void passWordEncoder() {
	    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(30);
	    System.out.println(bCryptPasswordEncoder.encode("1234"));
	}
}
