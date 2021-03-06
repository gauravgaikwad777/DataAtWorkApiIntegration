package com.api.integration.dataatwork.service;

import com.api.integration.dataatwork.model.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

@Service
public class RequestBinService {
    @Autowired
    private Environment env;

    public String postJobs(JobDetail jobDetail) {

        String requestbinApiUrl = env.getProperty("requestbinAPI.url");
        String requestbinApiKeyProd = env.getProperty("requestbinAPI.prod.key");
        String requestbinApiKeyDev = env.getProperty("requestbinAPI.dev.key");

        final String uri = requestbinApiUrl + requestbinApiKeyProd;

        //Setting up the request headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        requestHeaders.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        //Request entity is created with request body and headers
        HttpEntity<JobDetail> requestEntity = new HttpEntity<>(jobDetail, requestHeaders);

        //Post all the jobs result to requestbin.net third party vendor
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =
                restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);

        return response.getBody();
    }
}