package com.example.desafio2.project.services.Dto;

import com.example.desafio2.project.models.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {
    private String prop_name;
    private String prop_district_name;
    private ArrayList<Environment> prop_environment;
}
