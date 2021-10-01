package com.myinvest.simplerest;

/**
 * Some HATEOAS example, based on: https://spring.io/guides/gs/rest-hateoas/
 */
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class HATEOASController {

    private static final String TEMPLATE = "Hello, %s!";

    @GetMapping("/greet")
    public SayHi greet(
            @RequestParam(value = "name", defaultValue = "World") String name) {

        SayHi greeting = new SayHi(String.format(TEMPLATE, name));

        // A link is added to the ReplyBody, that will reference back to the 'greeting' in GreetingController
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

        return greeting;
    }

    // An example with expliciti HttpEntity
    // This is not really necessary, while springboot does it for you (see example above 'greet')
    @GetMapping("/he_greet")
    public HttpEntity<SayHi> he_greet(
            @RequestParam(value = "name", defaultValue = "World") String name) {

        SayHi greeting = new SayHi(String.format(TEMPLATE, name));

        // A link is added to the ReplyBody, that will reference back to the 'greeting' in GreetingController
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

        return new ResponseEntity(greeting, HttpStatus.OK);
    }
}


