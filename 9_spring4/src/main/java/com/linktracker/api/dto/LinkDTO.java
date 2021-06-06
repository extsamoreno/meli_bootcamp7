package com.linktracker.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class LinkDTO {
    private String url;
    private int redirectCounter;
    private boolean enable;
    private String password;
}
