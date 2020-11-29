package com.todo1.api.login.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.api.auth.entities.User;
import com.todo1.api.interfaces.IUserService;
import com.todo1.api.repositories.AuthorityRepository;
import com.todo1.api.repositories.UserRepository;
import com.todo1.api.services.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;
    
    @Mock
    private AuthorityRepository mockAuthorityRepository;
    
    @Autowired
    private IUserService userService;
    
    private User user;
    private UserServiceImpl userServiceUnderTest;

    @Before
    public void setUp() {
        userServiceUnderTest = new UserServiceImpl(mockUserRepository,
        										   mockAuthorityRepository);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(5);
//		user = User.builder()
//				.id(1)
//				.username("test@test.com")
//				.password(bCryptPasswordEncoder.encode("1234"))
//				.build();
//		
//		Mockito.when(mockUserRepository.save((User) any()))
//				.thenReturn(user);
//        Mockito.when(mockUserRepository.findByUsername(any()))
//                .thenReturn(Optional.of(user));
    }

    @Test
    public void testFindUserByEmail() {
        // Setup
 		String email = "test@test.com";
 		Optional<User> result = userServiceUnderTest.findByEmail(email);
        assertEquals("No se encontro el usuario", email, result.isPresent() ? result.get().getEmail() : new String());
    }

    @Test
    public void testSaveUser() {
        // Setup
        String email = "nicolasgonzalez995@hotmail.com";
//        User result = userService.saveUser(User.builder().username("test@test.com").build());
//        assertEquals(email, result.getUsername());
    }
}
