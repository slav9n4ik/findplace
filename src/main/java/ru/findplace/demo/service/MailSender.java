package ru.findplace.demo.service;

import reactor.core.publisher.Mono;
import ru.findplace.demo.entity.CompanyLists;
import ru.findplace.demo.entity.ContactList;
import ru.findplace.demo.entity.Owner;

import java.util.List;

public interface MailSender {
    Mono<Owner> getOwner(String apiKey);
    Mono<CompanyLists>getCompanyLists(String api);
}
