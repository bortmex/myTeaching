package com.rog.teach.controller;

import com.rog.teach.domain.Message;
import com.rog.teach.domain.User;
import com.rog.teach.repos.MessageRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static com.rog.teach.controller.ControllerUtils.getErrors;
import static com.rog.teach.utils.DateUtils.ZONE.ZONED_DATE_TIME_EUROPE_MOSCOW;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MessageRepo messageRepo;

    private final HttpServletRequest request;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
            model.addAttribute("messages", messages);
        } else {
            messages = messageRepo.findAllByOrderByDateMessageDesc();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "main";
    }

    @GetMapping("/login/error")
    public String loginError(HttpSession session, Model model) {
        model.addAttribute("message", "Ошибка авторизации, пользователь не найден или не пройдена авторизация по email!");
        model.addAttribute("messageType", "danger");
        return "login";
    }

    @GetMapping("/login")
    public String login(HttpSession session, Model model) {
        model.addAttribute("showError", false);
        return "login";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @Valid Message message,
            BindingResult bindingResult,
            Model model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        message.setAuthor(user);
        message.setDateMessage(ZonedDateTime.now(ZONED_DATE_TIME_EUROPE_MOSCOW.getZone()).toLocalDateTime());

        Map<String, String> errorsMap = getErrors(bindingResult);
        if (!errorsMap.isEmpty()) {
            model.mergeAttributes(errorsMap);
            model.addAttribute("message", message);
        } else {
            saveFile(message, file);
            model.addAttribute("message", null);
            messageRepo.save(message);
        }
        Iterable<Message> messages = messageRepo.findAllByOrderByDateMessageDesc();
        model.addAttribute("messages", messages);
        return "main";
    }

    @GetMapping("/user-messages/{user}")
    public String userMessages(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Message message
    ) {
        Set<Message> messages = user.getMessages();
        model.addAttribute("messages", messages);
        model.addAttribute("message", message);
        model.addAttribute("isCurrentUser", currentUser.equals(user));
        return "userMessages";
    }

    @PostMapping("/user-messages/{user}")
    public String updateMessages(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Long user,
            @RequestParam("id") Message message,
            @RequestParam("text") String text,
            @RequestParam("tag") String tag,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        if (message.getAuthor().equals(currentUser)) {
            if (!StringUtils.isEmpty(text)) {
                message.setText(text);
            }
            if (!StringUtils.isEmpty(tag)) {
                message.setTag(tag);
            }
            if (file != null  && !Objects.requireNonNull(file.getOriginalFilename()).isEmpty()) {
                saveFile(message, file);
            }
            messageRepo.save(message);
        }
        return "redirect:/user-messages/" + user;
    }

    private void saveFile(@Valid Message message, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null && !Objects.requireNonNull(file.getOriginalFilename()).isEmpty() && file.getSize() / 1024 < 50) {
            byte[] imgBytesAsBase64 = Base64.encodeBase64(file.getBytes());
            String imgDataAsBase64 = new String(imgBytesAsBase64);
            String imgAsBase64 = "data:image/png;base64," + imgDataAsBase64;
            message.setFile(imgAsBase64);
        }
    }

}
