package ru.findplace.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class HeaderUtilsImpl implements HeaderUtils{

    private static String MAIL_API_BASE_URL;
    private static String USERNAME;
    private static String API_KEY;
    private static Environment env;

    @Autowired
    public HeaderUtilsImpl(Environment env) {
        API_KEY = env.getProperty("mailchimp.api.key");
        USERNAME = env.getProperty("mailchimp.api.username");
        MAIL_API_BASE_URL = env.getProperty("mailchimp.api.baseurl");
    }

    @Override
    public String getBaseUrl() {
        return MAIL_API_BASE_URL;
    }

    @Override
    public String getApiKey() {
        return API_KEY;
    }

    @Override
    public HttpHeaders getHttpHeader() {
        String notEncoded = USERNAME + ":" + API_KEY;
        String encodedAuth = Base64.getEncoder().encodeToString(notEncoded.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic " + encodedAuth);
        return headers;
    }
}
