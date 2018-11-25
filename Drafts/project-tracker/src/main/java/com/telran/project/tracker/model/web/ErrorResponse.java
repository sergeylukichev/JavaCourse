package com.telran.project.tracker.model.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorResponse {

    private String message;
    private String exceptionType;
    private Long timestamp;
    private String statusName;
    private int statusCode;
}
