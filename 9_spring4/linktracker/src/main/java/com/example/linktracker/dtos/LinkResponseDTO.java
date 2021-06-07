package com.example.linktracker.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class LinkResponseDTO {
    private Integer id, redirects;
    private boolean isValid = true;
    private String password, url;

    public LinkResponseDTO(Integer id, Integer redirects, boolean isValid, String password, String url) {
        this.id = id;
        this.redirects = redirects;
        this.isValid = isValid;
        this.password = password;
        this.url = url;
    }
}
