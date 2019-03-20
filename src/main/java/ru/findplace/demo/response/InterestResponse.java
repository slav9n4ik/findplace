package ru.findplace.demo.response;

import ru.findplace.demo.response.base.Response;

import java.io.Serializable;

public enum InterestResponse implements Response, Serializable {
    INTEREST_READ_SUCCESS(100, "Список интересов получен"),
    INTEREST_READ_CONFLICT(101, "Список интересов не получен корректно");

    private int code;
    private String reasonPhrase;

    InterestResponse(int code, String reasonPhrase) {
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
