package com.example.springboot.dtos;

import com.example.springboot.models.Link;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkStringDTO {
    private String linkUrl;

    public LinkStringDTO(Link link) {
        this.linkUrl = link.getLinkUrl();
    }
}
