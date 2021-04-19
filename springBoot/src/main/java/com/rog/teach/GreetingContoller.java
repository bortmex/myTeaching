package com.rog.teach;

import com.rog.teach.domain.Message;
import com.rog.teach.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping(path="/greeting")
public class GreetingContoller {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Map<String, Object> model){
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        visibleFilterTag(model, null, false);
        return "main";
    }

    @PostMapping("add")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model){
        Message message = new Message(text, tag);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        visibleFilterTag(model, null, false);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String text, Map<String, Object> model){
        Iterable<Message> messages;
        if(text!=null && !text.isEmpty()) {
            messages = messageRepo.findByTag(text);
            model.put("messages", messages);
            visibleFilterTag(model, text, true);
        }else {
            messages = messageRepo.findAll();
            visibleFilterTag(model, null, true);
        }
        model.put("messages", messages);
        return "main";
    }

    private void visibleFilterTag(Map<String, Object> model,String tag, boolean visible){
        if(tag == null){
            model.put("tag", "");
        } else {
            model.put("tag", tag);
        }
        if(visible) {
            model.put("tagVisible", "visible");
        } else {
            model.put("tagVisible", "hidden");
        }
    }
}
