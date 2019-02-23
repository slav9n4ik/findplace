package ru.findplace.demo.service.template;

import ru.findplace.demo.Dtos.mailchimp.template.Template;
import ru.findplace.demo.Dtos.mailchimp.template.TemplateList;

public interface TemplateService {
    TemplateList getTemplateList();
    Template getTemplateByName(String name);
}
