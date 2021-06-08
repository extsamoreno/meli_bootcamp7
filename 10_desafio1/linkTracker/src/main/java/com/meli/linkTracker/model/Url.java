package com.meli.linkTracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class Url {
    private String id;
    private String url;
    private int visits;
    private boolean isActive;
    private String password;
}
