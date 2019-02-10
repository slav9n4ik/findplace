package ru.findplace.demo.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import ru.findplace.demo.entity.companylist.CompaniesBookLists;
import ru.findplace.demo.entity.companylist.Member;
import ru.findplace.demo.entity.companylist.MembersBookList;
import ru.findplace.demo.entity.companylist.MembersList;
import ru.findplace.demo.entity.owner.Owner;

public interface MailSender {
    ResponseEntity<Owner> getOwner(String apiKey);
    ResponseEntity<CompaniesBookLists> getCompanyLists(String api);
    ResponseEntity<MembersList> getMemberListByListName(String name, String apiKey);
    ResponseEntity<Member> addMemberByListName(String name, Member member, String apiKey);

    ResponseEntity<MembersBookList> addCompanyList(String apiKey, MembersBookList membersBookList);
}
