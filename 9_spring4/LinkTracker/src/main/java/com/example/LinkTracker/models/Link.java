package com.example.LinkTracker.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private String link;
    private String password;
    private Integer cant = 0;
    public void visita(){
        cant++;
    }
    public Link(String link, String password){
        this.link = link;
        this.password = password;
    }
}
