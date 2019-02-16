package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.findplace.demo.entity.campaign.CampaignsList;
import ru.findplace.demo.service.MailSender;

@RestController
@RequestMapping(value = "/api")
public class CampaignController {

    private final MailSender mailSender;
    Logger LOG = LoggerFactory.getLogger(CampaignController.class);

    @Autowired
    public CampaignController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @GetMapping(value = "/campaigns")
    public CampaignsList getCampanyList(){
        LOG.info("Get CampaignsList request");
        CampaignsList campaignsList = mailSender.getCompaignList().getBody();
        LOG.info("Get CampaignsList response: " + campaignsList);
        return campaignsList;
    }
}
