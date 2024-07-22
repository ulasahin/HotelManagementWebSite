package com.example.easystay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EasyStayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyStayApplication.class, args);
    }

}
