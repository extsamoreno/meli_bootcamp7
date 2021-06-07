package com.linktracker.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private int id;
    private String url;
    private boolean valid;
    private String password;
    public Link(String url, boolean valid, String password){
        this.url = url;
        this.valid = valid;
        this.password = password;
    }
    public Link(int id, String url, boolean valid){
        this.url = url;
        this.valid = valid;
        this.id = id;
    }
    public Link(String url){
        this.url = url;
    }
}
