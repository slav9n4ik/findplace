package ru.findplace.demo.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.findplace.demo.entity.companylist.CompaniesBookLists;
import ru.findplace.demo.entity.companylist.Member;
import ru.findplace.demo.entity.companylist.MembersBookList;
import ru.findplace.demo.entity.companylist.MembersList;
import ru.findplace.demo.entity.owner.Owner;

import java.nio.charset.Charset;

@Service
public class MailChimpSenderService implements MailSender {

    private static final String MAIL_API_BASE_URL = "https://us20.api.mailchimp.com/3.0";
    private static final String USERNAME = "slav9n4ik";
    private static String API_KEY;
    private RestTemplate restTemplate;
    private HttpHeaders httpHeader;

    @Autowired
    public MailChimpSenderService(Environment env) {
        API_KEY = env.getProperty("mailchimp.api.key");
        httpHeader = createHeaders();
        restTemplate = new RestTemplate();
    }

    @Override
    public ResponseEntity<Owner> getOwner() {
        return restTemplate.getForEntity(MAIL_API_BASE_URL+"/?apikey=" + API_KEY, Owner.class);
    }

    @Override
    public ResponseEntity<CompaniesBookLists> getCompanyLists() {
        return restTemplate.getForEntity(MAIL_API_BASE_URL+"/lists"+"/?apikey=" + API_KEY, CompaniesBookLists.class);
    }

    @Override
    public ResponseEntity<MembersList> getMemberListByListName(String name) {
        String id = getMemberBookIdByName(name);
        ResponseEntity<MembersList> responseMembersList = null;
        if (id != null) {
            StringBuilder query = new StringBuilder(MAIL_API_BASE_URL)
                    .append("/lists/")
                    .append(id)
                    .append("/members")
                    .append("/?apikey=")
                    .append(API_KEY);
            responseMembersList = restTemplate.getForEntity(query.toString(), MembersList.class);
        }
        return responseMembersList;
    }

    @Override
    public ResponseEntity<Member> addMemberByListName(String name, Member member) {
        HttpEntity<Member> httpEntity = new HttpEntity<>(member,httpHeader);
        ResponseEntity<Member> resultMember = null;
        String id = getMemberBookIdByName(name);
        if (id != null) {
            StringBuilder query = new StringBuilder(MAIL_API_BASE_URL)
                    .append("/lists/")
                    .append(id)
                    .append("/members");
            resultMember = restTemplate.postForEntity(query.toString(),httpEntity, Member.class);
        }
        return resultMember;
    }

    @Override
    public ResponseEntity<MembersBookList> addCompanyList(MembersBookList membersBookList) {

        HttpEntity<MembersBookList> httpEntity = new HttpEntity<>(membersBookList,httpHeader);
        return restTemplate.postForEntity(MAIL_API_BASE_URL+"/lists",httpEntity, MembersBookList.class);
    }

    private String getMemberBookIdByName(String name) {
        CompaniesBookLists bookLists = getCompanyLists().getBody();
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

    private HttpHeaders createHeaders(){
        return new HttpHeaders() {{
            String auth = USERNAME + ":" + API_KEY;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
            set( "Content-Type","application/json;charset=utf-8");
        }};
    }
}
