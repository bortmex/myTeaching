package com.rog.teach.simpleSpring.service;

import com.rog.teach.domain.ErrorMessage;
import com.rog.teach.domain.Role;
import com.rog.teach.domain.User;
import com.rog.teach.repos.UserRepo;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.util.Collections;

import static com.rog.teach.domain.ErrorMessage.ERROR_DUBL_USER;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepo userRepo;

    @MockBean
    private MailSender mailSender;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    void addUserTest() throws MessagingException {
        User user = new User();
        user.setActivationCode("null");
        ErrorMessage errorMessage = userService.addUser(user);

        Assert.assertNotNull(user.getActivationCode());
        Assert.assertNull(errorMessage);
        Assert.assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));

        Mockito.verify(userRepo, Mockito.times(1)).save(user);
//        Mockito.verify(mailSender, Mockito.times(1)).send(
//                ArgumentMatchers.anyString(),
//                ArgumentMatchers.anyString(),
//                ArgumentMatchers.anyString()
//        );
    }

    @Test
    public void addUserFailTest() throws MessagingException {
        User user = new User();
        user.setActivationCode("null");
        user.setUsername("rogov");
        Mockito.doReturn(new User())
                .when(userRepo)
                .findByUsername("rogov");
        ErrorMessage errorMessage = userService.addUser(user);

        Assert.assertEquals(errorMessage, ERROR_DUBL_USER);
    }


    @Test
    void addUserFailInBaseTest() throws MessagingException {
        User user = new User();
        user.setActivationCode("null");
        user.setUsername("rogov");
        Mockito.doReturn(new User())
                .when(userRepo)
                .findByUsername("rogov");
        ErrorMessage errorMessage = userService.addUser(user);

        Assert.assertEquals(errorMessage, ERROR_DUBL_USER);

        Mockito.verify(userRepo, Mockito.times(0)).save(ArgumentMatchers.any(User.class));
        Mockito.verify(mailSender, Mockito.times(0))
                .send(
                        ArgumentMatchers.anyString(),
                        ArgumentMatchers.anyString(),
                        ArgumentMatchers.anyString()
                );
    }

    @Test
    void activateUserTest() {
        User user = new User();

        user.setActivationCode("bingo!");
        Mockito.doReturn(user)
                .when(userRepo)
                .findByActivationCode("activate");

        boolean isUserActivate = userService.activateUser("activate");

        Assert.assertTrue(isUserActivate);
        Assert.assertNotNull(user.getActivationCode());

        Mockito.verify(userRepo, Mockito.times(1)).save(user);
    }

    @Test
    void activateUserFailTest() {
        boolean isUserActivated = userService.activateUser("activate me");

        Assert.assertFalse(isUserActivated);

        Mockito.verify(userRepo, Mockito.times(0)).save(ArgumentMatchers.any(User.class));
    }
}