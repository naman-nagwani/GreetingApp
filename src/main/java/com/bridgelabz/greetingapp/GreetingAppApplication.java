package com.bridgelabz.greetingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingAppApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to GreetingApp");
        SpringApplication.run(GreetingAppApplication.class, args);
    }

}
