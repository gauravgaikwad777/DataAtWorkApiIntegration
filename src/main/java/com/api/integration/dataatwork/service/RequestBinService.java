package com.api.integration.dataatwork.service;

import com.api.integration.dataatwork.model.JobDetail;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

@Service
public class RequestBinService {
    public String postJobs(JobDetail jobDetail) {
        final String uri = "http://requestbin.net/r/1q0tnpq1";

        //setting up the request headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        requestHeaders.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        //request entity is created with request body and headers
        HttpEntity<JobDetail> requestEntity = new HttpEntity<>(jobDetail, requestHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =
                restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);

        return response.getBody();
    }

}