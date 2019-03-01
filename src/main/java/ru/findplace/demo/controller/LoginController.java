package ru.findplace.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
//    @RequestMapping(value = "/")
//    public String index() {
//        return "index";
//    }
    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }
//
//    @GetMapping(value = "/hello")
//    public String getHelloPage() {
//        return "hello";
//    }
}
