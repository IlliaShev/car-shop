package ua.shevchyk.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Healthcheck {

    @GetMapping("/healthcheck")
    public String healthcheck() {
        return "health";
    }
}
