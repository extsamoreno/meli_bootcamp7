package com.meli.demo.model;

import com.meli.demo.dto.EnvironmentDTO;
import com.meli.demo.dto.HouseDTO;
import com.meli.demo.dto.NeighborhoodDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {

    private String name;
    private NeighborhoodDTO neighborhood;
    private ArrayList<EnvironmentDTO> environments;
}
