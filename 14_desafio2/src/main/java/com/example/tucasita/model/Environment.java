package com.example.tucasita.model;

import lombok.*;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Environment {
    private String environmentName;
    private Double evironmentWidth;
    private Double environmentLength;
    private Double squareMeters;
}
