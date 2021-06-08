package com.example.demo.project.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Url {

    private String url,password;
    private Integer counter, id;
    private boolean valid;

    public Url(String url) {
        this.url = url;
        this.valid = true;
        this.counter = 0;
        this.password = "";
    }
}
