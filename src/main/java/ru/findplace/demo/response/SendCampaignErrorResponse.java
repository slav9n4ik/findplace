package ru.findplace.demo.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SendCampaignErrorResponse {
    private String type;
    private String title;
    private Integer status;
    private String detail;
    private String instance;
}
