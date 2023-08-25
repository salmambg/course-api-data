package io.javabrains.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //that indicates this class will handle HTTP requests and produce JSON or XML responses directly.
public class HelloController {

    @RequestMapping("/hello")
    public String sayHi () {
        return "hi";
    }

    @RequestMapping("/")
    public String sayHome () {
        return "home";
    }
}
