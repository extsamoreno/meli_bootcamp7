package com.linktraker.linktraker.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {
    private int id;
    private String url;
    private int redirections;
    private boolean enable;
}
