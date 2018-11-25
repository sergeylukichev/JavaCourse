package com.telran.project.tracker.exception;

import org.springframework.http.HttpStatus;

public class ItemNotFoundException extends GeneralApiException {

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public ItemNotFoundException(Long itemId) {

        super(String.format("Item with ID [%d] not found", itemId));
    }
}
