package com.meli.API_link_tracker.model.exception;

import com.meli.API_link_tracker.model.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LinkTrackerException extends Exception{
    private final ErrorDTO error;
    private final HttpStatus status;

    public LinkTrackerException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setName(this.getClass().getSimpleName());
        this.status = status;
    }
}