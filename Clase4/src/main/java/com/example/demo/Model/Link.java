package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    int id;
    String link;
    String password;
    int count = 0;
    boolean status;

    public void increaseCount(){
        this.count++;
    }
}