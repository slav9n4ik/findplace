package ru.findplace.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import ru.findplace.demo.entity.companylist.Member;
import ru.findplace.demo.entity.companylist.MembersList;
import ru.findplace.demo.service.MailSender;

@RestController
@RequestMapping(value = "/api")
public class MemberController {

    private final MailSender mailSender;

    @Autowired
    public MemberController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Возвращает контакты по имени списка
     * @param name - имя списка
     * @return - список контактов
     */
    @GetMapping(value = "/members")
    public MembersList getMembersList(@RequestParam String name) {
        return mailSender.getMemberListByListName(name).getBody();
    }

    /**
     * Добавляет контакты по имени списка
     * @param name - имя списка
     */
    @PostMapping(value = "/members")
    public Member addMember(@RequestParam String name, @RequestBody Member member) {
        return mailSender.addMemberByListName(name, member).getBody();
    }
}
