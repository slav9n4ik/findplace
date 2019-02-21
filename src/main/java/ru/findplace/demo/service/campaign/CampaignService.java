package ru.findplace.demo.service.campaign;

import ru.findplace.demo.entity.campaign.Campaign;
import ru.findplace.demo.entity.campaign.CampaignsList;
import ru.findplace.demo.response.SendCampaignErrorResponse;

public interface CampaignService {
    Campaign addCampaign();
    CampaignsList getCampaignList();
    SendCampaignErrorResponse sendCampaign(String name);
    Campaign getCampaignByName(String name);
}
