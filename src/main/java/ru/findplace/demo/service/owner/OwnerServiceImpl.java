package ru.findplace.demo.service.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.findplace.demo.Dtos.mailchimp.owner.Owner;
import ru.findplace.demo.Dtos.mailchimp.owner.Ping;
import ru.findplace.demo.service.MailSender;

@Service
public class OwnerServiceImpl implements OwnerService{

    private final MailSender mailSender;

    @Autowired
    public OwnerServiceImpl(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public Owner getOwner() {
        return mailSender.doGet("&fields=account_name,email,first_name,last_name", Owner.class, false);
    }

    @Override
    public Ping getPing() {
        return mailSender.doGet("/ping", Ping.class, true);
    }
}
