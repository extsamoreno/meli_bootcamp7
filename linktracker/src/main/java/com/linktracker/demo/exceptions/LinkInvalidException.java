package com.linktracker.demo.exceptions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

public class LinkInvalidException extends LinkException {
    public LinkInvalidException(String url) {
        super("La url: "+ url +" es invalida.", HttpStatus.BAD_REQUEST);
    }
}