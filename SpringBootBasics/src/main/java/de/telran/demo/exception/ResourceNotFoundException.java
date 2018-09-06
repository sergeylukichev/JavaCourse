package de.telran.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private Long resourceId;

    public ResourceNotFoundException() {

    }

    public ResourceNotFoundException(String message, String resourceName, Long id) {
        super(message);
        this.resourceName = resourceName;
        this.resourceId = id;
    }

    @Override
    public String getMessage() {
        return super.getMessage()+ " "+resourceName + " " + resourceId;
    }
}
