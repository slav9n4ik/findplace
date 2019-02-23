package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.findplace.demo.Dtos.mailchimp.owner.Owner;
import ru.findplace.demo.Dtos.mailchimp.owner.Ping;
import ru.findplace.demo.response.OwnerResponse;
import ru.findplace.demo.response.base.Response;
import ru.findplace.demo.response.base.ResponseBuilder;
import ru.findplace.demo.response.base.ResponseWrapper;
import ru.findplace.demo.service.owner.OwnerService;

@RestController
@RequestMapping(value = "/api")
public class OwnerController extends ResponseBuilder {

    private final OwnerService ownerService;
    Logger LOG = LoggerFactory.getLogger(OwnerController.class);

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    /**
     * Данные о владельце
     * @return - Owner class
     */
    @GetMapping(value = "/owner")
    public ResponseEntity<ResponseWrapper> getOwnerParams() {
        LOG.info("Get owner params request");
        Response response;
        Owner owner;
        try {
            owner = ownerService.getOwner();
            response = OwnerResponse.OWNER_READ_SUCCESS;
            LOG.info("Owner response: " + owner.toString());
        } catch (Exception e) {
            owner = new Owner();
            response = OwnerResponse.OWNER_READ_CONFLICT;
            LOG.error("Owner response conflict: ",e);
        }
        return render(owner, response, HttpStatus.OK);
    }

    /**
     * Пинг
     * @return - Ping class
     */
    @GetMapping(value = "/ping")
    public ResponseEntity<ResponseWrapper> getPing() {
        LOG.info("Get ping params request");
        Response response;
        Ping ping;
        try {
            ping = ownerService.getPing();
            response = OwnerResponse.PING_READ_SUCCESS;
            LOG.info("Ping response: " + ping.toString());
        } catch (Exception e) {
            ping = null;
            response = OwnerResponse.PING_READ_CONFLICT;
            LOG.error("Ping response conflict: ",e);
        }
        return render(ping, response, HttpStatus.OK);
    }
}

