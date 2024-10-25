package com.bodyiakin.demoaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DemoAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAopApplication.class, args);
    }

}
