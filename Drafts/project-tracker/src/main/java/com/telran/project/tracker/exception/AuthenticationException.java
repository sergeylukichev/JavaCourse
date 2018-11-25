package com.telran.project.tracker.exception;

import org.springframework.http.HttpStatus;

public class AuthenticationException extends GeneralApiException {

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
