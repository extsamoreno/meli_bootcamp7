package com.example.desafio2.models;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
    private String name;
    private String address;
    private String neighborhood;
    private List<EnvironmentDTO> environments;
}
