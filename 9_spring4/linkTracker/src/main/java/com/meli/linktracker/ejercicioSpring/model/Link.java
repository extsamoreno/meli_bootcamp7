package com.meli.linktracker.ejercicioSpring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private int linkid;
    private String password;
    private String link;
    private int views;
}
