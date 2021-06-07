package com.example.linktracker.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private Integer id, redirects;
    private boolean isValid = true;
    private String password, url;
}
