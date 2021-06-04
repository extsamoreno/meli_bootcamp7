package com.meli.linktracker.domain;

import lombok.*;

import java.net.URI;
import java.net.URL;

@Getter
@Setter
@NoArgsConstructor
public class Link {
    private Integer id;
    private URI uri;
    private boolean isValid = true;
    private String password = null;
    private Integer redirects = 0;

    public Link(Integer id, URI uri) {
        this.id = id;
        this.uri = uri;
    }

    public Link(Integer id, URI uri, String password) {
        this.id = id;
        this.uri = uri;
        this.password = password;
    }
}
