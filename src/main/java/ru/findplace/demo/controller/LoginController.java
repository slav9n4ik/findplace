package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Model model) {
        Logger LOG = LoggerFactory.getLogger(LoginController.class);
        LOG.info("Login");
        return "login";
    }
}
