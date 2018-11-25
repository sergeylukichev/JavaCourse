package com.telran.project.tracker.exception;

import org.springframework.http.HttpStatus;

public class PasswordsDoNotMatchException extends GeneralApiException {

    private static final String message = "Passwords in fields do not match";

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }

    public PasswordsDoNotMatchException() {
        super(message);
    }
}
