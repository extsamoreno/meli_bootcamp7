package com.example.spring4.dtos;

import com.example.spring4.models.Link;
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
