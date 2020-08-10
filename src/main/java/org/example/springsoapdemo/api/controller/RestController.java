package org.example.springsoapdemo.api.controller;

import org.example.springsoapdemo.api.loaneligibility.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private AtomicLong counter = new AtomicLong();
    public static final String format = "Hello, %s!";

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name, @RequestHeader(value = "appName", defaultValue = "Greeter") String appName) {
        System.out.println("appName : " + appName);
        return new Greeting(counter.incrementAndGet(), String.format(format,name));
    }
}
