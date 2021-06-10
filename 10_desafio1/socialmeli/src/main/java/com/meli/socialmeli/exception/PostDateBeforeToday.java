package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class PostDateBeforeToday extends SocialException{
    public PostDateBeforeToday() {
        super("post date is before than today", HttpStatus.BAD_REQUEST);
    }
}
