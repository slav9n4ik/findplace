package ru.findplace.demo.response;

import ru.findplace.demo.response.base.Response;

import java.io.Serializable;

public enum MemberResponse implements Response, Serializable {

    MEMBER_READ_SUCCESS(100, "Список контактов получен"),
    MEMBER_READ_CONFLICT(101, "Список контактов неполучен корректно"),
    MEMBER_ADD_SUCCESS(102, "Контакт добавлен"),
    MEMBER_ADD_CONFLICT(103, "Контакт не добавлен корректно");

    private int code;
    private String reasonPhrase;

    MemberResponse(int code, String reasonPhrase) {
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
