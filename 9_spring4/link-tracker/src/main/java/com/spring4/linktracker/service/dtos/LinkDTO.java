package com.spring4.linktracker.service.dtos;

import lombok.*;
@Getter @Setter
@NoArgsConstructor

public class LinkDTO {
    public static int nextId = 0;
    private int id, redirectCounter;
    private String url;

    public LinkDTO(String url) {
        this.id = LinkDTO.nextId;
        this.url = "https://" + url;
        this.redirectCounter = 0;
        LinkDTO.nextId ++;
    }
}
