package com.example.challenge_2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Property {
    private int id;
    private String name;
    private District district;
    private List<Environment> environments;
}
