package com.example.LinkTracker.service.dto;

import lombok.*;
@Data
@AllArgsConstructor
public class LinkDTO {
    private Integer linkId;
    private String link, pass;
    private int count;

    public LinkDTO(String link) {
        this.count = 0;
    }

    public void  sumCount() {
        count++;
    }
}
