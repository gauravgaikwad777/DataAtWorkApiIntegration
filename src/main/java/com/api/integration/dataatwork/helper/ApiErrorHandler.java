package com.api.integration.dataatwork.helper;

import com.api.integration.dataatwork.manager.JobManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
public class ApiErrorHandler implements ResponseErrorHandler {
    Logger logger = LoggerFactory.getLogger(JobManager.class);

    @Override
    public boolean hasError(ClientHttpResponse httpResponse)
            throws IOException {

        return (
                httpResponse.getStatusCode().series() == CLIENT_ERROR
                        || httpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse)
            throws IOException {

        if (httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {

        } else if (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {

            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                logger.error("Status Not Found");
                throw new NotFoundException();
            }
        }
    }
}
