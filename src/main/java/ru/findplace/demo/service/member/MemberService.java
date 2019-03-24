package ru.findplace.demo.service.member;

import ru.findplace.demo.Dtos.mailchimp.campaignbooklist.Member;
import ru.findplace.demo.Dtos.mailchimp.campaignbooklist.MembersList;

public interface MemberService {
    MembersList getMemberListByListName(String name);
    Member addMemberByListName(String name, Member member);
    Member deleteMemberByListName(String listName, Member member);
}
