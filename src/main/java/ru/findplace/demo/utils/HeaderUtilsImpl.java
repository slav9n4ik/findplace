package ru.findplace.demo.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;

import java.nio.charset.Charset;

public class HeaderUtilsImpl implements HeaderUtils{

    private static final String MAIL_API_BASE_URL = "https://us20.api.mailchimp.com/3.0";
    private static final String USERNAME = "slav9n4ik";
    private static String API_KEY;

    @Autowired
    public HeaderUtilsImpl(Environment env) {
        API_KEY = env.getProperty("mailchimp.api.key");
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
        return new HttpHeaders() {{
            String auth = USERNAME + ":" + API_KEY;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
            set( "Content-Type","application/json;charset=utf-8");
        }};
    }
}
