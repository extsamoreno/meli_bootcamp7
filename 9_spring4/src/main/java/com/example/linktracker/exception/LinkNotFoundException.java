package com.example.linktracker.exception;
import org.springframework.http.HttpStatus;

public class LinkNotFoundException extends LinkException {

    public LinkNotFoundException(Integer linkID) {
        super("ID: " + linkID + " doesn't exist", HttpStatus.NOT_FOUND);
    }
}
