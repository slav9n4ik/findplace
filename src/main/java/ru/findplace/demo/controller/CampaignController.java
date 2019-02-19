package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.findplace.demo.entity.campaign.Campaign;
import ru.findplace.demo.entity.campaign.CampaignsList;
import ru.findplace.demo.response.CampaignResponse;
import ru.findplace.demo.response.SendCampaignErrorResponse;
import ru.findplace.demo.response.base.Response;
import ru.findplace.demo.response.base.ResponseBuilder;
import ru.findplace.demo.response.base.ResponseWrapper;
import ru.findplace.demo.service.MailSender;

@RestController
@RequestMapping(value = "/api")
public class CampaignController extends ResponseBuilder {

    private final MailSender mailSender;
    Logger LOG = LoggerFactory.getLogger(CampaignController.class);

    @Autowired
    public CampaignController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @GetMapping(value = "/campaigns")
    public ResponseEntity<ResponseWrapper> getCampaignsList(){
        LOG.info("Get CampaignsList request");
        Response response;
        CampaignsList campaignsList;
        try {
            campaignsList = mailSender.getCampaignList().getBody();
            response = CampaignResponse.READ_CAMPAIGNS_SUCCESS;
            LOG.info("Get CampaignsList response: " + campaignsList);
        } catch (Exception e) {
            campaignsList = new CampaignsList();
            response = CampaignResponse.READ_CAMPAIGNS_CONFLICT;
            LOG.error("Get CampaignsList response conflict: ", e);
        }
        return render(campaignsList, response, HttpStatus.OK);
    }

    @GetMapping(value = "/campaign")
    public ResponseEntity<ResponseWrapper> getCampaignByName(@RequestParam String name){

        LOG.info("Get CampaignIdByName request");
        Campaign campaign;
        Response response;

        try {
            campaign = mailSender.getCampaignByName(name);
            response = CampaignResponse.READ_CAMPAIGN_SUCCESS;
            LOG.info("Get Campaign response: " + campaign);
        } catch (Exception e) {
            campaign = new Campaign();
            response = CampaignResponse.READ_CAMPAIGN_CONFLICT;
            LOG.error("Get Campaign response conflict: ", e);
        }
        return render(campaign, response, HttpStatus.OK);
    }

    //убрать хард-код в сервисе
    @PostMapping(value = "/campaigns")
    public ResponseEntity<ResponseWrapper> addCampaign(){

        LOG.info("Add Campaign request");
        Response response;
        Campaign campaign;

        try {
            campaign = mailSender.addCampaign().getBody();
            response = CampaignResponse.CAMPAIGN_ADD_SUCCESS;
            LOG.info("Add Campaign response: " + campaign);
        } catch (Exception e) {
            campaign = new Campaign();
            response = CampaignResponse.CAMPAIGN_ADD_CONFLICT;
            LOG.error("Add Campaign response confilct:", e);
        }
        return render(campaign, response, HttpStatus.OK);
    }

    //Написать обработчик ошибок
    @PostMapping(value = "/campaign/send")
    public ResponseEntity<ResponseWrapper> sendCampaign(@RequestParam String name){
        LOG.info("Send Campaign request");
        Response response;
        SendCampaignErrorResponse errorResponse;

        try {
            errorResponse = mailSender.sendCampaign(name).getBody();
            response = CampaignResponse.CAMPAIGN_SEND_SUCCESS;
            LOG.info("Send Campaign response" + errorResponse);
        } catch (Exception e) {
            errorResponse = new SendCampaignErrorResponse();
            response = CampaignResponse.CAMPAIGN_SEND_CONFLICT;
            LOG.error("Send Campaign conflict: ",e);
        }
        return render(errorResponse,response, HttpStatus.OK);
    }
}
