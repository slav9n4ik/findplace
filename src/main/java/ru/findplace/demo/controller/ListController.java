package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.findplace.demo.entity.campaignbooklist.CampaignsBookLists;
import ru.findplace.demo.entity.campaignbooklist.MembersBookList;
import ru.findplace.demo.service.MailSender;

@RestController
@RequestMapping(value = "/api")
public class ListController {

    private final MailSender mailSender;
    Logger LOG = LoggerFactory.getLogger(ListController.class);

    @Autowired
    public ListController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Возвращает список контактов email компаний, подробнее https://us20.admin.mailchimp.com/lists/
     */
    @GetMapping(value = "/lists")
    public CampaignsBookLists getLists() {
        LOG.info("Get CampaignsBookLists request");
        CampaignsBookLists bookLists = mailSender.getCompanyLists().getBody();
        if (bookLists != null) {
            LOG.info("Get CampaignsBookLists response: " + bookLists.toString());
        }
        return bookLists;
    }

    /**
     * Создает список контактов email компаний, подробнее https://us20.admin.mailchimp.com/lists/
     */
    @PostMapping(value = "/lists")
    public MembersBookList addList(@RequestBody MembersBookList membersBookList) {
        LOG.info("Add MembersBookList request");
        MembersBookList bookList = mailSender.addCompanyList(membersBookList).getBody();
        if (bookList != null) {
            LOG.info("Add MembersBookList response: " +bookList.toString());
        }
        return bookList;
    }
}
