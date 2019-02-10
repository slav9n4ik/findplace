package ru.findplace.demo.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public static final String username = "slav9n4ik";
    private RestTemplate restTemplate;
    public MailChimpSenderService() {
        restTemplate = new RestTemplate();
    }

    @Override
    public ResponseEntity<Owner> getOwner(String apiKey) {
        return restTemplate.getForEntity(MAIL_API_BASE_URL+"/?apikey=" + apiKey, Owner.class);
    }

    @Override
    public ResponseEntity<CompaniesBookLists> getCompanyLists(String apiKey) {
        return restTemplate.getForEntity(MAIL_API_BASE_URL+"/lists"+"/?apikey=" + apiKey, CompaniesBookLists.class);
    }

    @Override
    public ResponseEntity<MembersList> getMemberListByListName(String name, String apiKey) {
        CompaniesBookLists bookLists = getCompanyLists(apiKey).getBody();
        MembersBookList membersBookList = null;
        ResponseEntity<MembersList> response = null;
        if (bookLists != null) {
            membersBookList = bookLists
                    .getLists()
                    .stream()
                    .filter(list -> list.getName().equals(name))
                    .findFirst()
                    .get();
        }
        if (membersBookList != null) {
            StringBuilder query = new StringBuilder(MAIL_API_BASE_URL);
            query.append("/lists/").append(membersBookList.getId()).append("/members").append("/?apikey=").append(apiKey);
            response = restTemplate.getForEntity(query.toString(), MembersList.class);
        }
        return response;
    }

    @Override
    public ResponseEntity<Member> addMemberByListName(String name, Member member, String apiKey) {

        HttpHeaders headers = createHeaders("slav9n4ik",apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Member> httpEntity = new HttpEntity<>(member,headers);

        CompaniesBookLists bookLists = getCompanyLists(apiKey).getBody();
        MembersBookList membersBookList = null;
        ResponseEntity<Member> resultMember = null;
        if (bookLists != null) {
            membersBookList = bookLists
                    .getLists()
                    .stream()
                    .filter(list -> list.getName().equals(name))
                    .findFirst()
                    .get();
        }
        if (membersBookList != null) {
            StringBuilder query = new StringBuilder(MAIL_API_BASE_URL);
            query.append("/lists/").append(membersBookList.getId()).append("/members");
            resultMember = restTemplate.postForEntity(query.toString(),httpEntity, Member.class);
        }
        return resultMember;
    }

    @Override
    public ResponseEntity<MembersBookList> addCompanyList(String apiKey, MembersBookList membersBookList) {
        HttpHeaders headers = createHeaders("slav9n4ik",apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<MembersBookList> httpEntity = new HttpEntity<>(membersBookList,headers);
        return restTemplate.postForEntity(MAIL_API_BASE_URL+"/lists",httpEntity, MembersBookList.class);
    }

    HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
            set( "Content-Type","application/json");
        }};
    }
}
