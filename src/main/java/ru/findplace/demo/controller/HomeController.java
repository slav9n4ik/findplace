package ru.findplace.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.findplace.demo.entity.CompanyLists;
import ru.findplace.demo.entity.ContactList;
import ru.findplace.demo.entity.Owner;
import ru.findplace.demo.service.MailSender;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class HomeController {

    private final MailSender mailSender;
    private String apiKey;

    @Autowired
    public HomeController(MailSender mailSender, Environment env) {
        this.mailSender = mailSender;
        this.apiKey = env.getProperty("mailchimp.api.key");
    }

    /**
     * Данные о владельце
     * @return - Owner class
     */
    @GetMapping(value = "/owner")
    public Mono<Owner> getOwnerParams() {
        return mailSender.getOwner(apiKey);
    }

    /**
     * Возвращает список контактов email компаний, подробнее https://us20.admin.mailchimp.com/lists/
     */
    @GetMapping(value = "/lists")
    public Mono<CompanyLists> getLists() {
        Mono<CompanyLists> companyLists = mailSender.getCompanyLists(apiKey);
        return companyLists;
    }

}

