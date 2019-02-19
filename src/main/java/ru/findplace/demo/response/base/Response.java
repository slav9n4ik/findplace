package ru.findplace.demo.response.base;

public interface Response {
    int getCode();
    String getReasonPhrase();
    Response setReasonPhrase(String reasonPhrase);
}
