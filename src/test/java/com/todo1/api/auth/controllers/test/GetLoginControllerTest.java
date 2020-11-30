package com.todo1.api.auth.controllers.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class GetLoginControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getLoginTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/HulkStore/login",
				String.class)).contains("Login TODO 1");
	}

	@Test
	public void getSignUpnTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/HulkStore/signup",
				String.class)).contains("Sign Up TODO 1");
	}
}
