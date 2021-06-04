package com.example.springclase4.practicaintegradoratm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Url {

    private String url;
    private Integer counter;
    private boolean active;
    private Integer key;

}
