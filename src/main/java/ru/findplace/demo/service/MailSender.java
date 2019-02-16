package ru.findplace.demo.service;

import org.springframework.http.ResponseEntity;
import ru.findplace.demo.entity.campaign.CampaignsList;
import ru.findplace.demo.entity.campaignbooklist.CampaignsBookLists;
import ru.findplace.demo.entity.campaignbooklist.Member;
import ru.findplace.demo.entity.campaignbooklist.MembersBookList;
import ru.findplace.demo.entity.campaignbooklist.MembersList;
import ru.findplace.demo.entity.owner.Owner;
import ru.findplace.demo.entity.template.Template;
import ru.findplace.demo.entity.template.TemplateList;

public interface MailSender {
    ResponseEntity<Owner> getOwner();

    ResponseEntity<CampaignsList> getCompaignList();
    ResponseEntity<CampaignsBookLists> getCompanyLists();

    ResponseEntity<MembersList> getMemberListByListName(String name);
    ResponseEntity<Member> addMemberByListName(String name, Member member);

    ResponseEntity<MembersBookList> addCompanyList(MembersBookList membersBookList);

    ResponseEntity<TemplateList> getTemplateList();
    Template getTemplateByName(String name);
}
