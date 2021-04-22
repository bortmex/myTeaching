package com.rog.teach.controller;

import com.rog.teach.domain.Message;
import com.rog.teach.domain.User;
import com.rog.teach.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.ZonedDateTime;
import java.util.Map;

import static com.rog.teach.utils.DateUtils.ZONE.ZONED_DATE_TIME_EUROPE_MOSCOW;

@Controller
//@RequestMapping(path="/greeting")
public class MainController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model){
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user, @RequestParam String text, @RequestParam String tag, Map<String, Object> model){
        Message message = new Message(text, tag, ZonedDateTime.now(ZONED_DATE_TIME_EUROPE_MOSCOW.getZone()).toLocalDateTime(), user);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String text, Map<String, Object> model){
        Iterable<Message> messages;
        if(text!=null && !text.isEmpty()) {
            messages = messageRepo.findByTag(text);
            model.put("messages", messages);
            model.put("foundTag", "Ищим по тегу: " + text);
        }else {
            messages = messageRepo.findAll();
        }
        model.put("messages", messages);
        return "main";
    }
}
