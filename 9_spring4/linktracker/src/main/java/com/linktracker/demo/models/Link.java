package com.linktracker.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private String url;
    private int id;

    public Link(String url){
        this.url = url;
    }
}
