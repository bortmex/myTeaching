package com.rog.teach.service;

import com.rog.teach.domain.Role;
import com.rog.teach.domain.User;
import com.rog.teach.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

import static com.rog.teach.domain.ErrorMessage.*;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;

    private final MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(s);
        if(StringUtils.isEmpty(user.getActivationCode())){
            throw new UsernameNotFoundException(ERROR_ACTUVATION_ACCOUNT.getText());
        }
        return userRepo.findByUsername(s);
    }

    public String addUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return ERROR_DUBL_USER.getText();
        }
        User userFromDbWithEmail = userRepo.findByEmail(user.getEmail());

        if (userFromDbWithEmail != null) {
            return ERROR_DUBL_USER_EMAIL.getText();
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        userRepo.save(user);
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format("Здорова, %s! \n" +
                            "Добро пожаловать в чатик. Пожалуйста, зайди по ссылке для активации: https://messagersrogovkrytoi.herokuapp.com/activate/%s",
                    user.getUsername(),
                    user.getActivationCode());
            mailSender.send(user.getEmail(), "Activation code", message);
        }
        return null;
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
}
