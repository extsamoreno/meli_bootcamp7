package com.linktracker.demo.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private int id;
    private String url;
    private boolean active = true;
    private int requestCount = 0;
    private String password;

    public Link(String url){
        this.url = url;
    }

    public Link(String url, String password) {
        this.url = url;
        this.password = password;
    }
}
