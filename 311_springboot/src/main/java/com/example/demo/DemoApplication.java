package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

//        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
//        CustomerRepository repository = context.getBean(CustomerRepository.class);

        // save a couple of customers
//        repository.save(new Customer("Jack", "Bauer"));
//        repository.save(new Customer("Chloe", "O'Brian"));
    }



}
