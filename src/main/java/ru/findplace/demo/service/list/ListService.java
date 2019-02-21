package ru.findplace.demo.service.list;

import ru.findplace.demo.entity.campaignbooklist.CampaignsBookItem;
import ru.findplace.demo.entity.campaignbooklist.CampaignsBookLists;

public interface ListService {
    CampaignsBookLists getCompanyLists();
    CampaignsBookItem addCompanyList(CampaignsBookItem campaignsBookItem);
}
