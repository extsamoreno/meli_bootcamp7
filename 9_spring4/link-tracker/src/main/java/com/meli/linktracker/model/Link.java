package com.meli.linktracker.model;

import lombok.*;

import java.net.URI;

@Getter
@Setter
@NoArgsConstructor
public class Link {
    private Integer id = null;
    private URI uri;
    private boolean isValid = true;
    private String password;
    private Integer redirects = 0;

    public Link(URI uri, String password) {
        this.uri = uri;
        this.password = password;
    }
}