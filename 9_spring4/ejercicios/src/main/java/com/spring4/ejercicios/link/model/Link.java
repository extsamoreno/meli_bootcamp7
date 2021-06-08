package com.spring4.ejercicios.link.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Link {

    private String linkURL;
    private Integer linkId;
    private String linkPassword;
    private boolean linkValid;
    private int linkViews;

    public Link(String linkURL, String linkPassword) {
        this.linkURL = linkURL;
        this.linkPassword = linkPassword;
        this.linkValid = true;
        this.linkViews = 0;
    }
}
