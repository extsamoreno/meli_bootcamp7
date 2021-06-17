package com.example.demo.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyM2EnvsResponseDTO {

    private String prop_name;
    private List<EnvironmentM2DTO> enviroments;
}

