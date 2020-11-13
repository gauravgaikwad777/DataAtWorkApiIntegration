package com.api.integration.dataatwork.service;

import com.api.integration.dataatwork.model.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
    @Autowired
    private Environment env;

    public JobDetail getJobs(String skillId) {

        String dataatworkApiUrl = env.getProperty("dataatworkAPI.url");

        final String uri = dataatworkApiUrl +
                "skills/"+
                skillId +
                "/related_jobs";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JobDetail> response =
                restTemplate.exchange(uri, HttpMethod.GET, null, JobDetail.class);

        return response.getBody();
    }

    private String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }
}
