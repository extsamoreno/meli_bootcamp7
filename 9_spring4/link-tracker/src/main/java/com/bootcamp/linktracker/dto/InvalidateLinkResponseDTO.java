package com.bootcamp.linktracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidateLinkResponseDTO {
    private String message;
    private String url;

    public InvalidateLinkResponseDTO(String url) {
        this.message = "The link was invalidated";
        this.url = url;
    }
}
