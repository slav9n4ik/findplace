package ru.findplace.demo.service.template;

import ru.findplace.demo.entity.template.Template;
import ru.findplace.demo.entity.template.TemplateList;

public interface TemplateService {
    TemplateList getTemplateList();
    Template getTemplateByName(String name);
}
