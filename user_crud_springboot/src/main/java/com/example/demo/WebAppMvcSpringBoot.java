package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@PropertySource(value = "classpath:application.properties")
@SpringBootApplication
//@EnableJpaAuditing
public class WebAppMvcSpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(WebAppMvcSpringBoot.class, args);
    }

}
