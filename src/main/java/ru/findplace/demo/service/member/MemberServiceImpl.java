package ru.findplace.demo.service.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import ru.findplace.demo.Dtos.mailchimp.campaignbooklist.*;
import ru.findplace.demo.Dtos.mailchimp.owner.Contact;
import ru.findplace.demo.exception.AddListException;
import ru.findplace.demo.service.MailSender;
import ru.findplace.demo.service.list.ListService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MemberServiceImpl implements MemberService {

    Logger LOG = LoggerFactory.getLogger(MemberServiceImpl.class);

    private final MailSender mailSender;
    private final ListService listService;
    private static Environment env;
    private static String EMAIL_FROM;

    @Autowired
    public MemberServiceImpl(Environment env, MailSender mailSender, ListService listService) {
        this.mailSender = mailSender;
        this.listService = listService;
        EMAIL_FROM = env.getProperty("mailchimp.api.mail");
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

    @Override
    public Member deleteMemberByListName(String listName, Member member) {
        String listId = getCampaignsBookItemIdByName(listName);
        Member memb = null;
        if (listId != null) {
            String memberId = getMemberIdInListByMemberName(listId, member);
            memb = mailSender.doDelete("/lists/" + listId + "/members/" +memberId,member, Member.class);
        }
        return memb;
    }

    private String getMemberIdInListByMemberName(String listId, Member member) {
        MembersList membersInList = mailSender.doGet("/lists/" + listId + "/members",MembersList.class, true);
        String id = membersInList
                .getMembers()
                .stream()
                .filter(m -> m.getEmailAddress().equals(member.getEmailAddress()))
                .findFirst()
                .get()
                .getId();
        return id;
    }

    private String getCampaignsBookItemIdByName(String name) {
        CampaignsBookLists bookLists = listService.getCompanyLists();
        CampaignsBookItem campaignsBookItem = null;
        try {
            if (bookLists != null) {
                campaignsBookItem = bookLists
                        .getLists()
                        .stream()
                        .filter(list -> list.getName().equals(name))
                        .findFirst()
                        .get();
            }
        } catch (NoSuchElementException e) {
            LOG.error("Нет списка с таким названием: " + e.getMessage());
            Contact contact = new Contact();
            contact.setAddr1("Gagarina");
            contact.setAddr2("2");
            contact.setState("");
            contact.setPhone("");
            contact.setCompany("FindPlace");
            contact.setCity("Moscow");
            contact.setZip("141701");
            contact.setCountry("RU");

            CampaignDefaults campaignDefaults = new CampaignDefaults();
            campaignDefaults.setFromEmail(EMAIL_FROM);
            campaignDefaults.setFromName("slav9n4ik");
            campaignDefaults.setSubject("");
            campaignDefaults.setLanguage("en");

            campaignsBookItem = new CampaignsBookItem();
            campaignsBookItem.setName(name);
            campaignsBookItem.setContact(contact);
            campaignsBookItem.setPermissionReminder("Вы получили это письмо, " +
                    "потому что Вы подписаль на рассылку в категории "+name+".");
            campaignsBookItem.setCampaignDefaults(campaignDefaults);
            campaignsBookItem.setEmailTypeOption(false);

            try {
                listService.addCompanyList(campaignsBookItem);
            } catch (AddListException e1) {
                e1.printStackTrace();
            }
        }

        return campaignsBookItem != null ? campaignsBookItem.getId() : null;
    }
}
