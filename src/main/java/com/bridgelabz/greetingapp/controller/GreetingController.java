package com.bridgelabz.greetingapp.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.bridgelabz.greetingapp.Greeting;
import com.bridgelabz.greetingapp.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingService greetingService;

    /**
     * Purpose : Ability to return JSON data using GET method
     *
     * @param name
     * @return
     */

    @GetMapping("/getGreeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    /**
     * Execution URL :
     * 1. curl localhost:8080/getGreeting -w "\n"
     * 2. curl localhost:8080/getGreeting?name=Naman -w "\n"
     */

    /**
     * Purpose : Ability to return JSON data using POST method
     *
     * @param greeting
     * @return
     */

    @PostMapping("/postGreeting")
    public Greeting sayHello(@RequestBody Greeting greeting) {
        return new Greeting(counter.incrementAndGet(), String.format(template, greeting.getContent()));
    }

    /**
     * Execution URL : curl -X POST -H "Content-Type: application/json" -d '{"content":"Naman"}' "http://localhost:8080/postGreeting" -w "\n"
     */

    /**
     * Purpose : Ability to return JSON data using PUT method
     *
     * @param counter
     * @param contentName
     * @return
     */

    @PutMapping("/putGreeting/{counter}")
    public Greeting sayHello(@PathVariable int counter, @RequestParam(value = "content") String contentName) {
        return new Greeting(counter, String.format(template, contentName));
    }

    /**
     * Execution URL : curl -X PUT localhost:8080/putGreeting/1/?content=Naman -w "\n"
     */

    @GetMapping(value = "/getMessage")
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<>(greetingService.getMessage(), HttpStatus.OK);
    }

    /**
     * Execution URL : http://localhost:8080/getMessage
     */

}
