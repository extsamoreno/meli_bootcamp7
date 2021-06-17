package com.example.ChallengeTwo.model;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {
    private String houseName;
    private District distric;
    private List<Environment> listEnvironment;

}
