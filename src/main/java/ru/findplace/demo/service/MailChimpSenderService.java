package ru.findplace.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import ru.findplace.demo.entity.owner.Owner;
import ru.findplace.demo.entity.template.Template;
import ru.findplace.demo.entity.template.TemplateList;
import ru.findplace.demo.response.SendCampaignErrorResponse;
import ru.findplace.demo.utils.HeaderUtils;
import ru.findplace.demo.utils.HeaderUtilsImpl;

@Service
public class MailChimpSenderService implements MailSender {

    private RestTemplate restTemplate;
    private HeaderUtils headerUtils;

    @Autowired
    public MailChimpSenderService(Environment env) {
        headerUtils = new HeaderUtilsImpl(env);
        restTemplate = new RestTemplate();
    }

    @Override
    public ResponseEntity<Owner> getOwner() {
        return restTemplate.getForEntity(headerUtils.getBaseUrl()+"/?apikey=" + headerUtils.getApiKey(), Owner.class);
    }

    @Override
    public ResponseEntity<CampaignsBookLists> getCompanyLists() {
        return restTemplate.getForEntity(headerUtils.getBaseUrl()+"/lists"+"/?apikey=" + headerUtils.getApiKey(), CampaignsBookLists.class);
    }

    @Override
    public ResponseEntity<MembersList> getMemberListByListName(String name) {
        String id = getCampaignsBookItemIdByName(name);
        ResponseEntity<MembersList> responseMembersList = null;
        if (id != null) {
            StringBuilder query = new StringBuilder(headerUtils.getBaseUrl())
                    .append("/lists/")
                    .append(id)
                    .append("/members")
                    .append("/?apikey=")
                    .append(headerUtils.getApiKey());
            responseMembersList = restTemplate.getForEntity(query.toString(), MembersList.class);
        }
        return responseMembersList;
    }

    @Override
    public ResponseEntity<Member> addMemberByListName(String name, Member member) {
        HttpEntity<Member> httpEntity = new HttpEntity<>(member,headerUtils.getHttpHeader());
        ResponseEntity<Member> resultMember = null;
        String id = getCampaignsBookItemIdByName(name);
        if (id != null) {
            StringBuilder query = new StringBuilder(headerUtils.getBaseUrl())
                    .append("/lists/")
                    .append(id)
                    .append("/members");
            resultMember = restTemplate.postForEntity(query.toString(),httpEntity, Member.class);
        }
        return resultMember;
    }

    private String getCampaignsBookItemIdByName(String name) {
        CampaignsBookLists bookLists = getCompanyLists().getBody();
        CampaignsBookItem campaignsBookItem = null;
        if (bookLists != null) {
            campaignsBookItem = bookLists
                    .getLists()
                    .stream()
                    .filter(list -> list.getName().equals(name))
                    .findFirst()
                    .get();
        }
        return campaignsBookItem != null ? campaignsBookItem.getId() : null;
    }

    //Убрать хардкод
    @Override
    public ResponseEntity<Campaign> addCampaign() {
        Campaign campaign = new Campaign();
        campaign.setType("regular");

        Recipients recipients = new Recipients();
        //Make check null
        String idCamp = getCampaignsBookItemIdByName("FindPlace");
        recipients.setListId(idCamp);
        campaign.setRecipients(recipients);

        //Не до конца заполняет
        Settings settings = new Settings();
        settings.setSubjectLine("sub_line");
        settings.setTitle("TestCampFronServer");
        settings.setFromName("From Name");
        //settings.setAutoFooter(true);
        Template template = getTemplateByName("TestTemplate");
        settings.setTemplateId(template.getId());
        campaign.setSettings(settings);

        HttpEntity<Campaign> httpEntity = new HttpEntity<>(campaign, headerUtils.getHttpHeader());
        return restTemplate.postForEntity(headerUtils.getBaseUrl() + "/campaigns",httpEntity, Campaign.class);
    }

    @Override
    public ResponseEntity<CampaignsBookItem> addCompanyList(CampaignsBookItem campaignsBookItem) {
        HttpEntity<CampaignsBookItem> httpEntity = new HttpEntity<>(campaignsBookItem,headerUtils.getHttpHeader());
        return restTemplate.postForEntity(headerUtils.getBaseUrl()+"/lists",httpEntity, CampaignsBookItem.class);
    }

    @Override
    public ResponseEntity<CampaignsList> getCampaignList() {
        return restTemplate.getForEntity(headerUtils.getBaseUrl()+"/campaigns"+"/?apikey=" + headerUtils.getApiKey(), CampaignsList.class);
    }

    @Override
    public ResponseEntity<TemplateList> getTemplateList() {
        return restTemplate.getForEntity(headerUtils.getBaseUrl()+"/templates"+"/?apikey=" + headerUtils.getApiKey(), TemplateList.class);
    }

    @Override
    public Template getTemplateByName(String name) {
        TemplateList templateList = getTemplateList().getBody();
        Template template = templateList.getTemplates()
                .stream()
                .filter(tmpl -> tmpl.getName().equals(name))
                .findFirst().get();
        return template;
    }

    @Override
    public ResponseEntity<SendCampaignErrorResponse> sendCampaign(String name) {
        HttpEntity httpEntity = new HttpEntity(headerUtils.getHttpHeader());
        //Проверка на нул
        Campaign campaign = getCampaignByName(name);
        //ResponseEntity<SendCampaignErrorResponse> request =
                restTemplate.postForLocation(
                        headerUtils.getBaseUrl() + "/campaigns/" + campaign.getId() + "/actions/send",
                         httpEntity,
                         SendCampaignErrorResponse.class);
        return new ResponseEntity<SendCampaignErrorResponse>(HttpStatus.OK);
    }

    @Override
    public Campaign getCampaignByName(String name) {
        CampaignsList campaignList = getCampaignList().getBody();
        Campaign campaign = null;
        if (campaignList != null) {
            campaign = campaignList
                    .getCampaigns()
                    .stream()
                    .filter(list -> list.getSettings().getTitle().equals(name))
                    .findFirst()
                    .get();
        }
        return campaign;
    }


}
