package ru.findplace.demo.response;

import java.io.Serializable;

public enum OwnerResponse implements Response, Serializable {
    OWNER_READ_SUCCESS(100, "Данные админа получены"),
    OWNER_READ_CONFLICT(101, "Данные админа неполучены");

    private int code;
    private String reasonPhrase;

    OwnerResponse(int code, String reasonPhrase) {
        this.code = code;
        this.reasonPhrase = reasonPhrase;
    }

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
