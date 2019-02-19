package ru.findplace.demo.response;

import ru.findplace.demo.response.base.Response;

import java.io.Serializable;

public enum TemplateResponse implements Response, Serializable {
    READ_TEMPLATES_SUCCESS(100, "Список шаблонов получен"),
    READ_TEMPLATES_CONFLICT(101, "Список шаблонов неполучен корректно"),
    READ_TEMPLATE_SUCCESS(102, "Шаблон получен по имени"),
    READ_TEMPLATE_CONFLICT(103, "Шаблон не получен по имени");

    private int code;
    private String reasonPhrase;

    TemplateResponse(int code, String reasonPhrase) {
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
