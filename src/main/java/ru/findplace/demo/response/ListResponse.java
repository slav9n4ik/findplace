package ru.findplace.demo.response;

import ru.findplace.demo.response.base.Response;

import java.io.Serializable;

public enum ListResponse implements Response, Serializable {
    LIST_READ_SUCCESS(100, "Списки получены"),
    LIST_READ_CONFLICT(101, "Списки неполучены корректно"),
    LIST_ADD_SUCCESS(102, "Список добавлен"),
    LIST_ADD_CONFLICT(103, "Списки не добавлен корректно"),
    LIST_ADD_SAME(105, "Список с таким именем уже существует");

    private int code;
    private String reasonPhrase;

    ListResponse(int code, String reasonPhrase) {
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
