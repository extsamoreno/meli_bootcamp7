package com.example.desafio2.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {
    private String environment_name;
    private double environment_widht;
    private double environment_lenght;
}
