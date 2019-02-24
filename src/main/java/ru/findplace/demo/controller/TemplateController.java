package ru.findplace.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.findplace.demo.Dtos.mailchimp.template.Template;
import ru.findplace.demo.Dtos.mailchimp.template.TemplateList;
import ru.findplace.demo.response.TemplateResponse;
import ru.findplace.demo.response.base.Response;
import ru.findplace.demo.response.base.ResponseBuilder;
import ru.findplace.demo.response.base.ResponseWrapper;
import ru.findplace.demo.service.template.TemplateService;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api")
public class TemplateController extends ResponseBuilder {

    private final TemplateService templateService;
    Logger LOG = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping(value = "/templates")
    public ResponseEntity<ResponseWrapper> getTemplateList(){
        LOG.info("Get TemplateList request");
        TemplateList templateList;
        Response response;
        try {
            templateList = templateService.getTemplateList();
            response = TemplateResponse.READ_TEMPLATES_SUCCESS;
            LOG.info("Get TemplateList response: " + templateList);
        } catch (Exception e) {
            templateList = new TemplateList();
            response = TemplateResponse.READ_TEMPLATES_CONFLICT;
            LOG.error("Get TemplateList response conflict: " + e.getMessage());
        }
        return render(templateList, response, HttpStatus.OK);
    }
    @GetMapping(value = "/template")
    public ResponseEntity<ResponseWrapper> getTemplateByName(@RequestParam @NotNull String name){
        LOG.info("Get TemplateId by name request");
        Template template;
        Response response;
        try {
            template = templateService.getTemplateByName(name);
            response = TemplateResponse.READ_TEMPLATE_SUCCESS;
            LOG.info("Get TemplateId by name response: " + template);
        } catch (Exception e) {
            template = new Template();
            response = TemplateResponse.READ_TEMPLATE_CONFLICT;
            LOG.error("Get TemplateId by name response: " + e.getMessage());
        }
        return render(template, response, HttpStatus.OK);
    }
}
