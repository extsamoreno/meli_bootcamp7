package com.example.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    private Integer id;
    private String url;
    private int consultTimes;
    private boolean active;
    private String password;
}
