package ru.findplace.demo.service.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.findplace.demo.Dtos.mailchimp.campaignbooklist.CampaignsBookItem;
import ru.findplace.demo.Dtos.mailchimp.campaignbooklist.CampaignsBookLists;
import ru.findplace.demo.exception.AddListException;
import ru.findplace.demo.service.MailSender;

@Service
public class ListServiceImpl implements ListService {

    private final MailSender mailSender;

    @Autowired
    public ListServiceImpl(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public CampaignsBookItem addCompanyList(CampaignsBookItem campaignsBookItem) throws AddListException {
        CampaignsBookLists lists = getCompanyLists();
        for (CampaignsBookItem l : lists.getLists()) {
            if(l.getName().equals(campaignsBookItem.getName())) {
                    throw new AddListException("Список с таким именем уже существует");
            }
        }
        return mailSender.doPost("/lists", campaignsBookItem, CampaignsBookItem.class);
    }

    @Override
    public CampaignsBookLists getCompanyLists() {
        return mailSender.doGet("/lists", CampaignsBookLists.class, true);
    }
}
