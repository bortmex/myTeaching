package com.rog.teach.simplekafkaspringexample;

import com.rog.teach.simplekafkaspringexample.entity.UserDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
@SpringBootApplication
public class SimpleKafkaSpringExampleApplication {

    @KafkaListener(topics = "msg")
    public void msgListener(ConsumerRecord<Long, UserDto> record){
        System.out.println(record.partition());
        System.out.println(record.key());
        System.out.println(record.value());
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleKafkaSpringExampleApplication.class, args);
    }

}
