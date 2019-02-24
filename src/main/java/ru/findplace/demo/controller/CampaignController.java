package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.findplace.demo.Dtos.mailchimp.campaign.Campaign;
import ru.findplace.demo.Dtos.mailchimp.campaign.CampaignsList;
import ru.findplace.demo.response.CampaignResponse;
import ru.findplace.demo.response.SendCampaignErrorResponse;
import ru.findplace.demo.response.base.Response;
import ru.findplace.demo.response.base.ResponseBuilder;
import ru.findplace.demo.response.base.ResponseWrapper;
import ru.findplace.demo.service.campaign.CampaignService;

@RestController
@RequestMapping(value = "/api")
public class CampaignController extends ResponseBuilder {

    private final CampaignService campaignService;
    Logger LOG = LoggerFactory.getLogger(CampaignController.class);

    @Autowired
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping(value = "/campaigns")
    public ResponseEntity<ResponseWrapper> getCampaignsList(){
        LOG.info("Get CampaignsList request");
        Response response;
        CampaignsList campaignsList;
        try {
            campaignsList = campaignService.getCampaignList();
            response = CampaignResponse.READ_CAMPAIGNS_SUCCESS;
            LOG.info("Get CampaignsList response: " + campaignsList);
        } catch (Exception e) {
            campaignsList = new CampaignsList();
            response = CampaignResponse.READ_CAMPAIGNS_CONFLICT;
            LOG.error("Get CampaignsList response conflict: " + e.getMessage());
        }
        return render(campaignsList, response, HttpStatus.OK);
    }

    @GetMapping(value = "/campaign")
    public ResponseEntity<ResponseWrapper> getCampaignByName(@RequestParam String name){

        LOG.info("Get CampaignIdByName request");
        Campaign campaign;
        Response response;

        try {
            campaign = campaignService.getCampaignByName(name);
            response = CampaignResponse.READ_CAMPAIGN_SUCCESS;
            LOG.info("Get Campaign response: " + campaign);
        } catch (Exception e) {
            campaign = new Campaign();
            response = CampaignResponse.READ_CAMPAIGN_CONFLICT;
            LOG.error("Get Campaign response conflict: " + e.getMessage());
        }
        return render(campaign, response, HttpStatus.OK);
    }

    @PostMapping(value = "/campaigns")
    public ResponseEntity<ResponseWrapper> addCampaign(@RequestBody Campaign campaignRequestDto){

        LOG.info("Add Campaign request");
        Response response;
        Campaign campaignResponseDto;

        try {
            campaignResponseDto = campaignService.addCampaign(campaignRequestDto);
            response = CampaignResponse.CAMPAIGN_ADD_SUCCESS;
            LOG.info("Add Campaign response: " + campaignResponseDto);
        } catch (Exception e) {
            campaignResponseDto = new Campaign();
            response = CampaignResponse.CAMPAIGN_ADD_CONFLICT;
            LOG.error("Add Campaign response confilct:" + e.getMessage());
        }
        return render(campaignResponseDto, response, HttpStatus.OK);
    }

    @PostMapping(value = "/campaign/{id}/send")
    public ResponseEntity<ResponseWrapper> sendCampaign(@PathVariable String id){
        LOG.info("Send Campaign request");
        Response response;
        SendCampaignErrorResponse errorResponse;

        try {
            errorResponse = campaignService.sendCampaign(id);
            response = CampaignResponse.CAMPAIGN_SEND_SUCCESS;
            LOG.info("Send Campaign response" + errorResponse);
        } catch (Exception e) {
            errorResponse = new SendCampaignErrorResponse();
            response = CampaignResponse.CAMPAIGN_SEND_CONFLICT;
            LOG.error("Send Campaign conflict: " + e.getMessage());
        }
        return render(errorResponse,response, HttpStatus.OK);
    }

    //не работает корректно
    @PostMapping(value = "/campaign/{id}/re-send")
    public ResponseEntity<ResponseWrapper> resendCampaign(@PathVariable String id){
        LOG.info("ReSend Campaign request");
        Response response;
        SendCampaignErrorResponse errorResponse;

        try {
            errorResponse = campaignService.resendCampaign(id);
            response = CampaignResponse.CAMPAIGN_RESEND_SUCCESS;
            LOG.info("ReSend Campaign response" + errorResponse);
        } catch (Exception e) {
            errorResponse = new SendCampaignErrorResponse();
            response = CampaignResponse.CAMPAIGN_RESEND_CONFLICT;
            LOG.error("ReSend Campaign conflict: " + e.getMessage());
        }
        return render(errorResponse,response, HttpStatus.OK);
    }
}
