package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

// Esto debe devolver el link
@Getter
@Setter
@AllArgsConstructor

public class UrlDTO {
    private Integer link;
    private String url;
    private Integer redirections;
    private boolean state;
    private String pass;


    public boolean getState() {
        return this.state;
    }


    public UrlDTO() {
        this.link = 0;
        this.url = "";
        this.redirections = 0;
        this.state = true;
        this.pass = "";
    }
}
