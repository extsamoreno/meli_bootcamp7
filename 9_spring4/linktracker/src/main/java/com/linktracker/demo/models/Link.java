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

    public Link(String url){
        this.url = url;
    }
}
