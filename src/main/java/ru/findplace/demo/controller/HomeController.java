package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.findplace.demo.entity.owner.Owner;
import ru.findplace.demo.response.OwnerResponse;
import ru.findplace.demo.response.Response;
import ru.findplace.demo.response.ResponseBuilder;
import ru.findplace.demo.response.ResponseWrapper;
import ru.findplace.demo.service.MailSender;

@RestController
@RequestMapping(value = "/api")
public class HomeController extends ResponseBuilder {

    private final MailSender mailSender;
    Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    public HomeController(MailSender mailSender) {
        this.mailSender = mailSender;
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
            owner = mailSender.getOwner().getBody();
            response = OwnerResponse.OWNER_READ_SUCCESS;
            LOG.info("Owner response: " + owner.toString());
        } catch (Exception e) {
            owner = new Owner();
            response = OwnerResponse.OWNER_READ_CONFLICT;
        }
        return render(owner, response, HttpStatus.OK);
    }
}

