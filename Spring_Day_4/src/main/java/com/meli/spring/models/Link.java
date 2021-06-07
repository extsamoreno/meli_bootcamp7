package com.meli.spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Link {
    private String linkID;
    private String url;
    private int contVisits;
    private boolean enabled;
    private String password;

    public Link() {
        this.enabled = true;
    }

    public Link(String linkID, String url, int contVisits, String password) {
        this.linkID = linkID;
        this.url = url;
        this.contVisits = contVisits;
        this.enabled = true;
        this.password = password;
    }


}
