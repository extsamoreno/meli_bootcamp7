package com.bootcamp.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private Integer id;
    private String url;
    private String password;
    private Integer totalRedirects;
}
