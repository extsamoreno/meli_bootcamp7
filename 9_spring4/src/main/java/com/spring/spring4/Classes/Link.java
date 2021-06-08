package com.spring.spring4.Classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private int id;
    private String url;
    private int timesAcceded;
    private boolean valid;
    private String password;

    public Link(String url, String password) {
        this.url = url;
        this.password = password;
        this.timesAcceded = 0;
        this.valid = true;
    }

    public Link(int id) {
        this.id = id;
    }
}
