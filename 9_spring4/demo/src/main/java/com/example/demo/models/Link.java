package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    int ID;
    URL url;
    String password;
    int count;
    boolean active;

    public void increaseCount(){
        count++;
    }

    public void deactivate(){
        active = false;
    }

}
