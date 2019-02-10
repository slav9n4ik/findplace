package ru.findplace.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import ru.findplace.demo.entity.companylist.CompaniesBookLists;
import ru.findplace.demo.entity.companylist.MembersBookList;
import ru.findplace.demo.service.MailSender;

@RestController
@RequestMapping(value = "/api")
public class CompanyListController {
    private final MailSender mailSender;

    @Autowired
    public CompanyListController(MailSender mailSender, Environment env) {
        this.mailSender = mailSender;
    }

    /**
     * Возвращает список контактов email компаний, подробнее https://us20.admin.mailchimp.com/lists/
     */
    @GetMapping(value = "/lists")
    public CompaniesBookLists getLists() {
        return mailSender.getCompanyLists().getBody();
    }

    /**
     * Создает список контактов email компаний, подробнее https://us20.admin.mailchimp.com/lists/
     */
    @PostMapping(value = "/lists")
    public MembersBookList addList(@RequestBody MembersBookList membersBookList) {
        return mailSender.addCompanyList(membersBookList).getBody();
    }
}
