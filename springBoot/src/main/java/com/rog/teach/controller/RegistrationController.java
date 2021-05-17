package com.rog.teach.controller;

import com.rog.teach.domain.ErrorMessage;
import com.rog.teach.domain.User;
import com.rog.teach.domain.dto.CaptchaResponseDto;
import com.rog.teach.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;


@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final static String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";

    private final UserService userService;

    private final RestTemplate restTemplate;

    @Value("${recaptcha.secret}")
    private String secret;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @RequestParam("password2") String passwordConfirm,
            @RequestParam("g-recaptcha-response") String captchaResponce,
            @Valid User user,
            BindingResult bindingResult,
            Model model
    ) throws MessagingException {
        String url = String.format(CAPTCHA_URL, secret,captchaResponce);
        CaptchaResponseDto response = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDto.class);

        if(!response.isSuccess()){
            model.addAttribute("captchaError", "Проверка каптчи не удалась");
        }

        boolean isConfirmEmpty = StringUtils.isEmpty(passwordConfirm);
        if(isConfirmEmpty) {
            model.addAttribute("password2Error", "Пароль не может быть пустым");
        }
        if (user.getPassword() != null && !user.getPassword().equals(passwordConfirm)) {
            model.addAttribute("passwordError", "Пароли разные!");
        }

        if (isConfirmEmpty || bindingResult.hasErrors() || !response.isSuccess()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errors);

            return "registration";
        }

        ErrorMessage errorMessage = userService.addUser(user);
        if (errorMessage != null) {
            if(errorMessage.getIdentificatorError() == 1) {
                model.addAttribute("usernameError", errorMessage.getText());
            } else if(errorMessage.getIdentificatorError() == 2) {
                model.addAttribute("emailError", errorMessage.getText());
            }
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isActivated = userService.activateUser(code);
        if(isActivated){
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "Активация пользователя прошла успешно.");
        } else {
            model.addAttribute("messageType", "danger");
            model.addAttribute("message", "Данный активационный код не найден.");
        }
        return "login";
    }
}
