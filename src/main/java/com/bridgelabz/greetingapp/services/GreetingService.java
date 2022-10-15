package com.bridgelabz.greetingapp.services;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{

    @Autowired
    private GreetingRepository greetingRepository;

    private final AtomicLong counter = new AtomicLong();

    private static final String template = "Hello, %s!";

    public String getGreetingMessage() {
        return "Hello World";
    }

    @Override
    public String getGreetingMessage(User user) {
        String name = user.toString().isEmpty() ? "Hello world " : user.toString();
        return String.format(template,name);
    }

    @Override
    public Greeting addGreetingMessage(User user) {
        String name = user.toString().isEmpty() ? "Hello world " : user.toString();
        return greetingRepository.save(new Greeting(counter.incrementAndGet(),String.format(template,name)));
    }

    public String getGreeting(String fname, String lname) {
        return String.format(template, fname, lname);
    }

}
