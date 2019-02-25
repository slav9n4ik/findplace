package ru.findplace.demo.response;

import ru.findplace.demo.response.base.Response;

import java.io.Serializable;

public enum RegistrationResponse implements Response, Serializable {
    REGISTRATION_SUCCESS(100, "Регистрация прошла успешно"),
    REGISTRATION_CONFLICT(101, "Ошибка при регистрации"),
    REGISTRATION_SAME(103, "Пользователь с таким email уже существует");

    private int code;
    private String reasonPhrase;

    RegistrationResponse(int code, String reasonPhrase) {
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
