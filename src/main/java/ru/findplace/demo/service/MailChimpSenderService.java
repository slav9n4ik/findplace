package ru.findplace.demo.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.findplace.demo.entity.CompanyLists;
import ru.findplace.demo.entity.ContactList;
import ru.findplace.demo.entity.Owner;

import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class MailChimpSenderService implements MailSender {

    private static final String MAIL_API_BASE_URL = "https://us20.api.mailchimp.com/3.0";
    public static final String username = "slav9n4ik";
    private WebClient mailChimpClient;
    public MailChimpSenderService() {
        this.mailChimpClient = WebClient.builder()
                .baseUrl(MAIL_API_BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public Mono<Owner> getOwner(String apiKey) {
        return mailChimpClient.get()
                .uri("/")
                .header("Authorization", "Basic " + Base64Utils
                .encodeToString((username + ":" + apiKey)
                        .getBytes(UTF_8)))
                .retrieve()
                .bodyToMono(Owner.class);
    }

    @Override
    public Mono<CompanyLists> getCompanyLists(String apiKey) {
        Mono<CompanyLists> contactListMono = mailChimpClient.get().uri("/lists")
                .header("Authorization", "Basic " + Base64Utils
                        .encodeToString((username + ":" + apiKey)
                                .getBytes(UTF_8)))
        List<String> lististIds = new ArrayList<>();



        contactListMono.subscribe(value -> {
            value.getContactList().forEach(l -> {
                lististIds.add(l.getId());
            });
        });
        lististIds.forEach(System.out::println);
        return contactListMono;
    }
}
