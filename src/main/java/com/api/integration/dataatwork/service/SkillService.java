package com.api.integration.dataatwork.service;

import com.api.integration.dataatwork.model.Skills;
import org.apache.logging.log4j.util.Strings;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.joining;

@Service
public class SkillService {

    public String getSkillId(String skill) {
        final String uri = "http://api.dataatwork.org/v1/skills/autocomplete?";

        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("contains", skill);

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
        ParameterizedTypeReference<List<Skills>> skills = new ParameterizedTypeReference<List<Skills>>() {
        };

        ResponseEntity<List<Skills>> response =
                restTemplate.exchange(encodedURL, HttpMethod.GET, null, skills);
        if (response.getBody().isEmpty()) {
            return Strings.EMPTY;
        }
        return response.getBody().get(0).getUuid();

    }

    private String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }

}
