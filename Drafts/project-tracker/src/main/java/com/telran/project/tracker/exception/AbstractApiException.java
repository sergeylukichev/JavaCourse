package com.telran.project.tracker.exception;

import org.springframework.http.HttpStatus;

public class AbstractApiException extends RuntimeException {

    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }


    public AbstractApiException() {
    }

    public AbstractApiException(String message) {
        super(message);
    }
}
