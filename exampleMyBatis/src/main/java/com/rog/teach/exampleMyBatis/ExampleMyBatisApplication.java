package com.rog.teach.exampleMyBatis;

import com.rog.teach.exampleMyBatis.entity.Users;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(Users.class)
@MapperScan("com/rog/teach/exampleMyBatis/repository")
@SpringBootApplication
public class ExampleMyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleMyBatisApplication.class, args);
    }

}
