package com.example.challenge_2.models;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Property {
    private int id;
    private String name;
    private District district;
    private List<Environment> environments;
}
