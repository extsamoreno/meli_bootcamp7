package com.api.linktracker.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Link {

    private String url;
    private String password;
    boolean isValid;
    int redirectionCounter = 0;

    public Link(String url, boolean isValid) {
        this.url = url;
        this.isValid = isValid;
    }
}
