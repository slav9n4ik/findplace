package ru.findplace.demo.service;

import org.springframework.http.ResponseEntity;
import ru.findplace.demo.entity.campaign.Campaign;
import ru.findplace.demo.entity.campaign.CampaignsList;
import ru.findplace.demo.entity.campaignbooklist.CampaignsBookLists;
import ru.findplace.demo.entity.campaignbooklist.Member;
import ru.findplace.demo.entity.campaignbooklist.CampaignsBookItem;
import ru.findplace.demo.entity.campaignbooklist.MembersList;
import ru.findplace.demo.entity.owner.Owner;
import ru.findplace.demo.entity.template.Template;
import ru.findplace.demo.entity.template.TemplateList;
import ru.findplace.demo.response.SendCampaignErrorResponse;

import java.net.CacheRequest;

public interface MailSender {
    ResponseEntity<Owner> getOwner();

    ResponseEntity<Campaign> addCampaign();
    ResponseEntity<CampaignsList> getCampaignList();
    ResponseEntity<CampaignsBookLists> getCompanyLists();

    ResponseEntity<MembersList> getMemberListByListName(String name);
    ResponseEntity<Member> addMemberByListName(String name, Member member);

    ResponseEntity<CampaignsBookItem> addCompanyList(CampaignsBookItem campaignsBookItem);

    ResponseEntity<TemplateList> getTemplateList();
    Template getTemplateByName(String name);

    Campaign getCampaignByName(String name);

    ResponseEntity<SendCampaignErrorResponse> sendCampaign(String name);
}
