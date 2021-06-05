package com.example.demo.Exception;

import org.springframework.http.HttpStatus;

public class BadPasswordExpection extends LinkException {
    public BadPasswordExpection() {
        super("Password is not correct.\n" +
                "Use format /api/link/{id}?pass={password}", HttpStatus.BAD_REQUEST);
    }
}
