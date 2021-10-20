package com.rog.teach.springBoot.config;

import com.rog.teach.springBoot.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    //@Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return factory -> factory.setContextPath("/springBoot");
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
//            studentRepository.saveAll(List.of(
//                    new Student("Alex", LocalDate.of(2002, Month.JANUARY, 23)),
//                    new Student("Alex1", LocalDate.of(2003, Month.JANUARY, 23)),
//                    new Student("Alex2", LocalDate.of(2004, Month.JANUARY, 23)),
//                    new Student("Alex3", LocalDate.of(2005, Month.JANUARY, 23))
//            ));
        };
    }
}
