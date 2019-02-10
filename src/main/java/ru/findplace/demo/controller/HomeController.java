package ru.findplace.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.findplace.demo.entity.owner.Owner;
import ru.findplace.demo.service.MailSender;

@RestController
@RequestMapping(value = "/api")
public class HomeController {

    private final MailSender mailSender;

    @Autowired
    public HomeController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Данные о владельце
     * @return - Owner class
     */
    @GetMapping(value = "/owner")
    public Owner getOwnerParams() {
        return mailSender.getOwner().getBody();
    }
}

