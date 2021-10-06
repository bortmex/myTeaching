package com.rog.teach.simpleSpring.service;

import com.rog.teach.domain.ErrorMessage;
import com.rog.teach.domain.Role;
import com.rog.teach.domain.User;
import com.rog.teach.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.*;
import java.util.stream.Collectors;

import static com.rog.teach.domain.ErrorMessage.*;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;

    private final MailSender mailSender;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException(ERROR_NOT_FOUND_USER.getText());
        }
        if(!"null".equals(user.getActivationCode())){
            throw new UsernameNotFoundException(ERROR_ACTUVATION_ACCOUNT.getText());
        }
        return userRepo.findByUsername(s);
    }

    public ErrorMessage addUser(User user) throws MessagingException {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return ERROR_DUBL_USER;
        }
        User userFromDbWithEmail = userRepo.findByEmail(user.getEmail());

        if (userFromDbWithEmail != null) {
            return ERROR_DUBL_USER_EMAIL;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        sendMessage(user);
        return null;
    }

    private void sendMessage(User user) throws MessagingException {
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format("Здорова, %s! \n" +
                            "Добро пожаловать в чатик. Пожалуйста, зайди по ссылке для активации: <a href=\"https://messagersrogovkrytoi.herokuapp.com/activate/%s\">Ссылка</a>",
                    user.getUsername(),
                    user.getActivationCode());
            mailSender.send(user.getEmail(), "Код активации.", message);
        }
    }

    public boolean activateUser(String code) {

        User user = userRepo.findByActivationCode(code);
        if (user == null) {
            return false;
        }

        user.setActivationCode("null");
        userRepo.save(user);
        return true;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void saveUser(User user, String username, Map<String, String> form) {
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key:form.keySet()) {
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
    }

    public void updateProfile(User user, String password, String email) throws MessagingException {
        String userEmail = user.getEmail();

        boolean isEmailChanged = (email != null && !email.equals(userEmail)) ||
                (userEmail != null && !userEmail.equals(email));

        if (isEmailChanged) {
            user.setEmail(email);

            if (!StringUtils.isEmpty(email)) {
                user.setActivationCode(UUID.randomUUID().toString());
            }
        }

        if (!StringUtils.isEmpty(password)) {
            user.setPassword(passwordEncoder.encode(password));
        }

        userRepo.save(user);

        if (isEmailChanged) {
            sendMessage(user);
        }
    }

    public void subscribe(User currentUser, User user) {
        user.getSubscribers().add(currentUser);
        userRepo.save(user);
    }

    public void unsubscribe(User currentUser, User user) {
        user.getSubscribers().remove(currentUser);
        userRepo.save(user);
    }
}
