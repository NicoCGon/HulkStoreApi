package com.todo1.api.services.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.todo1.api.auth.entities.User;
import com.todo1.api.repositories.AuthorityRepository;
import com.todo1.api.repositories.UserRepository;
import com.todo1.api.services.UserServiceImpl;

/* Estos test se corren con junit4 */
public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private AuthorityRepository mockRoleRepository;

    private UserServiceImpl userServiceUnderTest;
    private User user;

	@Before
    @SuppressWarnings("deprecation")
    public void setUp() {
        initMocks(this);
        userServiceUnderTest = new UserServiceImpl(mockUserRepository, mockRoleRepository);
        user = User.builder()
	                .id(1)
	                .name("Gustavo")
	                .lastName("Ponce")
	                .email("test@test.com")
	                .password("1234")
	                .build();

        Mockito.when(mockUserRepository.save((User) any())).thenReturn(user);
        Mockito.when(mockUserRepository.findByEmail(anyString())).thenReturn(Optional.of(user));
    }

    @Test
    public void testFindUserByEmail() {
        // Setup
        final String email = "test@test.com";
        final Optional<User> result = userServiceUnderTest.findByEmail(email);
        assertEquals(email, result.get().getEmail());
    }

    @Test
    public void testSaveUser() {
        // Setup
        final String email = "test@test.com";
        User result = userServiceUnderTest.saveUser(user);
        assertEquals(email, result.getEmail());
    }
    
    
}
