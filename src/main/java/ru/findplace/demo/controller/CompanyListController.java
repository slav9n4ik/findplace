package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.findplace.demo.entity.companylist.CompaniesBookLists;
import ru.findplace.demo.entity.companylist.MembersBookList;
import ru.findplace.demo.service.MailSender;

@RestController
@RequestMapping(value = "/api")
public class CompanyListController {

    private final MailSender mailSender;
    Logger LOG = LoggerFactory.getLogger(CompanyListController.class);

    @Autowired
    public CompanyListController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Возвращает список контактов email компаний, подробнее https://us20.admin.mailchimp.com/lists/
     */
    @GetMapping(value = "/lists")
    public CompaniesBookLists getLists() {
        LOG.info("Get CompaniesBookLists request");
        CompaniesBookLists bookLists = mailSender.getCompanyLists().getBody();
        if (bookLists != null) {
            LOG.info("Get CompaniesBookLists response: " + bookLists.toString());
        }
        return bookLists;
    }

    /**
     * Создает список контактов email компаний, подробнее https://us20.admin.mailchimp.com/lists/
     */
    @PostMapping(value = "/lists")
    public MembersBookList addList(@RequestBody MembersBookList membersBookList) {
        LOG.info("Get MembersBookList request");
        MembersBookList bookList = mailSender.addCompanyList(membersBookList).getBody();
        if (bookList != null) {
            LOG.info("Get MembersBookList response: " +bookList.toString());
        }
        return bookList;
    }
}
