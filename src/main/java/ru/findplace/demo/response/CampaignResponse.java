package ru.findplace.demo.response;

import ru.findplace.demo.response.base.Response;

import java.io.Serializable;

public enum CampaignResponse implements Response, Serializable {
    READ_CAMPAIGNS_SUCCESS(100, "Список стратегий получен"),
    READ_CAMPAIGNS_CONFLICT(101, "Список стратегий неполучен корректно"),
    READ_CAMPAIGN_SUCCESS(102, "Стратегия получена по имени"),
    READ_CAMPAIGN_CONFLICT(103, "Стратегия не получена по имени"),
    CAMPAIGN_ADD_SUCCESS(104, "Стратегия добавлена"),
    CAMPAIGN_ADD_CONFLICT(105, "Стратегия не добавлена корректно"),
    CAMPAIGN_SEND_SUCCESS(106, "Стратегия отправлена"),
    CAMPAIGN_SEND_CONFLICT(107, "Стратегия не отправлена корректно"),
    CAMPAIGN_RESEND_CONFLICT(109, "Стратегия не пеотправлена корректно"),
    CAMPAIGN_RESEND_SUCCESS(108, "Стратегия переотправлена");

    private int code;
    private String reasonPhrase;

    CampaignResponse(int code, String reasonPhrase) {
        this.code = code;
        this.reasonPhrase = reasonPhrase;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getReasonPhrase() {
        return reasonPhrase;
    }

    @Override
    public Response setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
        return null;
    }
}
