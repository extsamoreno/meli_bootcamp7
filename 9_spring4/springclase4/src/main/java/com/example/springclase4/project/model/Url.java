package com.example.springclase4.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Url {

    private String url;
    private Integer counter;
    private boolean active;
    private Integer linkId;

}
