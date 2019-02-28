package ru.findplace.demo.service.campaign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.findplace.demo.Dtos.mailchimp.campaign.Campaign;
import ru.findplace.demo.Dtos.mailchimp.campaign.CampaignsList;
import ru.findplace.demo.response.SendCampaignErrorResponse;
import ru.findplace.demo.service.MailSender;

@Service
public class CampaignServiceImpl implements CampaignService{

    private final MailSender mailSender;

    @Autowired
    public CampaignServiceImpl(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public CampaignsList getCampaignList() {
        return mailSender.doGet("/campaigns", CampaignsList.class, true);
    }

    @Override
    public Campaign getCampaignByName(String name) {
        CampaignsList campaignList = getCampaignList();
        Campaign campaign = null;
        if (campaignList != null) {
            campaign = campaignList
                    .getCampaigns()
                    .stream()
                    .filter(list -> list.getSettings().getTitle().equals(name))
                    .findFirst()
                    .get();
        }
        return campaign;
    }

    @Override
    public Campaign addCampaign(Campaign campaignRequestDto) {
    /*{
            "type": "regular",
            "recipients": {
                "list_id": "92d74e6167"
            },
            "settings": {
                "subject_line": "Test_subject",
                "preview_text": "My prewie text",
                "title": "TryAgainTestCampaign",
                "from_name": "Славян",
                "reply_to": "slav9n4ik.dev@gmail.com",
                "use_conversation": false,
                "to_name": "",
                "folder_id": "",
                "authenticate": true,
                "auto_footer": false,
                "inline_css": false,
                "auto_tweet": false,
                "fb_comments": true,
                "timewarp": false,
                "template_id": 8177,
                "drag_and_drop": true
            }
}*/
        return mailSender.doPost("/campaigns", campaignRequestDto, Campaign.class);
    }

    @Override
    public SendCampaignErrorResponse sendCampaign(String id) {
        SendCampaignErrorResponse sendCampaignErrorResponse = mailSender.doPost(
                    "/campaigns/" + id + "/actions/send",
                    new SendCampaignErrorResponse(),
                SendCampaignErrorResponse.class
            );
        return sendCampaignErrorResponse;
    }

    @Override
    public SendCampaignErrorResponse resendCampaign(String id) {
        SendCampaignErrorResponse resendCampaignErrorResponse = mailSender.doPost(
                "/campaigns/" + id + "/actions/create-resend",
                new SendCampaignErrorResponse(),
                SendCampaignErrorResponse.class
        );
        return resendCampaignErrorResponse;
    }
}
