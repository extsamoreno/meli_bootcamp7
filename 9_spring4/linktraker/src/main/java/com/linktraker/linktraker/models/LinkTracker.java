package com.linktraker.linktraker.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkTracker {
    private int id;
    private String url;
    private String password;
    private boolean enable;
    private int redirections;
}
