package ru.findplace.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.findplace.demo.entity.campaign.CampaignsList;
import ru.findplace.demo.entity.campaignbooklist.CampaignsBookLists;
import ru.findplace.demo.entity.campaignbooklist.Member;
import ru.findplace.demo.entity.campaignbooklist.MembersBookList;
import ru.findplace.demo.entity.campaignbooklist.MembersList;
import ru.findplace.demo.entity.owner.Owner;
import ru.findplace.demo.entity.template.Template;
import ru.findplace.demo.entity.template.TemplateList;
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
        String id = getMemberBookIdByName(name);
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
        String id = getMemberBookIdByName(name);
        if (id != null) {
            StringBuilder query = new StringBuilder(headerUtils.getBaseUrl())
                    .append("/lists/")
                    .append(id)
                    .append("/members");
            resultMember = restTemplate.postForEntity(query.toString(),httpEntity, Member.class);
        }
        return resultMember;
    }

    @Override
    public ResponseEntity<MembersBookList> addCompanyList(MembersBookList membersBookList) {
        HttpEntity<MembersBookList> httpEntity = new HttpEntity<>(membersBookList,headerUtils.getHttpHeader());
        return restTemplate.postForEntity(headerUtils.getBaseUrl()+"/lists",httpEntity, MembersBookList.class);
    }

    private String getMemberBookIdByName(String name) {
        CampaignsBookLists bookLists = getCompanyLists().getBody();
        MembersBookList membersBookList = null;
        if (bookLists != null) {
            membersBookList = bookLists
                    .getLists()
                    .stream()
                    .filter(list -> list.getName().equals(name))
                    .findFirst()
                    .get();
        }
        return membersBookList != null ? membersBookList.getId() : null;
    }

    @Override
    public ResponseEntity<CampaignsList> getCompaignList() {
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


}
