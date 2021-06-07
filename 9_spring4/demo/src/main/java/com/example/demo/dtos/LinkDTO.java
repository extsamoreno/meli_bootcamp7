package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.net.URL;

@Data
@AllArgsConstructor
public class LinkDTO {

    int ID;
    URL url;
    int count;
    boolean active;

}
