package com.api.apiMask.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

@Getter
public class LinkDontExistException extends LinkValidationException{
    public LinkDontExistException(Long linkId) {
        super(MessageFormat.format("No link exist with the linkId ''{0}''", linkId), HttpStatus.NOT_FOUND);
    }
}
