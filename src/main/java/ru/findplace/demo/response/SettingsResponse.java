package ru.findplace.demo.response;

import ru.findplace.demo.response.base.Response;

import java.io.Serializable;

public enum SettingsResponse implements Response, Serializable {
    PUT_SUCCESS(100, "Интерес успешно добавлен"),
    PUT_CONFLICT(101, "Интерес не добавлен"),
    UPDATE_SUCCESS(102, "Данные успешно обновлены"),
    UPDATE_CONFLICT(103, "Данные не обновлены"),
    DELETE_SUCCESS(104, "Интерес удален успешно"),
    DELETE_CONFLICT(105, "Интерес не удален");

    private int code;
    private String reasonPhrase;

    SettingsResponse(int code, String reasonPhrase) {
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
