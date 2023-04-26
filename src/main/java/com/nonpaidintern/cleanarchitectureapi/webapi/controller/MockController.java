package com.nonpaidintern.cleanarchitectureapi.webapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mock")
public class MockController {

    @GetMapping(path = "hello")
    public String hello() {
        return "Hello Funny";
    }
}
