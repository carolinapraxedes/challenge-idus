package com.idus.idus.controller;

import com.idus.idus.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return helloWorldService.hello();
    }
    @PostMapping("/hello/soma")
    public Integer saySoma(@RequestParam Integer a, @RequestParam Integer b) {
        return helloWorldService.soma(a,b);
    }
}
