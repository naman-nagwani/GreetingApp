package com.bridgelabz.greetingapp.services;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;

import java.util.List;

public interface IGreetingService {
    String getGreetingMessage();
    String getGreetingMessage(User user);
    Greeting addGreetingMessage(User user);

    Greeting getGreetingMsgById(long id);

    List<Greeting> getAllGreetingMsg();
}