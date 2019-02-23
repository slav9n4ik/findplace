package ru.findplace.demo.service.owner;

import ru.findplace.demo.Dtos.mailchimp.owner.Owner;
import ru.findplace.demo.Dtos.mailchimp.owner.Ping;

public interface OwnerService {
    Owner getOwner();
    Ping getPing();
}
