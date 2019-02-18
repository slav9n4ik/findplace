package ru.findplace.demo.response;

public interface Response {
    int getCode();
    String getReasonPhrase();
    Response setReasonPhrase(String reasonPhrase);
}
