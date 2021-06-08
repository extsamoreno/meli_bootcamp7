package com.api.apiMask.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

@Getter
public class URLAlreadyUsedException extends LinkException{

    public URLAlreadyUsedException(String url) {
        super(MessageFormat.format("The url:{0} is already been used", url), HttpStatus.BAD_REQUEST);
    }
}
