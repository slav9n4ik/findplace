package ru.findplace.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping(value = "/home")
    public String getHomePage() {
        return "index";
    }
    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(value = "/hello")
    public String getHelloPage() {
        return "hello";
    }
}
