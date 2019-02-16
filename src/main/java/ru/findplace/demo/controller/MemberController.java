package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.findplace.demo.entity.campaignbooklist.Member;
import ru.findplace.demo.entity.campaignbooklist.MembersList;
import ru.findplace.demo.service.MailSender;

@RestController
@RequestMapping(value = "/api")
public class MemberController {

    private final MailSender mailSender;
    Logger LOG = LoggerFactory.getLogger(MemberController.class);

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
        LOG.info("Get MembersList request");
        MembersList membersList = mailSender.getMemberListByListName(name).getBody();
        if (membersList != null) {
            LOG.info("Get MembersList response: " + membersList.toString());
        }
        return membersList;
    }

    /**
     * Добавляет контакты по имени списка
     * @param name - имя списка
     */
    @PostMapping(value = "/members")
    public Member addMember(@RequestParam String name, @RequestBody Member member) {
        LOG.info("Add Member request");
        Member responseMember = mailSender.addMemberByListName(name, member).getBody();
        if (responseMember != null) {
            LOG.info("Add Member response: " + responseMember.toString());
        }
        return responseMember;
    }
}
