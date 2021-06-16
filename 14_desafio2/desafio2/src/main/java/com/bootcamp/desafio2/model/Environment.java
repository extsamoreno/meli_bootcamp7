package com.bootcamp.desafio2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Environment {

    private String environment_name;
    private double environment_width;
    private double environment_length;
}
