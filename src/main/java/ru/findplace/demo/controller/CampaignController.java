package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.findplace.demo.entity.campaign.Campaign;
import ru.findplace.demo.entity.campaign.CampaignsList;
import ru.findplace.demo.response.SendCampaignErrorResponse;
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
    public CampaignsList getCampaignsList(){
        LOG.info("Get CampaignsList request");
        CampaignsList campaignsList = mailSender.getCampaignList().getBody();
        LOG.info("Get CampaignsList response: " + campaignsList);
        return campaignsList;
    }

    @GetMapping(value = "/campaign")
    public Campaign getCampaignByName(@RequestParam String name){
        LOG.info("Get CampaignIdByName request");
        Campaign campaign = mailSender.getCampaignByName(name);
        LOG.info("Get CampaignsList response: " + campaign);
        return campaign;
    }

    //убрать хард-код в сервисе
    @PostMapping(value = "/campaigns")
    public Campaign addCampaign(){
        LOG.info("Add Campaign request");
        Campaign campaign = mailSender.addCampaign().getBody();
        LOG.info("Add Campaign response: " + campaign);
        return campaign;
    }

    //Написать обработчик ошибок
    @PostMapping(value = "/campaign/send")
    public ResponseEntity<SendCampaignErrorResponse> sendCampaign(@RequestParam String name){
        LOG.info("Send Campaign request");
        ResponseEntity<SendCampaignErrorResponse>  response = mailSender.sendCampaign(name);
        LOG.info("Send Campaign response" + response.getBody());
        return response;
    }
}
