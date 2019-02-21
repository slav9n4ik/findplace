package ru.findplace.demo.service.campaign;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.findplace.demo.entity.campaign.Campaign;
import ru.findplace.demo.entity.campaign.CampaignsList;
import ru.findplace.demo.entity.campaign.Recipients;
import ru.findplace.demo.entity.campaign.Settings;
import ru.findplace.demo.entity.template.Template;
import ru.findplace.demo.response.SendCampaignErrorResponse;

public class CampaignServiceImpl  {
//    //Убрать хардкод
//    @Override
//    public ResponseEntity<Campaign> addCampaign() {
//        Campaign campaign = new Campaign();
//        campaign.setType("regular");
//
//        Recipients recipients = new Recipients();
//        //Make check null
//        String idCamp = getCampaignsBookItemIdByName("FindPlace");
//        recipients.setListId(idCamp);
//        campaign.setRecipients(recipients);
//
//        //Не до конца заполняет
//        Settings settings = new Settings();
//        settings.setSubjectLine("sub_line");
//        settings.setTitle("TestCampFronServer");
//        settings.setFromName("From Name");
//        //settings.setAutoFooter(true);
//        Template template = getTemplateByName("TestTemplate");
//        settings.setTemplateId(template.getId());
//        campaign.setSettings(settings);
//
//        HttpEntity<Campaign> httpEntity = new HttpEntity<>(campaign, headerUtils.getHttpHeader());
//        return restTemplate.postForEntity(headerUtils.getBaseUrl() + "/campaigns",httpEntity, Campaign.class);
//    }
//
//    @Override
//    public ResponseEntity<CampaignsList> getCampaignList() {
//        return restTemplate.getForEntity(headerUtils.getBaseUrl()+"/campaigns"+"/?apikey=" + headerUtils.getApiKey(), CampaignsList.class);
//    }
//    @Override
//    public ResponseEntity<SendCampaignErrorResponse> sendCampaign(String name) {
//        HttpEntity httpEntity = new HttpEntity(headerUtils.getHttpHeader());
//        //Проверка на нул
//        Campaign campaign = getCampaignByName(name);
//        //ResponseEntity<SendCampaignErrorResponse> request =
//        restTemplate.postForLocation(
//                headerUtils.getBaseUrl() + "/campaigns/" + campaign.getId() + "/actions/send",
//                httpEntity,
//                SendCampaignErrorResponse.class);
//        return new ResponseEntity<SendCampaignErrorResponse>(HttpStatus.OK);
//    }
//
//    @Override
//    public Campaign getCampaignByName(String name) {
//        CampaignsList campaignList = getCampaignList().getBody();
//        Campaign campaign = null;
//        if (campaignList != null) {
//            campaign = campaignList
//                    .getCampaigns()
//                    .stream()
//                    .filter(list -> list.getSettings().getTitle().equals(name))
//                    .findFirst()
//                    .get();
//        }
//        return campaign;
//    }
}
