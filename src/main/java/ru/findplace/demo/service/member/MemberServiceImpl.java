package ru.findplace.demo.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.findplace.demo.entity.campaignbooklist.CampaignsBookItem;
import ru.findplace.demo.entity.campaignbooklist.CampaignsBookLists;
import ru.findplace.demo.entity.campaignbooklist.Member;
import ru.findplace.demo.entity.campaignbooklist.MembersList;
import ru.findplace.demo.service.MailSender;
import ru.findplace.demo.service.list.ListService;

@Service
public class MemberServiceImpl implements MemberService {

    private final MailSender mailSender;
    private final ListService listService;

    @Autowired
    public MemberServiceImpl(MailSender mailSender, ListService listService) {
        this.mailSender = mailSender;
        this.listService = listService;
    }

    @Override
    public MembersList getMemberListByListName(String name) {
        String id = getCampaignsBookItemIdByName(name);
        MembersList membersList = null;
        if (id != null) {
            membersList = mailSender.doGet("/lists/" + id + "/members", MembersList.class, true);
        }
        return membersList;
    }

    @Override
    public Member addMemberByListName(String name, Member member) {
        Member resultMember = null;
        String id = getCampaignsBookItemIdByName(name);
        if (id != null) {
            resultMember = mailSender.doPost("/lists/" + id + "/members",member, Member.class);
        }
        return resultMember;
    }

    private String getCampaignsBookItemIdByName(String name) {
        CampaignsBookLists bookLists = listService.getCompanyLists();
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
}
