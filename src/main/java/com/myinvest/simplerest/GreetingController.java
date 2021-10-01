package com.myinvest.simplerest;

// The GreetingController is the entry-point for /greeting REST request
// It is part of RESTful web service controller  structure, that is used in the SpringBoot framework
// There is a difference between MVC approach and RESTful web service. The first returns a view, while
// the last (what we are building now) will return a JSON object with data

// https://anna-dolnyk.medium.com/performance-testing-with-postman-715fa0d717e3
// Link might be interesting to experiment with (TODO)

// Swagger integration, and some more on documentation
// https://www.springboottutorial.com/spring-boot-swagger-documentation-for-rest-services
// https://www.tutorialspoint.com/spring_boot/spring_boot_enabling_swagger2.htm

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController    // This annotation, tells SpringBoot we are creating a RESTful endpoint here
public class GreetingController {

    private static final String template = "Hello, %s!";

    // Why do we need AtomicLong at this point?
    // Under the hood, multiple calls to REST endpoint creates multiple threads
    // Increment of long might go wrong , when multiple threads call increment
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        //Because we have RESTfull service (@restcontroller), the below result is
        // automatically wrapped into a JSON data object
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}