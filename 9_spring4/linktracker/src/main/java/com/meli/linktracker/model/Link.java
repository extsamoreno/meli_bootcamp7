package com.meli.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {

    private Integer id;
    private String url;
    private String password;
    private Integer numRedirections;
    private boolean active;

}
