package ru.findplace.demo.service;

import org.springframework.http.ResponseEntity;
import ru.findplace.demo.entity.companylist.CompaniesBookLists;
import ru.findplace.demo.entity.companylist.Member;
import ru.findplace.demo.entity.companylist.MembersBookList;
import ru.findplace.demo.entity.companylist.MembersList;
import ru.findplace.demo.entity.owner.Owner;

public interface MailSender {
    ResponseEntity<Owner> getOwner();
    ResponseEntity<CompaniesBookLists> getCompanyLists();
    ResponseEntity<MembersList> getMemberListByListName(String name);
    ResponseEntity<Member> addMemberByListName(String name, Member member);

    ResponseEntity<MembersBookList> addCompanyList(MembersBookList membersBookList);
}
