package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.findplace.demo.entity.campaign.CampaignsList;
import ru.findplace.demo.entity.template.Template;
import ru.findplace.demo.entity.template.TemplateList;
import ru.findplace.demo.service.MailSender;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api")
public class TemplateController {

    private final MailSender mailSender;
    Logger LOG = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    public TemplateController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @GetMapping(value = "/templates")
    public TemplateList getTemplateList(){
        LOG.info("Get TemplateList request");
        TemplateList templateList = mailSender.getTemplateList().getBody();
        LOG.info("Get TemplateList response: " + templateList);
        return templateList;
    }
    @GetMapping(value = "/template")
    public Template getTemplateByName(@RequestParam @NotNull String name){
        LOG.info("Get TemplateId by name request");
        Template template = mailSender.getTemplateByName(name);
        LOG.info("Get TemplateId by name response: " + template);
        return template;
    }
}
