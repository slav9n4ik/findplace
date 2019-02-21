package ru.findplace.demo.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public interface HeaderUtils {
    String getBaseUrl();
    String getApiKey();
    HttpHeaders getHttpHeader();
}
