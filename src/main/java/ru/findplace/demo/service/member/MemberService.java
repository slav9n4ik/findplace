package ru.findplace.demo.service.member;

import ru.findplace.demo.entity.campaignbooklist.Member;
import ru.findplace.demo.entity.campaignbooklist.MembersList;

public interface MemberService {
    MembersList getMemberListByListName(String name);
    Member addMemberByListName(String name, Member member);
}
