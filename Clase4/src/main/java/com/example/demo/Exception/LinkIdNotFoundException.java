package com.example.demo.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LinkIdNotFoundException extends LinkException{
    public LinkIdNotFoundException(int id) {
        super("Id: "+ id+" not found.", HttpStatus.NOT_FOUND);
    }
}
