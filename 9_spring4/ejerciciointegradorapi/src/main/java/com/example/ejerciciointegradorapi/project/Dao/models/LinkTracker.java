package com.example.ejerciciointegradorapi.project.Dao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkTracker {
    private Integer linkId;
    private String url;
    private Integer redirectCounter;
    private Boolean invalidate = false;


    public LinkTracker(Integer linkId, String url) {
        this.linkId = linkId;
        this.url = url;
        this.redirectCounter = 0;
    }
}