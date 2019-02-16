package ru.findplace.demo.utils;

import org.springframework.http.HttpHeaders;

public interface HeaderUtils {
    String getBaseUrl();
    String getApiKey();
    HttpHeaders getHttpHeader();
}
