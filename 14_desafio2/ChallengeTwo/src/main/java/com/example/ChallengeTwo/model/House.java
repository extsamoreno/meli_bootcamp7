package com.example.ChallengeTwo.model;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {
    private String houseName;
    private Distric distric;
    private List<Environment> listEnvironment;

}
