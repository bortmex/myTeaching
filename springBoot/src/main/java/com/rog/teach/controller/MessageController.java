package com.rog.teach.controller;

import com.rog.teach.domain.Message;
import com.rog.teach.domain.User;
import com.rog.teach.domain.dto.MessageDto;
import com.rog.teach.repos.MessageRepo;
import com.rog.teach.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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
public class MessageController {

    private final MessageRepo messageRepo;

    private final MessageService messageService;

    private final HttpServletRequest request;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(sort =  { "id" }, direction =  Sort.Direction.DESC) Pageable pageable
    ) {
        Page<MessageDto> page = messageService.messageList(pageable, filter, user);

        model.addAttribute("page", page);
        model.addAttribute("url", "/main");
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
            @RequestParam("file") MultipartFile file,
            @PageableDefault(sort =  { "id" }, direction =  Sort.Direction.DESC) Pageable pageable
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
        Page<MessageDto> page = messageRepo.findAll(pageable, user);
        model.addAttribute("page", page);
        model.addAttribute("url", "/main");
        return "main";
    }

    @GetMapping("/user-messages/{author}")
    public String userMessages(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User author,
            Model model,
            @RequestParam(required = false) Message message,
            @PageableDefault(sort =  { "id" }, direction =  Sort.Direction.DESC) Pageable pageable
    ) {
        Page<MessageDto> page  = messageService.messageListForUser(pageable, currentUser, author);

        model.addAttribute("userChannel", author);
        model.addAttribute("subscriptionsCount", author.getSubscriptions().size());
        model.addAttribute("subscribersCount", author.getSubscribers().size());
        model.addAttribute("isSubscriber", author.getSubscribers().contains(currentUser));
        model.addAttribute("page", page);
        model.addAttribute("message", message);
        model.addAttribute("isCurrentUser", currentUser.equals(author));
        model.addAttribute("url", "/user-messages/" + author.getId());
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
            if (file != null && !Objects.requireNonNull(file.getOriginalFilename()).isEmpty()) {
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

    @GetMapping("/message/{message}/like")
    public String like(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Message message,
            RedirectAttributes redirectAttributes,
            @RequestHeader(required = false) String referer
    ) {
        Set<User> likes = message.getLikes();

        if(likes.contains(currentUser)){
            likes.remove(currentUser);
        } else {
            likes.add(currentUser);
        }

        UriComponents components = UriComponentsBuilder.fromHttpUrl(referer).build();
        components.getQueryParams()
                .forEach(redirectAttributes::addAttribute);

        messageRepo.save(message);
        return "redirect:"  + components.getPath();
    }

}
