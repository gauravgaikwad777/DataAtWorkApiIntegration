package com.api.integration.dataatwork.service;

import com.api.integration.dataatwork.model.JobDetail;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

@Service
public class JobService {
    public JobDetail getJobs(String skillId) {
        final String uri = "http://api.dataatwork.org/v1/skills/" +
                skillId +
                "/related_jobs";

        Map<String, String> requestParams = new HashMap<>();

        String encodedURL = requestParams.keySet().stream()
                .map(key -> {
                    try {
                        return key + "=" + encodeValue(requestParams.get(key));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    return key;
                })
                .collect(joining("&", uri, ""));

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JobDetail> response =
                restTemplate.exchange(encodedURL, HttpMethod.GET, null, JobDetail.class);

        return response.getBody();
    }

    private String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }
}
