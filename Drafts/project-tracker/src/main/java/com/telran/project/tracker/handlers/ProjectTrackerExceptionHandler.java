package com.telran.project.tracker.handlers;

import com.telran.project.tracker.exception.AbstractApiException;
import com.telran.project.tracker.model.web.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ProjectTrackerExceptionHandler {


    @ExceptionHandler(value = AbstractApiException.class)
    public ResponseEntity<ErrorResponse> getResponse(AbstractApiException e) {

        ErrorResponse response = ErrorResponse.builder()
                .message(e.getMessage())
                .exceptionType(e.getClass().getName())
                .timestamp(new Date().getTime())
                .statusCode(e.getStatus().value())
                .statusName(e.getStatus().name())
                .build();

        return new ResponseEntity<>(response, e.getStatus());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> getResponse(Exception e) {

        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        ErrorResponse response = ErrorResponse.builder()
                .message(e.getMessage())
                .exceptionType(e.getClass().getName())
                .timestamp(new Date().getTime())
                .statusCode(httpStatus.value())
                .statusName(httpStatus.name())
                .build();

        return new ResponseEntity<>(response, httpStatus);
    }
}
