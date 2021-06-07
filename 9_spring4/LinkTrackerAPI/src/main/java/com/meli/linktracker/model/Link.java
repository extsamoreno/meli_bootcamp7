package com.meli.linktracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Link {
    private String url,password;
    private int id, counter=0;
    private boolean isInvalidate=false;
    @JsonIgnore
    private static int actualIdCounter=0;

    public Link(){
        this.id=actualIdCounter;
        actualIdCounter++;
    }

    public void addCounter(){
        counter++;
    }

}
