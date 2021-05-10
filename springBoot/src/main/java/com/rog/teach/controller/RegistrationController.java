package com.rog.teach.controller;

import com.rog.teach.domain.User;
import com.rog.teach.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;


@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model) {
        boolean passwordNotCorrect = user.getPassword() != null && !user.getPassword().equals(user.getPassword2());

        if(bindingResult.hasErrors() || passwordNotCorrect){
            if(bindingResult.hasErrors()) {
                Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
                model.mergeAttributes(errors);
            }
            if(passwordNotCorrect){
                model.addAttribute("passwordError", "Пароли не равны!");
            }
            return "registration";
        }
        String message = userService.addUser(user);
        if (StringUtils.isNotEmpty(message)) {
            model.addAttribute("usernameError", message);
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isActivated = userService.activateUser(code);
        if(isActivated){
            model.addAttribute("message", "Активация пользователя прошла успешно.");
        } else {
            model.addAttribute("message", "Активация пользователя не пройдена.");
        }
        return "login";
    }
}
