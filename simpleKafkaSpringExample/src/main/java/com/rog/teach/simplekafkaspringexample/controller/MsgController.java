package com.rog.teach.simplekafkaspringexample.controller;

import com.rog.teach.simplekafkaspringexample.entity.Address;
import com.rog.teach.simplekafkaspringexample.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
public class MsgController {

    @Autowired
    private KafkaTemplate<Long, UserDto> kafkaTemplate;

    @PostMapping
    public void sendOrder(Long msgId, UserDto msg){
        msg.setAddress(new Address("RUS", "Msk", "Lenina", 1L, 1L));
        ListenableFuture<SendResult<Long, UserDto>> future = kafkaTemplate.send("msg", msgId, msg);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }
}