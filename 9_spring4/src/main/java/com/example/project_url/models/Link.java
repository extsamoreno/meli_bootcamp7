package com.example.project_url.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Link {
    private String url;
    private int id;
    private boolean active;
    private String password;
    private int visits;

    public void addVisit() {
        this.visits++;
    }
}
