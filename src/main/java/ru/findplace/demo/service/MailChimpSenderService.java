package ru.findplace.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.findplace.demo.utils.HeaderUtils;

@Service
public class MailChimpSenderService implements MailSender {

    private RestTemplate restTemplate;
    private HeaderUtils headerUtils;

    @Autowired
    public MailChimpSenderService(HeaderUtils headerUtils) {
        this.headerUtils = headerUtils;
        restTemplate = new RestTemplate();
    }

    @Override
    public  <T> T doGet(String url, Class<T> responseType, boolean header)
    {
        HttpHeaders headers = headerUtils.getHttpHeader();
        ResponseEntity<T> responseEntity;
        if(header) {
            HttpEntity<String> entity = new HttpEntity<>("", headers);
            responseEntity = restTemplate.exchange(headerUtils.getBaseUrl() + url, HttpMethod.GET, entity, responseType);
        } else {
            responseEntity = restTemplate.getForEntity(headerUtils.getBaseUrl() + "/?apikey=" + headerUtils.getApiKey() + url, responseType);
        }
        return responseEntity.getBody();
    }

    @Override
    public <T> T doPost(String url, T responseBody, Class<T> responseType) {
        HttpHeaders headers = headerUtils.getHttpHeader();
        HttpEntity<T> entity = new HttpEntity<>(responseBody, headers);
        return restTemplate.postForEntity(headerUtils.getBaseUrl()+url ,entity, responseType).getBody();
    }
}
