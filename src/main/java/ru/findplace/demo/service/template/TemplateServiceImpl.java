package ru.findplace.demo.service.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.findplace.demo.Dtos.mailchimp.template.Template;
import ru.findplace.demo.Dtos.mailchimp.template.TemplateList;
import ru.findplace.demo.service.MailSender;

@Service
public class TemplateServiceImpl implements TemplateService {

    private final MailSender mailSender;

    @Autowired
    public TemplateServiceImpl(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public TemplateList getTemplateList() {
        return mailSender.doGet("/templates", TemplateList.class, true);
    }

    @Override
    public Template getTemplateByName(String name) {
        TemplateList templateList = getTemplateList();
        Template template = templateList.getTemplates()
                .stream()
                .filter(tmpl -> tmpl.getName().equals(name))
                .findFirst().get();
        return template;
    }
}
