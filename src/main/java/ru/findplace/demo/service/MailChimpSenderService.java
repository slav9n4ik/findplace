package ru.findplace.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.findplace.demo.entity.campaign.Campaign;
import ru.findplace.demo.entity.campaign.CampaignsList;
import ru.findplace.demo.entity.campaign.Recipients;
import ru.findplace.demo.entity.campaign.Settings;
import ru.findplace.demo.entity.campaignbooklist.CampaignsBookItem;
import ru.findplace.demo.entity.campaignbooklist.CampaignsBookLists;
import ru.findplace.demo.entity.campaignbooklist.Member;
import ru.findplace.demo.entity.campaignbooklist.MembersList;
import ru.findplace.demo.entity.template.Template;
import ru.findplace.demo.entity.template.TemplateList;
import ru.findplace.demo.response.SendCampaignErrorResponse;
import ru.findplace.demo.utils.HeaderUtils;

@Service
public class MailChimpSenderService implements MailSender {

    private RestTemplate restTemplate;
    private HeaderUtils headerUtils;

    @Autowired
    public MailChimpSenderService(HeaderUtils headerUtils) {
        this.headerUtils = headerUtils;
        restTemplate = new RestTemplate();
    }

    @Override
    public  <T> T doGet(String url, Class<T> responseType, boolean header)
    {
        HttpHeaders headers = headerUtils.getHttpHeader();
        ResponseEntity<T> responseEntity;
        if(header) {
            HttpEntity<String> entity = new HttpEntity<>("", headers);
            responseEntity = restTemplate.exchange(headerUtils.getBaseUrl() + url, HttpMethod.GET, entity, responseType);
        } else {
            responseEntity = restTemplate.getForEntity(headerUtils.getBaseUrl() + "/?apikey=" + headerUtils.getApiKey() + url, responseType);
        }
        return responseEntity.getBody();
    }

    @Override
    public <T> T doPost(String url, T responseBody, Class<T> responseType) {
        HttpHeaders headers = headerUtils.getHttpHeader();
        HttpEntity<T> entity = new HttpEntity<>(responseBody, headers);
        return restTemplate.postForEntity(headerUtils.getBaseUrl()+url ,entity, responseType).getBody();
    }
}
