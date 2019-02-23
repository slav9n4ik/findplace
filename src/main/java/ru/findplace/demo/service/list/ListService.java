package ru.findplace.demo.service.list;

import ru.findplace.demo.Dtos.mailchimp.campaignbooklist.CampaignsBookItem;
import ru.findplace.demo.Dtos.mailchimp.campaignbooklist.CampaignsBookLists;

public interface ListService {
    CampaignsBookLists getCompanyLists();
    CampaignsBookItem addCompanyList(CampaignsBookItem campaignsBookItem);
}
