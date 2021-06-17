package com.meli.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentsTotalDTO {
    private String namneHouse;
    private ArrayList <EnvironmentSquareTotalDTO> environments;
}
