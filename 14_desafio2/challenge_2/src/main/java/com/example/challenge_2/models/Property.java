package com.example.challenge_2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Property {
    private int id;
    private String name;
    private District district;
    private List<Environment> environments;
}
