package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.findplace.demo.entity.campaignbooklist.Member;
import ru.findplace.demo.entity.campaignbooklist.MembersList;
import ru.findplace.demo.response.MemberResponse;
import ru.findplace.demo.response.base.Response;
import ru.findplace.demo.response.base.ResponseBuilder;
import ru.findplace.demo.response.base.ResponseWrapper;
import ru.findplace.demo.service.MailSender;

@RestController
@RequestMapping(value = "/api")
public class MemberController extends ResponseBuilder {

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
    public ResponseEntity<ResponseWrapper> getMembersList(@RequestParam String name) {
        LOG.info("Get MembersList request");
        Response response;
        MembersList membersList;
        try {
            membersList = mailSender.getMemberListByListName(name).getBody();
            response = MemberResponse.MEMBER_READ_SUCCESS;
            LOG.info("Get MembersList response: " + membersList.toString());
        }catch (Exception e) {
            membersList = new MembersList();
            response = MemberResponse.MEMBER_READ_CONFLICT;
            LOG.error("Get MembersList response conflict: ", e);
        }
        return render(membersList, response, HttpStatus.OK);
    }

    /**
     * Добавляет контакты по имени списка
     * @param name - имя списка
     */
    @PostMapping(value = "/members")
    public ResponseEntity<ResponseWrapper> addMember(@RequestParam String name, @RequestBody Member member) {
        LOG.info("Add Member request");
        Member responseMember;
        Response response;
        try {
            responseMember = mailSender.addMemberByListName(name, member).getBody();
            response = MemberResponse.MEMBER_ADD_SUCCESS;
            LOG.info("Add Member response: " + responseMember.toString());
        } catch (Exception e) {
            responseMember = new Member();
            response = MemberResponse.MEMBER_ADD_CONFLICT;
            LOG.error("Add Member response conflict: ", e);
        }
        return render(responseMember, response, HttpStatus.OK);
    }
}
