package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.findplace.demo.entity.owner.Owner;
import ru.findplace.demo.service.MailSender;

@RestController
@RequestMapping(value = "/api")
public class HomeController {

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
    public Owner getOwnerParams() {
        LOG.info("Get owner params request");
        Owner owner = mailSender.getOwner().getBody();
        if (owner != null) {
            LOG.info("Owner response: " + owner.toString());
        }
        return owner;
    }
}

