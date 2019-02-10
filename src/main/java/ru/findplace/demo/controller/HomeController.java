package ru.findplace.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import ru.findplace.demo.entity.companylist.CompaniesBookLists;
import ru.findplace.demo.entity.companylist.Member;
import ru.findplace.demo.entity.companylist.MembersBookList;
import ru.findplace.demo.entity.companylist.MembersList;
import ru.findplace.demo.entity.owner.Owner;
import ru.findplace.demo.service.MailSender;

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
    public Owner getOwnerParams() {
        return mailSender.getOwner(apiKey).getBody();
    }

    /**
     * Возвращает список контактов email компаний, подробнее https://us20.admin.mailchimp.com/lists/
     */
    @GetMapping(value = "/lists")
    public CompaniesBookLists getLists() {
        return mailSender.getCompanyLists(apiKey).getBody();
    }

    /**
     * Создает список контактов email компаний, подробнее https://us20.admin.mailchimp.com/lists/
     */
    @PostMapping(value = "/lists")
    public MembersBookList addList(@RequestBody MembersBookList membersBookList) {
        return mailSender.addCompanyList(apiKey, membersBookList).getBody();
    }

    /**
     * Возвращает контакты по имени списка
     * @param name - имя списка
     * @return - список контактов
     */
    @GetMapping(value = "/members")
    public MembersList getMembersList(@RequestParam String name) {
        return mailSender.getMemberListByListName(name, apiKey).getBody();
    }

    /**
     * Добавляет контакты по имени списка
     * @param name - имя списка
     */
    @PostMapping(value = "/members")
    public Member addMember(@RequestParam String name, @RequestBody Member member) {
        return mailSender.addMemberByListName(name, member, apiKey).getBody();
    }

}

