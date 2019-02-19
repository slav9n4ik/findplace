package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.findplace.demo.entity.campaignbooklist.CampaignsBookItem;
import ru.findplace.demo.entity.campaignbooklist.CampaignsBookLists;
import ru.findplace.demo.response.ListResponse;
import ru.findplace.demo.response.base.Response;
import ru.findplace.demo.response.base.ResponseBuilder;
import ru.findplace.demo.response.base.ResponseWrapper;
import ru.findplace.demo.service.MailSender;

@RestController
@RequestMapping(value = "/api")
public class ListController extends ResponseBuilder {

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
    public ResponseEntity<ResponseWrapper> getLists() {
        LOG.info("Get CampaignsBookLists request");
        CampaignsBookLists bookLists;
        ListResponse response;
        try {
            bookLists = mailSender.getCompanyLists().getBody();
            response = ListResponse.LIST_READ_SUCCESS;
            LOG.info("Get CampaignsBookLists response: " + bookLists.toString());
        } catch (Exception e) {
            bookLists = new CampaignsBookLists();
            response = ListResponse.LIST_READ_CONFLICT;
            LOG.error("Get CampaignsBookLists response conflict: ", e);
        }
        return render(bookLists, response, HttpStatus.OK);
    }

    /**
     * Создает список контактов email компаний, подробнее https://us20.admin.mailchimp.com/lists/
     */
    @PostMapping(value = "/lists")
    public ResponseEntity<ResponseWrapper> addList(@RequestBody CampaignsBookItem campaignsBookItem) {
        Response response;
        CampaignsBookItem bookList;

        LOG.info("Add CampaignsBookItem request");
        try {
            bookList = mailSender.addCompanyList(campaignsBookItem).getBody();
            response = ListResponse.LIST_ADD_SUCCESS;
            LOG.info("Add CampaignsBookItem response: " +bookList.toString());
        } catch (Exception e) {
            bookList = new CampaignsBookItem();
            response = ListResponse.LIST_ADD_CONFLICT;
            LOG.error("Add CampaignsBookItem response conflict: ", e);
        }
        return render(bookList, response, HttpStatus.OK);
    }
}
