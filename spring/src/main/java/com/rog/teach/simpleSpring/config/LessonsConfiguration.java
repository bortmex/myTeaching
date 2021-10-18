package com.rog.teach.simpleSpring.config;

import com.rog.teach.simpleSpring.entity.CommandManager;
import com.rog.teach.simpleSpring.service.GreetingService;
import com.rog.teach.simpleSpring.service.GreetingServiceImpl;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.rog.teach.simpleSpring")
@Import(AnotherConfiguration.class) //<- подключаем другой конфигуратор
//@ImportResource <- если нужно подлюдчить конфигуратор из ресурсов
@PropertySource("classpath:simpleSpring/app.properties")
public class LessonsConfiguration {

    @Bean
    GreetingService greetingService(){
        return new GreetingServiceImpl();
    }

    @Bean
    @Scope("prototype")
    public Object asyncCommand() {
        return new Object();
    }

    @Bean
    public CommandManager commandManager() {
        // возвращаем новую анонимную реализацию CommandManager
        // с новым объектом
        return new CommandManager() {
            protected Object createCommand() {
                return asyncCommand();
            }
        };
    }
}
