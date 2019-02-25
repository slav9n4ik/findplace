package ru.findplace.demo.service.list;

import ru.findplace.demo.Dtos.mailchimp.campaignbooklist.CampaignsBookItem;
import ru.findplace.demo.Dtos.mailchimp.campaignbooklist.CampaignsBookLists;
import ru.findplace.demo.exception.AddListException;

public interface ListService {
    CampaignsBookLists getCompanyLists();
    CampaignsBookItem addCompanyList(CampaignsBookItem campaignsBookItem) throws AddListException;
}
