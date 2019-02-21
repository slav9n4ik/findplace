package ru.findplace.demo.service;

public interface MailSender {
    <T> T doGet(String url, Class<T> responseType, boolean header);
    <T> T doPost(String url, T responseBody, Class<T> responseType);
}
