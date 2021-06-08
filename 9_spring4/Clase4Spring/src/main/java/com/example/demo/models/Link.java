package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private int id;
    private int count=0;
    private String address;
    private boolean valid;
    private String password;

    public Link(String address, boolean valid, String password){
        this.address = address;
        this.valid = valid;
        this.password = password;
    }
}
