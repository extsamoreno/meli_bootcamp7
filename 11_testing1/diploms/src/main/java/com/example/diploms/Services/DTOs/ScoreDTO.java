package com.example.diploms.Services.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class ScoreDTO extends StudentDTO{

    private String message;
    private double averageScore;
}
