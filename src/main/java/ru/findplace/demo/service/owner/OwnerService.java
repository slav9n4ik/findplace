package ru.findplace.demo.service.owner;

import ru.findplace.demo.entity.owner.Owner;
import ru.findplace.demo.entity.owner.Ping;

import java.io.IOException;

public interface OwnerService {
    Owner getOwner();
    Ping getPing();
}
