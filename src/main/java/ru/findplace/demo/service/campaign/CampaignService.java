package ru.findplace.demo.service.campaign;

import ru.findplace.demo.entity.campaign.Campaign;
import ru.findplace.demo.entity.campaign.CampaignsList;
import ru.findplace.demo.response.SendCampaignErrorResponse;

public interface CampaignService {
    Campaign getCampaignByName(String name);
    CampaignsList getCampaignList();
    Campaign addCampaign(Campaign campaignRequestDto);
    SendCampaignErrorResponse sendCampaign(String id);
    SendCampaignErrorResponse resendCampaign(String id);
}
